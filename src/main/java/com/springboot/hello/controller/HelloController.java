package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 기본 화면출력

@RestController
// 컨트롤러 선언
public class HelloController {
    @RequestMapping("/hello")
    // URL맵핑
    public String hello() {
        return "hello";
        //hello 반환
    }
}
