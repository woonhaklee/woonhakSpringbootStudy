package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 컨트롤러 선언

@RequestMapping("/api/v1/get-api")
// 클래스 수준에서 @RequestMapping 을 설정하면 내부에 선언한 메서드의 URL 리소스 앞에 @RequestMapping 의 값이 공통 값으로 추가 됨
// 이에 컨트롤러에 #RestController 와 @RequestMapping 을 붙여 내부에 선언되는 메소드에서 사용할 공통 URl 설정
public class GetController {

    @RequestMapping( value = "/hello", method = RequestMethod.GET)
    // http://localgost:5050/api/v1/get-api/hello
    // @RequestMapping 으로 구현
    // @RequestMapping 어노테이션을 별다른 설정없이 선언하면 HTTP 의 모든 요청을 받음
    // 이에 GET 형식의 요청만 받기 위해서서는 어노테이션에 별도 설정이 필요함
    // @RequestMapping 어노테이션의 method="값" 을 GET 으로 설정하면 요청 형식을 GET 으로만 설정할 수 있음

    // 스프링4.3버전 이후 @RequestMapping 어노테이션을 더 이상 사용하지 않음
    // 각 HTTP 메서드에 맞는 어노테이션을 사용함
    // @GetMapping @PostMapping @DeleteMapping @PutMapping

    public String Hello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    // http://localgost:5050/api/v1/get-api/name
    // 별도의 매개변수가 없이 GET 메서드 구현
    // 매개변수가 없는 요청은 URL을 그대로 입력하고 요청할 떄 스스로 스프링부트 애플리케이션이 정해진 응답을 반환
    public String getName() {
        return "Klopp";
    }
}
