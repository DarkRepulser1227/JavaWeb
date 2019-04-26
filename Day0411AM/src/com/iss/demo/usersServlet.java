package com.iss.demo;

import com.iss.entity.Users;
import com.iss.model.UserModel;
import com.iss.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/usersServlet")
public class usersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        String repwd=request.getParameter("repwd");

        if (pwd.equalsIgnoreCase(repwd)==true){
            Users users=new Users();
            users.setUname(name);
            users.setUpwd(pwd);
            UserModel.addUser(DBUtil.getConnection(),users);
            out.print("添加成功!");
        }else{
            out.print("两次密码不一致！");
        }



        out.flush();
        out.close();
    }
}
