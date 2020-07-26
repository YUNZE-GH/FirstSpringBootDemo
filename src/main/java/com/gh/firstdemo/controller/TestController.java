package com.gh.firstdemo.controller;

import com.gh.firstdemo.entity.BoTaskPlan;
import com.gh.firstdemo.service.BoTaskPlanService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/22 23:47
 */
@Controller
public class TestController {
    private Log log = LogFactory.getLog(this.getClass().getName());

    @Autowired
    private BoTaskPlanService service;

    @Value("${test.number}")    // test.number为application.properties中的key；
    private Integer num;        // 通过@Value注解将配置文件中key对应的value赋值给变量num；

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        System.err.println("====>   " + num);
        List<BoTaskPlan> list = this.service.getAll();
        System.err.println(list.toString());
        log.trace("日志-->trace");
        log.debug("日志-->debug");
        log.info("日志-->info");
        log.warn("日志-->warn");
        log.error("日志-->error");
        return "SUCCESS";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
