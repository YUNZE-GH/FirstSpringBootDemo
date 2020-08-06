package com.gh.firstdemo.impl;

import com.gh.firstdemo.dao.BoTaskPlanDao;
import com.gh.firstdemo.entity.BoTaskPlan;
import com.gh.firstdemo.service.BoTaskPlanService;
import com.gh.firstdemo.utils.PublicUtils;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Override
    public void updateById(BoTaskPlan bo) {
        dao.updateById(bo);
    }

    @Override
    public void addInfo(List<BoTaskPlan> list) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        for (BoTaskPlan bo : list) {
            bo.setId(UUID.randomUUID().toString());
            bo.setCreatetime(PublicUtils.StringToTimestamp(time));
            bo.setUpdatetime(PublicUtils.StringToTimestamp(time));
        }
        dao.addInfo(list);
    }

    @Override
    public void deleteById(String id) {
        dao.deleteById(id);
    }
}
