package com.example.jdbc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandRun implements CommandLineRunner {

    @Autowired
    private UserJdbcRepository user;

    @Override
    public void run(String... args) throws Exception {
        user.insert(new Users("daeyub", "seoul mapo"));
        user.insert(new Users("daeyub2", "seoul mapo2"));
        user.insert(new Users("daeyub3", "seoul mapo3"));
        user.deleteId(1);
        System.out.println(user.findId(2));
        System.out.println(user.findId(3));
    }
}
