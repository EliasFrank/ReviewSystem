package com.jxau.servlet.user;

import com.jxau.daoImpl.GradeDao;
import com.jxau.domain.Grade;
import com.jxau.domain.PartGrade;
import com.jxau.domain.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Estimate_submit_servlet", urlPatterns = "/Estimate_submit_servlet")
public class Estimate_submit_servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String gameId = request.getParameter("gameid");
		String userId = request.getParameter("userid");
		String id = request.getParameter("id");
		String[] partflags = request.getParameterValues("partflag");
		String[] grades = request.getParameterValues("grade");
		String[] partexplains = request.getParameterValues("partexplain");
		double d = 0;
		for(int i=0;i<partexplains.length;i++) {
			
				d = d + Double.parseDouble(grades[i]);
				PartGrade p = new PartGrade(0, Double.parseDouble(grades[i]), partexplains[i], Integer.parseInt(partflags[i]),Integer.parseInt(user.getUserId()), Integer.parseInt(id));
		}
		Grade g =new Grade(Integer.parseInt(id), d, Integer.parseInt(userId), 0, Integer.parseInt(gameId), Integer.parseInt(user.getUserId()));
		System.out.println(d);
		GradeDao.insert(g);
		response.sendRedirect("Select_all_work_servlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
