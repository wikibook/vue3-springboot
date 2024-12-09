package kr.co.wikibook.gallery.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String loginId;

    @Column(length = 64, nullable = false)
    private String loginPw;

    @Column(length = 16, nullable = false)
    private String loginPwSalt;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    public Member(){
    }

    public Member(String name, String loginId, String loginPw, String loginPwSalt) {
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.loginPwSalt = loginPwSalt;
    }
}