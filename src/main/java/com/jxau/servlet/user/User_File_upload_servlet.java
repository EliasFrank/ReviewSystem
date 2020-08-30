package com.jxau.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jxau.daoImpl.GamesDao;
import com.jxau.daoImpl.ItemsDao;
import com.jxau.domain.Game;
import com.jxau.domain.User;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import com.jxau.service.Upload_service;


@WebServlet(name = "User_File_upload_servlet", urlPatterns = "/User_File_upload_servlet")
public class User_File_upload_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String fname  = null;
		//创建上传对象
		SmartUpload su = new SmartUpload();
		//初始化
		su.initialize(this.getServletConfig(), request, response);
		Request req = su.getRequest();
		try {
			HttpSession session = request.getSession();

			User user = (User) session.getAttribute("user");
			su.upload();
			//获取上传文件对象
			Files fs = su.getFiles();
			File f = fs.getFile(0);
			//获取上传的文件名称
			fname = f.getFileName();
			String ext = fname.substring(fname.indexOf(".")+1 );
			if(fname != null && (!"doc".equals(ext) && !"docx".equals(ext) && !"jpg".equals(ext) && !"txt".equals(ext))){
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('上传的文件不符合要求');");
				out.write("location.href='Creat_new_servlet';");
				out.write("</script>");
				out.close();
				return;
			}

			Calendar cal = Calendar.getInstance();
			Date date_time = cal.getTime();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String product_time = sdf.format(date_time);
			//项目介绍
			String introduce = req.getParameter("introduce");
			//项目类型
			String gameid = req.getParameter("type");
			//项目名称
			String name = req.getParameter("name");
			if(ItemsDao.exit(gameid,Integer.parseInt(user.getUserId()))) {
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('你已经创建过该项目');");
				out.write("location.href='Creat_new_servlet';");
				out.write("</script>");
				out.close();
			}
			Game g;
			g = GamesDao.selectByGameName(Integer.parseInt(gameid));
			String startTime = g.getStartTime() + "";
			String endTime = g.getEndTime() + "";
			if(startTime.compareTo(product_time)>0||endTime.compareTo(product_time)<0){
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('项目提交未开始或者已经结束');");
				out.write("location.href='Creat_new_servlet';");
				out.write("</script>");
				out.close();}
			else {
				su.save("H:\\test\\rs");
				Upload_service.Upload(user,product_time,fname,introduce,Integer.parseInt(gameid),name);
				response.sendRedirect("");
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('提交成功');");
				out.write("location.href='jsp/userPage.jsp';");
				out.write("</script>");
				out.close();
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
