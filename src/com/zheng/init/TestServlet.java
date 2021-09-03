package com.zheng.init;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@MultipartConfig
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      request.setCharacterEncoding("utf-8");
//      String username=request.getParameter("username");
//      System.out.println(username);
//      String pwd=request.getParameter("pwd");
//      System.out.println(pwd);
//      String sex=request.getParameter("sex");
//      System.out.println(sex);
//      String[] hobbies=request.getParameterValues("hobby");
//      System.out.println(Arrays.toString(hobbies));
        //获取上传文件对象
      Part part = request.getPart("photo");
        System.out.println(part);
//        获取上传文件的名字
      String header =part.getHeader("Content-Disposition");
        System.out.println(header);
//form-data; name="photo"; filename="dlrb.jpg"
//        截取文件名字
      String photo=header.substring(header.lastIndexOf("=")+2,header.length()-1);
//    截取后名字  dlrb.jpg
        System.out.println(photo);
//        指定上传文件夹路径
      String path="D:/photo";
//         判断指定文件夹是否存在
        File file=new File(path);
        if (!file.exists()){
            file.mkdir();
        }
//      防止重名生成32位随机字符串
        photo= UUID.randomUUID()+photo;
        System.out.println(photo);
        //把文件放到指定文件夹
        part.write(path+"/"+photo);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
