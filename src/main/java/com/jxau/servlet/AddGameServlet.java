package com.jxau.servlet;

import com.jxau.domain.Game;
import com.jxau.domain.Part;
import com.jxau.service.AddService;
import com.jxau.service.SelectService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AddGameServlet", urlPatterns = "/AddGameServlet")
public class AddGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        Game game = new Game();

        HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<String> standards = new ArrayList<String>();
        ArrayList<String> standardGrades = new ArrayList<String>();

        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload parseFile = new ServletFileUpload(factory);
        parseFile.setHeaderEncoding("utf-8");
        try {
            List<FileItem> files = parseFile.parseRequest(request);

            for ( FileItem item : files ) {
                if (item.isFormField()){
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    if("standard".equals(name)){
                        standards.add(value);
                    }else if("standardGrade".equals(name)){
                        standardGrades.add(value);
                    }else {
                        map.put(name, value);
                    }
                }else{
                    String filename = item.getName();
                    int index = filename.lastIndexOf("\\");
                    if(index != -1)
                        filename = filename.substring(index+1);
                    try {
                        File file = new File("H:\\test\\rs", filename);
                        for(int i = 1;file.exists(); i++){
                            file = new File("H:\\test\\rs", i + filename);
                            map.put("annex", file.getAbsolutePath());
                        }
                        item.write(file);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        int id = SelectService.getGameId();
        Part[] part = new Part[standards.size()];
        for(int i = 0; i < part.length; i++){
            part[i] = new Part();
            part[i].setExplain(standards.get(i));
            part[i].setGrade(Double.parseDouble(standardGrades.get(i)));
            part[i].setGameId(id);
        }
        game.setGameName(map.get("name"));
        game.setType(map.get("type"));
        game.setAnnex(map.get("annex"));
        game.setEndTime(Date.valueOf(map.get("endTime")));
        game.setStartTime(Date.valueOf(map.get("startTime")));
        game.setIntroduction(map.get("introduce"));
        game.setWelcome(map.get("welcome"));
        game.setGameId(id);
        AddService.addGame(game, part);

        response.getWriter().print("<script language='javascript'>alert('创建项目成功');window.location.href='jsp/admin.jsp';</script>");
    }
}
