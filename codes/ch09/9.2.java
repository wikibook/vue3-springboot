package kr.co.wikibook.gallery.item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter // ①
@Entity // ②
@Table(name = "items") // ③
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ④

    @Column(length = 50, nullable = false)
    private String name; // ⑤

    @Column(length = 100, nullable = false)
    private String imgPath; // ⑥

    @Column(nullable = false)
    private Integer price; // ⑦

    @Column(nullable = false)
    private Integer discountPer; // ⑧

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created; // ⑨
}