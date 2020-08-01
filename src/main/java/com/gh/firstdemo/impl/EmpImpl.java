package com.gh.firstdemo.impl;

import com.gh.firstdemo.dao.EmpDao;
import com.gh.firstdemo.entity.Emp;
import com.gh.firstdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/1 15:33
 */
@Service
public class EmpImpl implements EmpService {
    @Autowired
    private EmpDao dao;

    @Override
    @CacheEvict(value = "emp", allEntries = true)   // 触发缓存的清除操作，allEntries是否清除所有缓存内容
    public void saveEmp(Emp emp) {
        dao.saveEmp(emp);
        System.err.println("为key=" + emp.getId() + "数据做了缓存");
    }

    @Override
    @Cacheable(value = "emp")   // 先检查缓存中是否存在数据，如果存在，则返回缓存数据，如果不存在则存入缓存
    public List<Emp> getAll() {
        List<Emp> list = dao.getAll();
        return list;
    }

    @Override
    @CacheEvict(value = "emp")
    public void del() {

    }
}
