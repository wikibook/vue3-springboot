package kr.co.wikibook.gallery.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ①
@RequestMapping("/v1") // ②
public class MainController {

    @GetMapping("/api/greeting")
    public String greet() { // ③
        return "Hello Spring"; // 문자열 출력
    }
}