package com.gh.firstdemo.controller;

import com.gh.firstdemo.entity.BoTaskPlan;
import com.gh.firstdemo.entity.Student;
import com.gh.firstdemo.service.BoTaskPlanService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    @Value("${activemq.number}")    // activemq.number为application.properties中的key；
    private Integer num;        // 通过@Value注解将配置文件中key对应的value赋值给变量num；

    @Test
    public void demo1(){
        Student stu1 = new Student("1", "张三");
        Student stu2 = new Student("2", "李四");
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        System.err.println("List:" + list.toString());

        Gson gson = new Gson();
        String str = gson.toJson(list);
        System.err.println("List-->JSON:" + str);

        List<Student> arrayList = new ArrayList<>();
        arrayList = gson.fromJson(str, new TypeToken<List<Student>>() {}.getType());
        System.err.println("JSON-->List:" + arrayList.get(0).toString());
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        System.err.println("====>   " + num);
        List<BoTaskPlan> list = this.service.getAll();
        return list.toString();
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(HttpServletResponse response){
        //允许所有域名访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        return "Hello World!";
    }


}
