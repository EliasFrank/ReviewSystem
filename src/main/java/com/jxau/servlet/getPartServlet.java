package com.jxau.servlet;

import com.jxau.domain.Intro;
import com.jxau.domain.Items;
import com.jxau.domain.Part;
import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "getPartServlet", urlPatterns = "/getPartServlet")
public class getPartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemId = request.getParameter("itemId");
        String gameId = request.getParameter("gameId");

        //获取项目描述
        Map<Integer, Object> map = SelectService.getItem(itemId);
        Items item = (Items) map.get(1);
        String intro = (String) map.get(2);
        request.setAttribute("items", item);
        request.setAttribute("intro", intro);

        //获取评分标准
        ArrayList<Part> parts = SelectService.getParts(gameId);
        request.setAttribute("parts", parts);

        request.getRequestDispatcher("/jsp/estimate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
