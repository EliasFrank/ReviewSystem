package com.jxau.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "GameDownloadServlet", urlPatterns = "/GameDownloadServlet")
public class GameDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1.设置两个头
         * 2.获取流
         */
        String filename = req.getParameter("annex");
        String ContentType = this.getServletContext().getMimeType(filename);

        String framename  =null;
        int index = filename.lastIndexOf("/");
        if(index != -1)
            framename = filename.substring(index+1);
        //String framename = filenameEncoding("句号.mp3", req);
        String ContentDisposition = "attachment;filename=" + framename;

        resp.setHeader("Content-Type", ContentType);
        resp.setHeader("Content-Disposition", ContentDisposition);

        FileInputStream fis = new FileInputStream(filename);
        OutputStream fos = resp.getOutputStream();

        byte[] b = new byte[1024];
        int num = 0;
        while((num = fis.read(b)) != -1)
            fos.write(b, 0, num);

        fis.close();
    }
    /*private String filenameEncoding(String filename, HttpServletRequest request) throws UnsupportedEncodingException {
        String agent = request.getHeader("User-Agent");
        if(agent.contains("Firefox")){
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        }else if(agent.contains("MSIE"))
            filename = URLEncoder.encode(filename, "utf-8");
        else
            filename = URLEncoder.encode(filename, "utf-8");
        return filename;
    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
