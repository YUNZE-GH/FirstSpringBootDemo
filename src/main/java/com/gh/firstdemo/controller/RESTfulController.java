package com.gh.firstdemo.controller;

import com.gh.firstdemo.entity.BoTaskPlan;
import com.gh.firstdemo.service.BoTaskPlanService;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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

    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("arr", 1);
        array.add(json);
        json.put("arr", 2);
        array.add(json);
        System.err.println(array);
    }



    @RequestMapping(value = "/restful/{id}/{orderindex}", method = RequestMethod.GET)
    public String info(@PathVariable(required = true) String id, @PathVariable(required = true) long orderindex){
        BoTaskPlan boTaskPlan = new BoTaskPlan();
        boTaskPlan.setId(id);
        boTaskPlan.setOrderindex(orderindex);
        BoTaskPlan bo = this.service.getOne(boTaskPlan);
        return bo.toString();
    }

    @GetMapping(value = "/restful/{id}")
    public String restful(@PathVariable(value = "id",required = true) String id){   // 使用@PathVariable获取{XXX}中的XXX变量值
        BoTaskPlan bo = this.service.getOne(id);
        return bo.toString();
    }

    @PostMapping(value = "/restful")
    public String add(@RequestBody(required = true) BoTaskPlan bo){   // 使用@PathVariable获取{XXX}中的XXX变量值
        System.err.println(bo.toString());
        List<BoTaskPlan> list = new ArrayList<>();
        list.add(bo);
        service.addInfo(list);
        list = service.getAll();
        return list.toString();
    }

    @PutMapping(value = "/restful")
    public String update(@RequestBody(required = true) BoTaskPlan bo){   // 使用@PathVariable获取{XXX}中的XXX变量值
        System.err.println(bo.toString());
        service.updateById(bo);
        bo = service.getOne(bo.getId());
        return bo.toString();
    }

    @DeleteMapping(value = "/restful/{id}")
    public String delete(@PathVariable(required = true) String id){   // 使用@PathVariable获取{XXX}中的XXX变量值
        service.deleteById(id);
        List<BoTaskPlan> list = service.getAll();
        return list.toString();
    }
}
