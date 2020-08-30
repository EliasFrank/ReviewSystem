package com.jxau.servlet;

import com.jxau.domain.User;
import com.jxau.service.AddService;
import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        User user = getUser(request);
        boolean isExist = SelectService.selectAccount(user.getNumber());
        if(!isExist){
            response.getWriter().print("<script language='javascript'>alert('该账号已被使用, 请重新填写');window.location.href='jsp/register.jsp';</script>");
        }else{
            AddService.addAccount(user);
            response.getWriter().print("<script language='javascript'>alert('注册成功，请登录');window.location.href='jsp/login.jsp';</script>");

        }

    }
    private User getUser(HttpServletRequest request){
        User user = new User();
        user.setUserflag(2);
        user.setEmail(request.getParameter("Email"));
        user.setName(request.getParameter("RealName"));
        user.setNumber(request.getParameter("UserName"));
        user.setTel(request.getParameter("Tel"));
        user.setPassword(request.getParameter("Password"));
        return user;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
