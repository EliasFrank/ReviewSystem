package com.jxau.servlet;

import com.jxau.domain.User;
import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hl2333
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        User user = getUser(request);
        user = SelectService.selectUser(user);
        if(user == null){
            response.getWriter().print("<script language='javascript'>alert('账号密码错误，请重新填写');window.location.href='jsp/login.jsp';</script>");
        }
        request.getSession().setAttribute("user", user);
        if(user.getUserflag() == 2){
            request.getRequestDispatcher("/jsp/userPage.jsp").forward(request, response);
        }else if(user.getUserflag() == 0){
            request.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
        }else if(user.getUserflag() == 1){
            request.getRequestDispatcher("/jsp/expertSelect.jsp").forward(request, response);
        }else{
            response.getWriter().print("<script language='javascript'>alert('错误1！！身份不对');window.location.href='jsp/login.jsp';</script>");
        }
    }
    private User getUser(HttpServletRequest request){
        User user = new User();
        user.setNumber(request.getParameter("UserName"));
        user.setPassword(request.getParameter("Password"));

        return user;
    }
}
