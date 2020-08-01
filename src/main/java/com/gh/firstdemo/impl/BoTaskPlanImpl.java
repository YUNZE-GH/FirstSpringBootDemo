package com.gh.firstdemo.impl;

import com.gh.firstdemo.dao.BoTaskPlanDao;
import com.gh.firstdemo.entity.BoTaskPlan;
import com.gh.firstdemo.service.BoTaskPlanService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/24 18:10
 */
@Service("BoTaskPlanImpl")
public class BoTaskPlanImpl implements BoTaskPlanService {

    @Autowired
    private BoTaskPlanDao dao;

    @SuppressWarnings("unused")
    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<String, String> valueOperations;

    @Override
    public List<BoTaskPlan> getAll() {
        List<BoTaskPlan> arrayList = new ArrayList<>();
        List<BoTaskPlan> list =  dao.getAll();
        valueOperations.set("task", JSONArray.fromObject(list).toString());
        Object obj = valueOperations.get("task");
        arrayList = JSONArray.fromObject(obj);
        return arrayList;
    }

    @Override
    public BoTaskPlan getOne(String id) {
        return dao.getOne(id);
    }

    @Override
    public BoTaskPlan getOne(BoTaskPlan bo) {
        return dao.getOneByBean(bo);
    }
}
