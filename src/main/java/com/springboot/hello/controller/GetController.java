package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/variable1/{variable}")
    // http://localgost:5050/api/v1/get-api/variable1/{string 값}
    // @PathVariable 을 활용한 GET 메서드 구현
    // 웹서버 통신의 기본 목적은 데이터를 주고 받는 것이기 떄문에 대부분 매개변수를 받는 메서드를 작성하게 됨
    // 매개변수를 받을 떄 자주 쓰이는 방법 중 하나는 URL 자체에 값을 담아 요청하는 것
    // URL을 보면 중괄호{}에 표시된 위치의 값을 받아 요청
    // 값을 간단히 전달할 떄 주로 사용하는 방법으로 GET 요청시 많이 쓰임
    // 규칙
    // @GetMapping 어노테이션의 값으로 URL 을 입력할 떄 중괄호{}를 사용해 어느 위치에서 값을 받을지 지정
    // 메서드 매개변수와 그 값을 연결하기 위해 @PathVariable을 명시하여 @GetMapping 어노테이션과 @PathVariable에 지정된 변수의 이름을 동일하게 맞춰야 함

    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    // http://localgost:5050/api/v1/get-api/variable2/{string 값}
    // @PathVariable 을 활용한 GET 메서드 구현
    // 만약 @GetMapping 어노테이션에 지정한 변수의 이름과 메서드 매개변수의 이름을 동일하게 맞추기 어렵다면 @PathVariable 뒤에 괄호를 열어 @GetMapping 어노테이션의 변수명을 지정한다.
    // 변수명인 variable 와 매개변수명인 var 가 서로 일치하지 않는 상황에서 @PathVariable 에는 변수의 이름을 특정할 수 있는 Value 요소가 존재하며,
    // 이 위치에 변수 이름을 정릐하면 매개변수와 매핑 할 수 있다.
    public String getVariable2(@PathVariable("variable") String var){
    // 풀어쓰면 public String getVariable2(@PathVariable(value = "variable") String var){
        return var;
    }

    @GetMapping(value = "/request1")
    // http://localgost:5050/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    // http://localgost:5050/api/v1/get-api/request1? 오른쪽으로 쿼리스트링(query string)이 명시
    // 쿼리스트링에는 키(변수의 이름)가 모두 적혀 있기 떄문에 이 값을 기준으로 메서드의 매개변수에 이름을 매핑하면 값을 가져올 수 있다
    // 키와 + @RequestParam 뒤에 적는 이름을 동일하게 설정하기 어렵다면, @PathVariable처럼
    // @PathVariable("variable") String var
    // @RequestParam("email") String address
    public String getRequest1Pram1(
            @RequestParam String name,
            @RequestParam("email") String address,
            @RequestParam String organization) {
                return nikname + " " + email + " " + organization;
    }
}
