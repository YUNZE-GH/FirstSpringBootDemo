package com.gh.firstdemo.controller;

import com.gh.firstdemo.dao.StudentRepository;
import com.gh.firstdemo.entity.Emp;
import com.gh.firstdemo.service.EmpService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/2 0:02
 */
@RestController
@RequestMapping(value = "/redis", produces = MediaType.APPLICATION_JSON_VALUE)
public class RedisController {
    private Log log = LogFactory.getLog(this.getClass().getName());

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(value = "/save/{key}/{value}")
    public String redis_save(@PathVariable String key, @PathVariable String value){
        studentRepository.saveString(key, value);
        return "SUCCESS!!!";
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody(required = true) Emp emp){
        System.err.println("===============SAVE==================");
        System.err.println(emp.toString());
        empService.saveEmp(emp);
        return "Object Save to DB!!!";
    }

    @GetMapping(value = "/query/{key}")
    public String redis_query(@PathVariable String key){
        String str = studentRepository.getString(key);
        log.error(str);
        return str;
    }

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/cache/save/{key}/{value}", method = RequestMethod.POST)
    public String cache_save(@PathVariable String key, @PathVariable String value){
        Emp emp = new Emp();
        emp.setId(key);
        emp.setName(value);
        empService.saveEmp(emp);
        return "SUCCESS!";
    }

    @RequestMapping(value = "/cache/query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String cache_query(){
        List<Emp> list = empService.getAll();
        return list.toString();
    }

    @RequestMapping(value = "/cache/del", method = RequestMethod.DELETE)
    public String cache_del(){
        empService.del();
        return "SUCCESS!";
    }
}
