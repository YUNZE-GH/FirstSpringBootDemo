package com.gh.firstdemo.impl;

import com.gh.firstdemo.dao.BoTaskPlanDao;
import com.gh.firstdemo.entity.BoTaskPlan;
import com.gh.firstdemo.service.BoTaskPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<BoTaskPlan> getAll() {
        return dao.getAll();
    }
}
