package com.gh.firstdemo.dao;

import com.gh.firstdemo.entity.BoTaskPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/24 18:08
 */
@Repository
public interface BoTaskPlanDao {

    List<BoTaskPlan> getAll();
}
