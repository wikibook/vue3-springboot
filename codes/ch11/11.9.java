package kr.co.wikibook.gallery.block.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter // ①
@Entity // ②
@Table(name = "blocks") // ③
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ④

    @Column(length = 250, nullable = false)
    private String token; // ⑤

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created; // ⑥

    public Block() { // ⑦
    }

    public Block(String token) { // ⑦
        this.token = token;
    }
}