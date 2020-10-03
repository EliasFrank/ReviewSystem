package com.jxau.servlet.user;

import com.jxau.daoImpl.GradeDao;
import com.jxau.domain.Grade;
import com.jxau.domain.PartGrade;
import com.jxau.domain.User;
import com.jxau.service.AddService;

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
//        System.out.println("i'm in");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		String[] partflags = request.getParameterValues("partFlag");
		String[] grades = request.getParameterValues("grade");
		String partexplains = request.getParameter("partExplain");
		String[] hid = request.getParameterValues("hid");
		for(int i = 0; i < hid.length; i++){
			if(Double.parseDouble(grades[i]) > Double.parseDouble(hid[i])){
				response.getWriter().print("<script language='javascript'>alert('分数不能超过满分');window.location.href='SelectItemsServlet';</script>");
				return;
			}
		}
		String itemsId = request.getParameterValues("itemId")[0];
//        System.out.println("i want to add");
		AddService.addGrade(userId, partexplains,partflags,grades, itemsId);
//        System.out.println("i'm out");
		response.getWriter().print("<script language='javascript'>alert('评分成功');window.location.href='SelectItemsServlet';</script>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//        System.out.println("hello");
		doGet(request, response);
	}

}
