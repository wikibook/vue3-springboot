package kr.co.wikibook.gallery.order.repository;

import kr.co.wikibook.gallery.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> { // ①

    // 주문 목록 조회
    List<Order> findAllByMemberIdOrderByIdDesc(Integer memberId); // ②

    // 주문 정보 조회(특정 아이디 및 특정 회원)
    Optional<Order> findByIdAndMemberId(Integer id, Integer memberId); // ③
}