package com.jxau.servlet;

import com.jxau.domain.ResultRank;
import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "ExportResultServlet", urlPatterns = "/ExportResultServlet")
public class ExportResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        InputStream ranks = SelectService.getResult(request.getParameter("id"));
        /**
         * 1.设置两个头
         * 2.获取流
         */
        String filename = "排名.xlsx";
        String ContentType = this.getServletContext().getMimeType(filename);

        String framename  = filename;
        String ContentDisposition = "attachment;filename=" + framename;

        response.setHeader("Content-Type", ContentType);
        response.setHeader("Content-Disposition", ContentDisposition);

        OutputStream fos = response.getOutputStream();
        byte[] b = new byte[1024];
        int num = 0;
        while((num = ranks.read(b)) != -1){
            fos.write(b, 0, num);
        }
        ranks.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
