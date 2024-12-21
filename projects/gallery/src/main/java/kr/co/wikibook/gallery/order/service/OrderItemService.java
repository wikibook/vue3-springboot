package kr.co.wikibook.gallery.order.service;

import kr.co.wikibook.gallery.order.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    // 주문 상품 목록 조회
    List<OrderItem> findAll(Integer orderId);

    // 주문 상품 데이터 저장
    void saveAll(List<OrderItem> orderItems);
}