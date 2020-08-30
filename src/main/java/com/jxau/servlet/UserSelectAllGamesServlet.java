package com.jxau.servlet;

import com.jxau.domain.Game;
import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserSelectAllGamesServlet", urlPatterns = "/UserSelectAllGamesServlet")
public class UserSelectAllGamesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Game> games = SelectService.selectGames();
        request.setAttribute("games", games);
        request.getRequestDispatcher("/jsp/allGames.jsp").forward(request,response);
    }
}
