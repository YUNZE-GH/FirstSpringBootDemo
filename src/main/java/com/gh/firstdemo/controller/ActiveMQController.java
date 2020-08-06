package com.gh.firstdemo.controller;

import com.gh.firstdemo.activemq.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/2 11:46
 */
@RestController
public class ActiveMQController {

    @Autowired
    private Producer producer;

    @RequestMapping(value = "/jms")
    public String jms(){
        Destination destination = new ActiveMQQueue("mytest.queue");
        for(int i=0; i<5; i++){
            producer.sendMessage(destination, "小张" + i);
        }
        return "SUCCESS";
    }
}
