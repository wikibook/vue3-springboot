package kr.co.wikibook.gallery.cart.repository;

import kr.co.wikibook.gallery.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    // 장바구니 목록 조회(특정 회원)
    List<Cart> findAllByMemberId(Integer memberId);

    // 장바구니 정보 조회(특정 회원 및 특정 상품)
    Optional<Cart> findByMemberIdAndItemId(Integer memberId, Integer itemId);

    // 장바구니 삭제(특정 회원)
    void deleteByMemberId(Integer memberId);

    // 장바구니 삭제(특정 회원 및 특정 상품)
    void deleteByMemberIdAndItemId(Integer memberId, Integer itemId);
}