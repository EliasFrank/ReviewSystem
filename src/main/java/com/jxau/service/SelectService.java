package com.jxau.service;

import com.jxau.daoImpl.AccountDaoImpl;
import com.jxau.daoImpl.GameDaoImpl;
import com.jxau.daoImpl.GradesImpl;
import com.jxau.daoImpl.ItemDaoImpl;
import com.jxau.domain.*;

import java.io.InputStream;
import java.util.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jxau.myUtils.ExcelFormatUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class SelectService {
    public static List<User> selectAllCheckUser(){
        List<User> users =  new AccountDaoImpl().selectAllCheckUser();
        return users;
    }

    public static List<Game> selectAllGames() {
        List<Game> games =  new AccountDaoImpl().selectAllGames();
        return games;
    }

    public static List<GradeRank> selectGradeRank(int id){
        return new GradesImpl().getGrades(id);
    }

    public static boolean selectAccount(String number) {
        return new AccountDaoImpl().selectAccount(number);
    }

    public static User selectUser(User user) {
        return new AccountDaoImpl().selectUser(user);
    }

    public static int getGameId() {
        return new GameDaoImpl().getGameId();
    }
    public static int getStoreGameId() {
        return new GameDaoImpl().getGameId();
    }
    public static List<UserApply> selectUserApply() {
        return new AccountDaoImpl().selectUserApply();
    }

    public static List<Choose> selectChoose() {
        return new AccountDaoImpl().selectChoose();
    }

    public static Object selectExpert() {
        return new AccountDaoImpl().selectExpert();
    }

    public static int getItemId() {
        return new GameDaoImpl().getItemId();
    }

    public static boolean selectIsPost(int userId, int gameId) {
        return new ItemDaoImpl().selectIsPost(userId, gameId);
    }

    public static String selectGamesTime(int gameId) {
        return new ItemDaoImpl().selectGameTime(gameId);
    }

    public static ArrayList<MyItems> getMyItems(String userId) {
       return new ItemDaoImpl().selectMyItems(Integer.parseInt(userId));
    }
    public static ArrayList<Game> selectGames(){
        return new GameDaoImpl().getGames();
    }

    public static ArrayList<CheckItem> selectCheckItems(int userId) {
        return new ItemDaoImpl().getCheckItems(userId);
    }

    public static ArrayList<Part> getParts(String gameId) {
        return new GameDaoImpl().getParts(gameId);
    }

    public static Map<Integer, Object> getItem(String itemId) {
        return new ItemDaoImpl().getItems(itemId);
    }

    public static String getItemFilePath(int itemId) {
        return new ItemDaoImpl().getItemsPath(itemId);
    }

    public static String selectGameId(String itemsId) {
        return  new GameDaoImpl().getGameIdByItemId(itemsId);
    }

    public static Game getStoreGame(String userId) {
        return  new GameDaoImpl().getStoreGam(userId);
    }

    public static ArrayList<Part> getStoreParts(int gameId) {
       return new GameDaoImpl().getStoreParts(gameId);
    }

    public static ArrayList<User> getAllUsers() {
        return new AccountDaoImpl().getAllUsers();
    }

    public static InputStream getResult(String id) {
        ArrayList<ResultRank> ranks = new ItemDaoImpl().getResult(id);
        Map<String,  ArrayList<String>> explains = new ItemDaoImpl().getExplain(id);
        for (ResultRank rank : ranks) {
            rank.setOpinion(explains.get(rank.getItemName()));
        }
        InputStream is = export(ranks);
        return is;
//        return null;
    }

    private static InputStream export(List<ResultRank> list) {

        ByteArrayOutputStream output = null;
        InputStream inputStream1 = null;
        SXSSFWorkbook wb = new SXSSFWorkbook(100);// 保留1000条数据在内存中
        SXSSFSheet sheet = wb.createSheet();
        // 设置报表头样式
        CellStyle header = ExcelFormatUtil.headSytle(wb);// cell样式
        CellStyle content = ExcelFormatUtil.contentStyle(wb);// 报表体样式

        // 每一列字段名
        String[] strs = new String[] {"排名", "项目名", "用户名", "成绩", "评语"};

        // 字段名所在表格的宽度
        int[] ints = new int[] { 5000, 5000, 5000, 5000, 20000 };

        // 设置表头样式
        ExcelFormatUtil.initTitleEX(sheet, header, strs, ints);
        //logger.info(">>>>>>>>>>>>>>>>>>>>表头样式设置完成>>>>>>>>>>");

       for (int i = 0; i < list.size(); i++) {
            ResultRank rr = list.get(i);
            SXSSFRow row = sheet.createRow(i + 1);
            int j = 0;
            SXSSFCell cell = row.createCell(j++);
            cell.setCellValue(rr.getRank()); // 排名
            cell.setCellStyle(content);

            cell = row.createCell(j++);
            cell.setCellValue(rr.getItemName()); // 项目名
            cell.setCellStyle(content);

            cell = row.createCell(j++);
            cell.setCellValue(rr.getUserName()); // 用户名
            cell.setCellStyle(content);

            cell = row.createCell(j++);
            cell.setCellValue(rr.getGrade()); // 成绩
            cell.setCellStyle(content);

            cell = row.createCell(j++);
            cell.setCellValue(rr.getOpinion().get(0)); // 评语
            cell.setCellStyle(content);
       }
        try {
            output = new ByteArrayOutputStream();
            wb.write(output);
            inputStream1 = new ByteArrayInputStream(output.toByteArray());
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                    if (inputStream1 != null)
                        inputStream1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputStream1;
    }
}
