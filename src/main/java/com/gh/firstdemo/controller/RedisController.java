package com.gh.firstdemo.controller;

import com.gh.firstdemo.dao.StudentRepository;
import com.gh.firstdemo.entity.Emp;
import com.gh.firstdemo.service.EmpService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/2 0:02
 */
@Controller
public class RedisController {
    private Log log = LogFactory.getLog(this.getClass().getName());

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/redis/save/{key}/{value}", method = RequestMethod.POST)
    @ResponseBody
    public String redis_save(@PathVariable String key, @PathVariable String value){
        studentRepository.saveString(key, value);
        return "SUCCESS!";
    }

    @RequestMapping(value = "/redis/query/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String redis_query(@PathVariable String key){
        String str = studentRepository.getString(key);
        log.error(str);
        return str;
    }

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/cache/save/{key}/{value}", method = RequestMethod.POST)
    @ResponseBody
    public String cache_save(@PathVariable String key, @PathVariable String value){
        Emp emp = new Emp();
        emp.setId(key);
        emp.setName(value);
        empService.saveEmp(emp);
        return "SUCCESS!";
    }

    @RequestMapping(value = "/cache/query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String cache_query(){
        List<Emp> list = empService.getAll();
        return list.toString();
    }

    @RequestMapping(value = "/cache/del", method = RequestMethod.DELETE)
    @ResponseBody
    public String cache_del(){
        empService.del();
        return "SUCCESS!";
    }
}
