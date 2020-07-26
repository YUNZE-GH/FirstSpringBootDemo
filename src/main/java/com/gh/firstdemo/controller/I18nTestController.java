package com.gh.firstdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/25 22:11
 */
@Controller
@RequestMapping("i18n")
public class I18nTestController {

    @RequestMapping("/first")
    public String index(){
        return "i18n/first";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "i18n/admin";
    }

    @RequestMapping("/before")
    public String before(){
        return "i18n/before";
    }
}
