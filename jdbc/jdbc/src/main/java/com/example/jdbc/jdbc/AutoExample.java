package com.example.jdbc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
class AutowiredExample{
    public String sayHello(String name){
        return "Hello " + name;
    }
}

@Component
public class AutoExample {
    private final AutowiredExample autowired;

    @Autowired
    public AutoExample(AutowiredExample autowired){
        this.autowired = autowired;
    }

    @GetMapping("/hello")
    public String hello(){
        return autowired.sayHello("daeyub");
    }
}
