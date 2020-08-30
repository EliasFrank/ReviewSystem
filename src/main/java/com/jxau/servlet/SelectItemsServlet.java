package com.jxau.servlet;

import com.jxau.domain.CheckItem;
import com.jxau.domain.Items;
import com.jxau.domain.User;
import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SelectItemsServlet", urlPatterns = "/SelectItemsServlet")
public class SelectItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        int userId = Integer.parseInt(user.getUserId());
        ArrayList<CheckItem> items = SelectService.selectCheckItems(userId);
        request.setAttribute("items", items);
        request.getRequestDispatcher("/jsp/allItems.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
