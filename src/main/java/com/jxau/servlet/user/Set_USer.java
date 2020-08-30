package com.jxau.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jxau.daoImpl.*;
import com.jxau.domain.*;
import com.jxau.service.SelectService;

@WebServlet(name = "Set_USer", urlPatterns = "/Set_USer")
public class Set_USer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = null;
		try {
			User user1 = (User) request.getSession().getAttribute("user");
			int a = Integer.parseInt(user1.getUserId());
			user = UserDao.select_byId(a);
			request.setAttribute("user", user);

			ArrayList<MyItems> items = SelectService.getMyItems(user1.getUserId());
//			ArrayList<Grade> grades = GradeDao.select_ByuserId(Integer.parseInt(user.getUserId()));
//			ArrayList<Items> i = ItemsDao.selectByUserId(Integer.parseInt(user.getUserId()));

			request.setAttribute("items", items);
			request.getRequestDispatcher("jsp/personInfo.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
