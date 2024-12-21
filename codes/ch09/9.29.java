package kr.co.wikibook.gallery.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter // ①
@Entity // ②
@Table(name = "order_items") // ③
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ④

    @Column(nullable = false)
    private Integer orderId; // ⑤

    @Column(nullable = false)
    private Integer itemId; // ⑥

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created; // ⑦

    public OrderItem() { // ⑧
    }

    public OrderItem(Integer orderId, Integer itemId) { // ⑧
        this.orderId = orderId;
        this.itemId = itemId;
    }
}