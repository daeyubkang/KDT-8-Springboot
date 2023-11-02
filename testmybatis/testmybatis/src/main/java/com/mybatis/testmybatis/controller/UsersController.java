package com.mybatis.testmybatis.controller;

import com.mybatis.testmybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;



}

/*
* @Autowired
* 이 어노테이션을 사용하면 Spring 컨테이너가 자동으로 해당 타입의 Bean을 필드나 메소드에 주입
* 1. 필드주입: Spring이 자동으로 필드에 주입
*       장점: 코드가 간결, 단점: 의존성을 변경시키거나 테스트에 어려움이 생길 수 있다.
* */