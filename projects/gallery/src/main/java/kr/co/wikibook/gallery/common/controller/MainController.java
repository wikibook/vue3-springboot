package kr.co.wikibook.gallery.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "{path:[^.]*}", "{path1:[^.]*}/{path2:[^.]*}"})
    public String index() {
        return "/index.html";
    }
}