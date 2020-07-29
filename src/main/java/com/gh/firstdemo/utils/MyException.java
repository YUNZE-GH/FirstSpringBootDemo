package com.gh.firstdemo.utils;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/27 11:29
 */
public class MyException extends Exception {
    private static final long serialVersionID = 1L;
    public MyException(){
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
