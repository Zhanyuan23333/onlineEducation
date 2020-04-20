package com.drill.edu.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean fileLoadFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FileLoadFilter());
        registration.addUrlPatterns("/*");
        registration.setName("FileLoadFilter");
        registration.setOrder(1);
        System.out.println("过滤器开始了");
        return registration;
    }
}
