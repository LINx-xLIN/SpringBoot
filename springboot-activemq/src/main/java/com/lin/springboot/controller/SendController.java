package com.lin.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @RequestMapping("/send")
    @ResponseBody
    public String send(final String msg) {
        jmsMessagingTemplate.convertAndSend("testQ", msg);
        return "success";
    }


    @RequestMapping("/index.do")
    public String index() {

        return "index";
    }

}
