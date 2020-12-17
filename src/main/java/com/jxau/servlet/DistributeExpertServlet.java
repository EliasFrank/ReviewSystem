package com.jxau.servlet;

import com.jxau.service.UpdateSrvice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DistributeExpertServlet", urlPatterns = "/DistributeExpertServlet")
public class DistributeExpertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String experts = request.getParameter("experts");
        System.out.println(experts+"?????");
        if (experts == null || "".equals(experts)){
            response.getWriter().print("尚未选择评审专家，请重新分配");
            return;
        }
        return;
        /*String[] expertIdString = experts.split(",");
        int[] expertsId = new int[expertIdString.length];
        for(int i = 0; i < expertsId.length; i ++)
            expertsId[i] = Integer.parseInt(expertIdString[i]);
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        if(UpdateSrvice.distributeExperts(expertsId, itemId))
            response.getWriter().print("分配成功");
        else response.getWriter().print("分配失败，请重新分配");*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
