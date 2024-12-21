package kr.co.wikibook.gallery.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter // ①
@Entity // ②
@Table(name = "members") // ③
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ④

    @Column(length = 50, nullable = false)
    private String name; // ⑤

    @Column(length = 50, nullable = false, unique = true)
    private String loginId; // ⑥

    @Column(length = 100, nullable = false)
    private String loginPw; // ⑦

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created; // ⑧

    public Member() { // ⑨
    }

    public Member(String name, String loginId, String loginPw) { // ⑨
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }
}