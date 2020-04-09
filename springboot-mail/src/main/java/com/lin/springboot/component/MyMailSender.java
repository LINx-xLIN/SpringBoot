package com.lin.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMailSender {
    @Autowired
    private MailSender mailSender;//邮件发送对象

    private Integer count = 1;

    @Scheduled(cron = "0 0/1 * * * ?")//每隔1分钟执行一次
    public void send() {
        //第一步：构建一个消息对象
        SimpleMailMessage message = new SimpleMailMessage();

        //第二步：封装发送的数据
        //内容
        message.setText("第"+count+++"封： Hello world!!!");
        message.setTo("1953816270@qq.com");
        message.setFrom("ooox_xooo@outlook.com");
        message.setSentDate(new Date());
        //主题
        message.setSubject("Hi");

        //第三步：发送
        mailSender.send(message);

    }
}
