package kr.co.wikibook.gallery.order.dto;

import kr.co.wikibook.gallery.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter // ①
@Setter // ②
public class OrderRequest {

    private String name; // ③
    private String address; // ④
    private String payment; // ⑤
    private String cardNumber; // ⑥
    private Long amount; // ⑦
    private List<Integer> itemIds; // ⑧

    // 엔티티 객체로 변환
    public Order toEntity(Integer memberId) { // ⑨
        return new Order(memberId, name, address, payment, cardNumber, amount);
    }
}