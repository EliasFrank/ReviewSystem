package com.jxau.servlet;

import com.jxau.domain.Game;
import com.jxau.domain.Part;
import com.jxau.domain.User;
import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetStoreServlet", urlPatterns = "/GetStoreServlet")
public class GetStoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        User user = (User) request.getSession().getAttribute("user");
        String userId = user.getUserId();

        Game game = SelectService.getStoreGame(userId);
        ArrayList<Part> parts = SelectService.getStoreParts(game.getGameId());
        request.setAttribute("game", game);
        request.setAttribute("parts", parts);
        request.getRequestDispatcher("jsp/createRules.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
