package kr.co.wikibook.gallery.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import lombok.RequiredArgsConstructor;
import kr.co.wikibook.gallery.account.helper.AccountHelper;

@Component
@RequiredArgsConstructor
public class ApiInterceptor implements HandlerInterceptor {

    private final AccountHelper accountHelper;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
        // 로그인 회원 아이디가 없으면
        if (accountHelper.getMemberId(req) == null) {
            res.setStatus(401);
            return false;
        }

        return true;
    }
}