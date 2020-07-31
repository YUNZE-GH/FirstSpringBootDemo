package com.gh.firstdemo.controller;

import com.gh.firstdemo.entity.BoTaskPlan;
import com.gh.firstdemo.service.BoTaskPlanService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/30 15:28
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/api", tags = "RESTfulController", description = "信息管理接口")
public class RESTfulController {
    @Autowired
    private BoTaskPlanService service;

    @RequestMapping(value = "/restful/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String restful(@PathVariable(value = "id",required = true) String id){   // 使用@PathVariable获取{XXX}中的XXX变量值
        BoTaskPlan bo = this.service.getOne(id);
        return bo.toString();
    }

    @RequestMapping(value = "/restful/{id}/{orderindex}", method = RequestMethod.GET)
    @ResponseBody
    public String info(@PathVariable(required = true) String id, @PathVariable(required = true) long orderindex){
        BoTaskPlan boTaskPlan = new BoTaskPlan();
        boTaskPlan.setId(id);
        boTaskPlan.setOrderindex(orderindex);
        BoTaskPlan bo = this.service.getOne(boTaskPlan);
        return bo.toString();
    }
}
