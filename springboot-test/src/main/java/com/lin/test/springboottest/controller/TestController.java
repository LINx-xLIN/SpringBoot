package com.lin.test.springboottest.controller;


import com.lin.test.springboottest.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TestController {

    @PostMapping("/add/user")
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }
}
