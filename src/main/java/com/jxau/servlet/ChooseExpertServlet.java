package com.jxau.servlet;

import com.jxau.service.SelectService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.jxau.domain.Choose;

@WebServlet(name = "ChooseExpertServlet", urlPatterns = "/ChooseExpertServlet")
public class ChooseExpertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        JSONArray choices = JSONArray.fromObject(SelectService.selectChoose());
        response.getWriter().print(choices);
    }
}
