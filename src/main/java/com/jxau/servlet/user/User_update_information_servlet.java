package com.jxau.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.daoImpl.UserDao;
import com.jxau.domain.User;

@WebServlet(name = "User_update_information_servlet", urlPatterns = "/User_update_information_servlet")
public class User_update_information_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userId = request.getParameter("id");
		String userNumber = request.getParameter("number");
		String userPassword = request.getParameter("password");
		String userFlag = request.getParameter("flag");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		User user = new User(userId, userNumber, userPassword, Integer.parseInt(userFlag), email, name, tel);
		System.out.println(user);
		boolean result  = UserDao.update(user,Integer.parseInt(userId));
		if(result) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('修改成功');");
			out.write("location.href='Set_USer';");
			out.write("</script>");
			out.close();
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('修改失败');");
			out.write("location.href='Set_USer';");
			out.write("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
