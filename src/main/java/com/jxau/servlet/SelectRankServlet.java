package com.jxau.servlet;

import com.jxau.domain.GradeRank;
import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectRankServlet" , urlPatterns = "/SelectRankServlet")
public class SelectRankServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<GradeRank> ranks = SelectService.selectGradeRank(id);
        request.setAttribute("ranks", ranks);
        request.getRequestDispatcher("/jsp/ranks.jsp").forward(request,response);
    }
}
