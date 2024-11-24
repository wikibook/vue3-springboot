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

import kr.co.wikibook.gallery.common.util.EncryptionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class BaseOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final ItemService itemService;
    private final CartService cartService;

    // 주문 목록 조회
    @Override
    public Page<OrderRead> findAll(Integer memberId, Pageable pageable) {
        Page<Order> orders = orderRepository.findAllByMemberIdOrderByIdDesc(memberId, pageable);
        return orders.map(Order::toRead);
    }

    // 주문 상세 조회
    @Override
    public OrderRead find(Integer id, Integer memberId) {
        // 값이 있으면 DTO로 변환해서 리턴, 없으면 null 리턴
        return orderRepository.findByIdAndMemberId(id, memberId).map(Order::toRead).orElse(null);
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