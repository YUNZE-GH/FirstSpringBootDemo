package com.gh.firstdemo.controller;

import com.gh.firstdemo.test.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/2 11:46
 */
@Controller
public class ActiveMQController {

    @Autowired
    private Producer producer;

    @RequestMapping(value = "/jms")
    @ResponseBody
    public String jms(){
        Destination destination = new ActiveMQQueue("mytest.queue");
        for(int i=0; i<5; i++){
            producer.sendMessage(destination, "myname is gaohan!!!");
        }
        return "SUCCESS";
    }
}
