package com.jxau.servlet;

import com.jxau.service.UpdateSrvice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckExpertServlet", urlPatterns = "/CheckExpertServlet")
public class CheckExpertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String allId = request.getParameter("id");
        if (allId == null || "".equals(allId)){
            response.getWriter().print("尚未选择用户，请重新选择");
            return ;
        }
        String[] ids = allId.split(",");
        UpdateSrvice.checkAddExpert(ids, request.getParameter("userflag"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
