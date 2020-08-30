package com.jxau.servlet.user;

import com.jxau.daoImpl.DocumentDao;
import com.jxau.domain.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;



@WebServlet(name = "Download_servlet", urlPatterns = "/Download_servlet")
public class Download_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		Document dou;
		try {
			dou = DocumentDao.select_byid(Integer.parseInt(id));
			String fileName = dou.getDecumentflag() + "";
			String fileSavePath = "H:\\test\\rs";
			File file = new File(fileSavePath + File.separator + fileName);
			if(!file.exists()){
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('文件不存在');");
				out.write("location.href='Select_all_work_servlet';");
				out.write("</script>");
				out.close();
			}
			response.setHeader("content-disposition","attachment;filename*=UTF-8''" + URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20"));

			FileInputStream in = new FileInputStream(fileSavePath + File.separator + fileName);

			OutputStream out = response.getOutputStream();

			byte buffer[] = new byte[1024];
			int len = 0;

			while(0<=(len=in.read(buffer))){

				out.write(buffer, 0, len);
			}

			out.close();
			in.close();
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
