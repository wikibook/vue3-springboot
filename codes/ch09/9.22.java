package kr.co.wikibook.gallery.cart.dto;

import kr.co.wikibook.gallery.cart.entity.Cart;
import lombok.Getter;

@Getter // ①
public class CartRequest {

    private Integer itemId; // ②

    // 엔티티 객체로 변환
    public Cart toEntity(Integer memberId) { // ③
        return new Cart(memberId, itemId);
    }
}