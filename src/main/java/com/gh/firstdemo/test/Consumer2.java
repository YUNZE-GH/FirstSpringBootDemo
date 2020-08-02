package com.gh.firstdemo.test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/1 23:54
 */
@Component
public class Consumer2 {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    @SendTo("out.queue")    // 该注解的意思是将return回的值，再发送的"out.queue"队列中
    public String receiveQueue(String text) {
        System.out.println("Consumer-2收到的报文为:"+text);
        return "return message"+text;
    }
}
