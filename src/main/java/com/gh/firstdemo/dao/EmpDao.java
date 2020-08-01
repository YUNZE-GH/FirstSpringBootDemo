package com.gh.firstdemo.dao;

import com.gh.firstdemo.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/1 9:42
 */
@Repository
public interface EmpDao {

    void saveEmp(Emp emp);

    List<Emp> getAll();
}
