package com.jxau.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.daoImpl.GamesDao;
import com.jxau.domain.Game;
import com.jxau.domain.User;

@WebServlet(name = "Creat_new_servlet", urlPatterns = "/Creat_new_servlet")
public class Creat_new_servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			User user1 = (User) request.getSession().getAttribute("user");
			int a = Integer.parseInt(user1.getUserId());
			ArrayList<Game> gameslist = GamesDao.select_checked(a);
			request.setAttribute("gameslist", gameslist);
			request.getRequestDispatcher("jsp/addProject.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
