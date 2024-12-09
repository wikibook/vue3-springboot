package kr.co.wikibook.gallery.order.dto;

import kr.co.wikibook.gallery.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {

    private String name;
    private String address;
    private String payment;
    private String cardNumber;
    private Long amount;
    private List<Integer> itemIds;

    // 엔티티 객체로 변환
    public Order toEntity(Integer memberId) {
        return new Order(memberId, name, address, payment, cardNumber, amount);
    }
}