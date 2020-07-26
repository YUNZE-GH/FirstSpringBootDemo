package com.gh.firstdemo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/7/25 21:54
 */
@Configuration  // 标识当前类为配置类
@EnableAutoConfiguration    // TODO 不明该注解意思
public class LocaleConfig implements WebMvcConfigurer {
    /**
     * 根据用户本次会话过程中的语义设定语言区域
     * （如用户进入首页前选择的语言种类）
     * @return
     */
    @Bean   // 表明这个方法需要交给Spring进行管理
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        // 默认语言
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }


    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        // 选择语言的参数名
        lci.setParamName("locale");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
