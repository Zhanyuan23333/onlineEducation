package com.drill.edu.config;


import javax.servlet.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FileLoadFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

    //    System.out.println("通化完成1");
        HttpServletResponse response = (HttpServletResponse) res;

        //解决跨域的问题
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With,X-App-Id, X-Token");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
 //       System.out.println("通化完成2");
        chain.doFilter(req, res);

        // TODO Auto-generated method stub

    }




}

