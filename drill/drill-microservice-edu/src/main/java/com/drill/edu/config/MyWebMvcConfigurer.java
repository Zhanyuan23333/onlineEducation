package com.drill.edu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.ArrayList;
import java.util.List;

/**
 * WebMvc 扩展配置类，应用一启动，本类就会执行
 * Created by Administrator on 2019/3/17 0017.
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //就是说 url 中出现 resourceHandler 匹配时，则映射到 location 中去,location 相当于虚拟路径
        //映射本地文件时，开头必须是 file:/// 开头，表示协议
        registry.addResourceHandler("/edu/homework/**","/edu/material/**", "/edu/video/**").addResourceLocations("file:E:/workplace/drill/uploadFiles/homework/","file:E:/workplace/drill/uploadFiles/material/","file:E:/workplace/drill/uploadFiles/video/" );
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//        registry.addMapping("/**")
//                         .allowedOrigins("*")
//                         .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                         .maxAge(3600)
//                         .allowCredentials(true);
//
//    }


}
