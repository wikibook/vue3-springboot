package kr.co.wikibook.gallery.order.service;

import kr.co.wikibook.gallery.order.dto.OrderRequest;
import kr.co.wikibook.gallery.order.dto.OrderRead;

import org.springframework.data.domain.Page; // ①
import org.springframework.data.domain.Pageable; // ②

public interface OrderService {

    // 주문 목록 조회
    Page<OrderRead> findAll(Integer memberId, Pageable pageable); // ③

    // 주문 상세 조회
    OrderRead find(Integer id, Integer memberId);

    // 주문 내역 저장
    void order(OrderRequest params, Integer memberId);
}