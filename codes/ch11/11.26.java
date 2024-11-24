package kr.co.wikibook.gallery.member.repository;

import kr.co.wikibook.gallery.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    // 아이디와 패스워드로 회원 정보를 조회
    Optional<Member> findByLoginIdAndLoginPw(String loginId, String loginPw);

    // 아이디로 회원 정보 조회
    Optional<Member> findByLoginId(String loginId);
}