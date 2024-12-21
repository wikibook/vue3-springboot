package kr.co.wikibook.gallery.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter // ①
@Entity // ②
@Table(name = "orders") // ③
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ④

    @Column(nullable = false)
    private Integer memberId; // ⑤

    @Column(length = 50, nullable = false)
    private String name; // ⑥

    @Column(length = 500, nullable = false)
    private String address; // ⑦

    @Column(length = 10, nullable = false)
    private String payment; // ⑧

    @Column(length = 16)
    private String cardNumber; // ⑨

    @Column(nullable = false)
    private Long amount; // ⑩

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created; // ⑪

    public Order() { // ⑫
    }

    public Order(Integer memberId, String name, String address, String payment, String cardNumber, Long amount) { // ⑫
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.payment = payment;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }
}