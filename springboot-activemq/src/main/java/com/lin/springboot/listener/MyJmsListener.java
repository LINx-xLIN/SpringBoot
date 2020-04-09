package com.lin.springboot.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MyJmsListener {

    @JmsListener(destination = "testQ")
    public void onMessage(Message message) throws JMSException {

        TextMessage textMessage = (TextMessage)message;

        System.out.println("MyJmsListener的消费任务：" + textMessage.getText());
    }
}
