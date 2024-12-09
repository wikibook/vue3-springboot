package kr.co.wikibook.gallery.common.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

public class HttpUtils {

    // 세션 입력
    public static void setSession(HttpServletRequest req, String key, Object value) {
        req.getSession().setAttribute(key, value);
    }

    // 세션 값 조회
    public static Object getSessionValue(HttpServletRequest req, String key) {
        return req.getSession().getAttribute(key);
    }

    // 세션 삭제
    public static void removeSession(HttpServletRequest req, String key) {
        req.getSession().removeAttribute(key);
    }

    // 쿠키 입력
    public static void setCookie(HttpServletResponse res, String name, String value, int expSeconds) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        if (expSeconds > 0) {
            cookie.setMaxAge(expSeconds);
        }

        res.addCookie(cookie);
    }

    // 쿠키 값 조회
    public static String getCookieValue(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    // 쿠키 삭제
    public static void removeCookie(HttpServletResponse res, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
    }

    // 토큰 조회
    public static String getBearerToken(HttpServletRequest req) {
        String authorization = req.getHeader("Authorization");

        if (authorization != null) {
            return authorization.replace("Bearer ", "").trim(); // Bearer 값 조회
        }

        return null;
    }
}