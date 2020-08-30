package com.jxau.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.daoImpl.DocumentDao;
import com.jxau.daoImpl.IntroDao;
import com.jxau.daoImpl.ItemsDao;
import com.jxau.daoImpl.UserDao;
import com.jxau.domain.Document;
import com.jxau.domain.Intro;
import com.jxau.domain.Items;
import com.jxau.domain.User;

@WebServlet(name = "Select_all_work_servlet", urlPatterns = "/Select_all_work_servlet")
public class Select_all_work_servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			ArrayList<Items> itemslist = ItemsDao.select_all();
			request.setAttribute("itemslist",itemslist);
			ArrayList<User> users = UserDao.select_all();
			request.setAttribute("users",users);
			request.getRequestDispatcher("jsp/allItems.jsp").forward(request, response);
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
