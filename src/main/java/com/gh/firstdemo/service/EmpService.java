package com.gh.firstdemo.service;

import com.gh.firstdemo.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/1 9:42
 */
public interface EmpService {

    void saveEmp(Emp emp);

    List<Emp> getAll();

    void del();
}
