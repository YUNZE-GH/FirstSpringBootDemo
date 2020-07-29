package com.gh.firstdemo.controller;

import com.gh.firstdemo.utils.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/27 11:22
 */
@Controller
@RequestMapping("error")
public class ErrorTestController {

    @RequestMapping("/db")
    public void db() throws SQLException {
        throw new SQLException("数据库异常！");
    }

    @RequestMapping("/my")
    public void my() throws MyException {
        throw new MyException("自定义异常！");
    }

    @RequestMapping("/no")
    public void no() throws Exception {
        throw new Exception("未知异常！");
    }
}
