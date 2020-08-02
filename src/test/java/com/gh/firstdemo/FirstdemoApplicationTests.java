package com.gh.firstdemo;

import com.gh.firstdemo.entity.BoTaskPlan;
import com.gh.firstdemo.service.BoTaskPlanService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class FirstdemoApplicationTests {

    @Autowired
    private BoTaskPlanService service;

    @Test
    void contextLoads() {
        BoTaskPlan bo = service.getOne("22311");
        System.err.println(bo.toString());
    }

}
