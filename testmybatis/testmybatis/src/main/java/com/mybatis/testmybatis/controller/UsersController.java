package com.mybatis.testmybatis.controller;

import com.mybatis.testmybatis.domain.Users;
import com.mybatis.testmybatis.dto.UsersDTO;
import com.mybatis.testmybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UsersDTO> usersList = usersService.getUsersList();
        System.out.println(usersList);

        //템플릿에 보내기 위해서 model.addAttribute() 사용
        model.addAttribute("list", usersList);

        return "user";
    }

    @GetMapping("/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String address, Model model){
        Users user = new Users();
        user.setName(name);
        user.setAddress(address);

        usersService.addUser(user);

        model.addAttribute("list", user);
        return "user";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam String name, @RequestParam String address, long id,Model model){
        Users user = new Users();
        user.setName(name);
        user.setAddress(address);
        user.setId(id);

        usersService.updateUser(user);

        model.addAttribute("list", user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam long id, Model model){
        usersService.deleteUser(id);

        return "redirect:/users";
    }



}

/*
* @Autowired
* 이 어노테이션을 사용하면 Spring 컨테이너가 자동으로 해당 타입의 Bean을 필드나 메소드에 주입
* 1. 필드주입: Spring이 자동으로 필드에 주입
*       장점: 코드가 간결, 단점: 의존성을 변경시키거나 테스트에 어려움이 생길 수 있다.
* 2. 생성자 주입: Spring이 생성자의 파라미터 타입에 맞는 빈을 찾아 주입
*               - 불변성을 보장(객체의 상태가 생성된 후 변경하지 않는다.)
* 
* @Autowired vs new
* 공통점: 객체를 생성하고 참조하는데 사용
* 차이점: 
*   - @Autowired: Spring이 IoC 컨테이너를 통해 의존성을 주입
*   - new: 개발자가 명시적으로 객체를 생성
* */