package com.jxau.servlet;

import com.jxau.domain.*;
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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "UserUploadServlet", urlPatterns = "/UserUploadServlet")
public class UserUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        User user1 = (User) request.getSession().getAttribute("user");

        Items items = new Items();
        Document document = new Document();

        HashMap<String, String> map = new HashMap<String, String>();

        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload parseFile = new ServletFileUpload(factory);
        parseFile.setHeaderEncoding("utf-8");
        try {
            List<FileItem> files = parseFile.parseRequest(request);

            for ( FileItem item : files ) {
                if (item.isFormField()){
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    map.put(name, value);
                }else{
                    String filename = item.getName();
                    int index = filename.lastIndexOf("\\");
                    if(index != -1)
                        filename = filename.substring(index+1);
                    try {
                        File file = new File("/data/reviewSystem", filename);
                        for(int i = 1;file.exists(); i++)
                            file = new File("/data/reviewSystem", i + filename);

                        map.put("annex", file.getAbsolutePath());
                        item.write(file);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }/*
        Set<Map.Entry<String, String>> entry  = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entry.iterator();
        while(iterator.hasNext()){{
            Map.Entry<String, String> me = iterator.next();
            String i = me.getKey();
            String str = me.getValue();
            System.out.println(i + " = " + str);
        }}*/
       int itemId = SelectService.getItemId();
        items = getItem(map, itemId, user1.getUserId());
        document = getDocument(map, itemId);

        boolean isPost = SelectService.selectIsPost(items.getUserId(), items.getGameId());
        if(isPost){
            File file = new File(map.get("annex"));
            file.delete();
            response.getWriter().print("<script language='javascript'>alert('你已参加过该项目');window.location.href='jsp/userPage.jsp';</script>");
            return;
        }
        String gameDate = SelectService.selectGamesTime(items.getGameId());
        if(!checkTime(gameDate, items.getSubmitTime())){
            File file = new File(map.get("annex"));
            file.delete();
            response.getWriter().print("<script language='javascript'>alert('该项目申报时间还未开始或已过');window.location.href='jsp/userPage.jsp';</script>");
            return;
        }
        AddService.addItem(items, document);
        response.getWriter().print("<script language='javascript'>alert('创建项目成功');window.location.href='jsp/userPage.jsp';</script>");
    }

    private boolean checkTime(String gameDate, String submitTime) {
        String subTime = submitTime.split(" ")[0];
        String startTime = gameDate.split(" ")[0];
        String endTime = gameDate.split(" ")[1];
        int result = subTime.compareTo(startTime);
        int result2 = subTime.compareTo(endTime);
        if(result >= 0 && result2 <= 0)
            return true;
        return false;
    }
    private Document getDocument(HashMap<String, String> map, int itemId) {
        Document document = new Document();
        document.setDecumentflag(1);
        document.setIntroduce(map.get("introduce"));
        document.setItemId(itemId);
        document.setPath(map.get("annex"));
        return document;
    }

    private Items getItem(Map<String, String> map, int id, String userId){
        Items items = new Items();
        items.setItemId(id);
        items.setGameId(Integer.parseInt(map.get("types")));
        items.setIsSelected("no");
        items.setItemName(map.get("name"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        items.setSubmitTime(date);
        items.setUserId(Integer.parseInt(userId));
        return items;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
