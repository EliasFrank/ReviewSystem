package com.jxau.servlet;

import com.jxau.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "DownloadItemFileServlet", urlPatterns = "/DownloadItemFileServlet")
public class DownloadItemFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        String itemFilePath = SelectService.getItemFilePath(itemId);

        /**
         * 1.设置两个头
         * 2.获取流
         */
        String filename = itemFilePath;
        String ContentType = this.getServletContext().getMimeType(filename);

        String framename  =null;
        int index = filename.lastIndexOf("/");
        if(index != -1)
            framename = filename.substring(index+1);
        String ContentDisposition = "attachment;filename=" + framename;

        response.setHeader("Content-Type", ContentType);
        response.setHeader("Content-Disposition", ContentDisposition);

        FileInputStream fis = new FileInputStream(filename);
        OutputStream fos = response.getOutputStream();

        byte[] b = new byte[1024];
        int num = 0;
        while((num = fis.read(b)) != -1)
            fos.write(b, 0, num);

        fis.close();
//        request.getRequestDispatcher("/")
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
