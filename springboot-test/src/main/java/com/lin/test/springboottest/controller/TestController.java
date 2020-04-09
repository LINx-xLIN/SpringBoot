package com.lin.test.springboottest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/index.do")
    public String index() {
        System.out.println("ss");
        return "index";
    }
}
