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

@WebServlet(name = "AddUserServlet", urlPatterns = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        User user = getUser(request);
        boolean isExist = SelectService.selectAccount(user.getNumber());
        if(!isExist){
            response.getWriter().print("该账号已被使用, 请重新填写");
        }else{
            AddService.addAccount(user);
            response.getWriter().print("添加成功");
        }

    }
    private User getUser(HttpServletRequest request){
        User user = new User();
        user.setUserflag(2);
        user.setEmail("");
        user.setName(request.getParameter("name"));
        user.setNumber(request.getParameter("number"));
        user.setTel("");
        user.setPassword(request.getParameter("pwd"));
        return user;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
