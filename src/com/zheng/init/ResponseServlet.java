package com.zheng.init;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/Response")
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //告诉浏览器以下载的方式打开文件
        //filename是下载后的文件名
        response.setHeader("Content-Disposition","attachment;filename=test.jpg");
        //输入流读取文件
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("dcm.jpeg");
        //输出流写文件
        ServletOutputStream out = response.getOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = in.read(b)) != -1){
            out.write(b, 0, len);
        }
        out.close();
        in.close();
    }

    }

