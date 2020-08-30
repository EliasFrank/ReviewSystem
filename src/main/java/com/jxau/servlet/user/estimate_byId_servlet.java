package com.jxau.servlet.user;

import com.jxau.daoImpl.DocumentDao;
import com.jxau.daoImpl.GamesDao;
import com.jxau.daoImpl.ItemsDao;
import com.jxau.daoImpl.PartDao;
import com.jxau.domain.Document;
import com.jxau.domain.Game;
import com.jxau.domain.Items;
import com.jxau.domain.Part;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "estimate_byId_servlet", urlPatterns = "/estimate_byId_servlet")
public class estimate_byId_servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		try {
			Items i = ItemsDao.select_byItemId(Integer.parseInt(id));
			request.setAttribute("user_id", i.getUserId());
			Game g = GamesDao.selectByGameName(i.getGameId());
			ArrayList<Part> p = PartDao.select_bygameId(i.getGameId());
			request.setAttribute("p", p);
			request.setAttribute("g", g);
			request.setAttribute("id", id);			
			Document dou = DocumentDao.select_byid(i.getItemId());
			request.setAttribute("dou", dou);		
			request.getRequestDispatcher("jsp/estimate.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
