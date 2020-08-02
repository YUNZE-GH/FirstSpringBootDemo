package com.gh.firstdemo.test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/1 23:54
 */
@Component
public class Consumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer-1收到的报文为:" + text);

    }
}
