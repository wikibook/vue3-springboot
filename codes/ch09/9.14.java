package kr.co.wikibook.gallery.account.dto;

import lombok.Getter;

@Getter // ①
public class AccountLoginRequest {

    private String loginId; // ②
    private String loginPw; // ③
}