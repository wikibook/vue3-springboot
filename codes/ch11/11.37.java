package kr.co.wikibook.gallery.order.service;

import kr.co.wikibook.gallery.cart.service.CartService;
import kr.co.wikibook.gallery.item.dto.ItemRead;
import kr.co.wikibook.gallery.item.service.ItemService;
import kr.co.wikibook.gallery.order.dto.OrderRequest;
import kr.co.wikibook.gallery.order.entity.Order;
import kr.co.wikibook.gallery.order.entity.OrderItem;
import kr.co.wikibook.gallery.order.dto.OrderRead;
import kr.co.wikibook.gallery.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import kr.co.wikibook.gallery.common.util.EncryptionUtils;

import org.springframework.data.domain.Page; // ①
import org.springframework.data.domain.Pageable; // ②

@Service
@RequiredArgsConstructor
public class BaseOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final ItemService itemService;
    private final CartService cartService;

    // 주문 목록 조회
    @Override
    public Page<OrderRead> findAll(Integer memberId, Pageable pageable) { // ③
        Page<Order> orders = orderRepository.findAllByMemberIdOrderByIdDesc(memberId, pageable);
        return orders.map(Order::toRead);
    }

    // 주문 상세 조회
    @Override
    public OrderRead find(Integer id, Integer memberId) {
        Optional<Order> orderOptional = orderRepository.findByIdAndMemberId(id, memberId);

        if (orderOptional.isPresent()) {
            // 주문 조회 DTO로 변환
            OrderRead order = orderOptional.get().toRead();

            // 주문 상품 목록 조회
            List<OrderItem> orderItems = orderItemService.findAll(order.getId());

            // 주문 상품 목록의 상품 아이디를 추출
            List<Integer> orderItemIds = orderItems.stream().map(OrderItem::getItemId).toList();

            // 주문 상품 리스트의 상품 ID에 해당하는 상품 목록을 조회
            List<ItemRead> items = itemService.findAll(orderItemIds);

            // 응답 값에 상품 리스트 데이터를 설정
            order.setItems(items);

            return order;
        }

        return null;
    }

    // 주문 내용 저장
    @Override
    @Transactional
    public void order(OrderRequest orderReq, Integer memberId) {
        // 주문 상품의 최종 결제 금액을 계산
        List<ItemRead> items = itemService.findAll(orderReq.getItemIds());
        long amount = 0L;

        for (ItemRead item : items) {
            amount += item.getPrice() - item.getPrice().longValue() * item.getDiscountPer() / 100;
        }

        // 주문 요청에 최종 결제 금액 입력
        orderReq.setAmount(amount);

        // 결제 수단이 카드일 때 카드 번호 암호화
        if ("card".equals(orderReq.getPayment())) {
            orderReq.setCardNumber(EncryptionUtils.encrypt(orderReq.getCardNumber()));
        }

        // 주문 저장
        Order order = orderRepository.save(orderReq.toEntity(memberId));

        // 주문 상품 데이터 생성
        List<OrderItem> newOrderItems = new ArrayList<>();

        // 상품 아이디만큼 주문 상품 추가
        orderReq.getItemIds().forEach((itemId) -> {
            OrderItem newOrderItem = new OrderItem(order.getId(), itemId);
            newOrderItems.add(newOrderItem);
        });

        // 주문 상품 데이터 저장
        orderItemService.saveAll(newOrderItems);

        // 장바구니 데이터 삭제(특정 회원)
        cartService.removeAll(order.getMemberId());
    }
}