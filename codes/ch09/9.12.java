package kr.co.wikibook.gallery.member.service;

import kr.co.wikibook.gallery.member.entity.Member;
import kr.co.wikibook.gallery.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // ①
@RequiredArgsConstructor // ②
public class BaseMemberService implements MemberService {

    private final MemberRepository memberRepository; // ③

    // 회원 데이터 저장
    @Override
    public void save(String name, String loginId, String loginPw) { // ④
        memberRepository.save(new Member(name, loginId, loginPw));
    }

    // 회원 데이터 조회
    @Override
    public Member find(String loginId, String loginPw) { // ④
        Optional<Member> memberOptional = memberRepository.findByLoginIdAndLoginPw(loginId, loginPw);

        // 회원 데이터가 있으면 해당 값 리턴(없으면 NULL 리턴)
        return memberOptional.orElse(null);
    }
}