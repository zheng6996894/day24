package com.zheng.init;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestTest")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求行
        //获取请求方法
       System.out.println(request.getMethod());
        //获取请求资源
        System.out.println(request.getRequestURI());
        //获取请求完整路径
        System.out.println(request.getRequestURL());
        //获取请求协议其版本
        System.out.println(request.getProtocol());
        //获取请求ip地址
        System.out.println(request.getServerName());
        //获取请求端口号
        System.out.println(request.getServerPort());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //请求头
        //根据某请求头获取该头对应的值
        System.out.println(request.getHeader("sec-ch-ua"));
        //获取所有的请求头名字
        Enumeration<String> names = request.getHeaderNames();
        //变量请求头
        while (names.hasMoreElements()){
            //获取所有请求头
            String name=names.nextElement();
            //根据头获取对应的值
            String value=request.getHeader(name);

//            System.out.println(name+"::"+value);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
