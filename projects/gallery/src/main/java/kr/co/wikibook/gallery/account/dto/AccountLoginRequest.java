package kr.co.wikibook.gallery.account.dto;

import lombok.Getter;

@Getter
public class AccountLoginRequest {

    private String loginId;
    private String loginPw;
}