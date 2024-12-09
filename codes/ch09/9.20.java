package kr.co.wikibook.gallery.cart.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter // ①
@Entity // ②
@Table(name = "carts") // ③
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ④

    @Column(nullable = false)
    private Integer memberId; // ⑤

    @Column(nullable = false)
    private Integer itemId; // ⑥

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created; // ⑦

    public Cart() { // ⑧
    }

    public Cart(Integer memberId, Integer itemId) { // ⑧
        this.memberId = memberId;
        this.itemId = itemId;
    }
}