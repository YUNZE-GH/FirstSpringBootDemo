package com.gh.firstdemo.controller;

import com.gh.firstdemo.utils.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/29 23:00
 */
@ControllerAdvice   // 使用@ControllerAdvice注解可以进行全局异常处理、全局数据绑定、全局数据预处理
public class GlobalExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)  // 该注解可以捕获到当前Controller所有的异常
    public String handlerException(Exception e) {
        if (e instanceof SQLException) {
            return "error/sqlerror";
        } else if (e instanceof MyException) {
            return "error/myerror";
        } else {
            return "error/noerror";
        }
    }
}
