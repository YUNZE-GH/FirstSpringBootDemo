package com.gh.firstdemo.service;

import com.gh.firstdemo.entity.BoTaskPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/24 18:08
 */
public interface BoTaskPlanService {
    List<BoTaskPlan> getAll();

    BoTaskPlan getOne(String id);

    BoTaskPlan getOne(BoTaskPlan bo);

    void updateById(BoTaskPlan bo);

    void addInfo(List<BoTaskPlan> list);

    void deleteById(String id);
}
