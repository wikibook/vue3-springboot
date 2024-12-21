package kr.co.wikibook.gallery.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter // ①
@Setter // ②
public class AccountJoinRequest {

    private String name; // ③
    private String loginId; // ④
    private String loginPw; // ⑤
}