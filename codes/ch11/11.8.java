package kr.co.wikibook.gallery.account.etc;

public class AccountConstants {

    // 회원 아이디 이름
    public static final String MEMBER_ID_NAME = "memberId";

    // 액세스 토큰 이름
    public static final String ACCESS_TOKEN_NAME = "accessToken"; // ①

    // 리프레시 토큰 이름
    public static final String REFRESH_TOKEN_NAME = "refreshToken"; // ②

    // 액세스 토큰 유효 시간(1분)
    public static final int ACCESS_TOKEN_EXP_MINUTES = 1; // ③

    // 리프레시 토큰 유효 시간(24시간)
    public static final int REFRESH_TOKEN_EXP_MINUTES = 60 * 24; // ④
}