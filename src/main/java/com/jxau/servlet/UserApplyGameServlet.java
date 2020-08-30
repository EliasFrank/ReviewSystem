package com.jxau.servlet;

import com.jxau.domain.User;
import com.jxau.service.AddService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserApplyGameServlet", urlPatterns = "/UserApplyGameServlet")
public class UserApplyGameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int gameId = Integer.parseInt(request.getParameter("gameId"));
        AddService.addApplyGame(user.getUserId(), gameId);
        request.getRequestDispatcher("UserSelectAllGamesServlet").forward(request,response);
    }
}
