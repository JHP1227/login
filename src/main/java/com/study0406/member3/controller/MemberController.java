package com.study0406.member3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    // 기본페이지 요청 메서드
    @GetMapping("/")
    public String index() {
        return "index"; // template폴더의 index.html파일을 띄우겠다는 것
    }
}
