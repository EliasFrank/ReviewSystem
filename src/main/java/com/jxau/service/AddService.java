package com.jxau.service;

import com.jxau.dao.GamesDao;
import com.jxau.daoImpl.*;
import com.jxau.domain.*;
import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddService {
    public static void addExpert(int id){
       new AccountDaoImpl().addExpertApply(id);
    }
    public static void addAccount(User user){
        new AccountDaoImpl().addAccounnt(user);
    }
    public static void addGame(Game game, Part[] parts){
        Connection con = MySQLConnection.getConnection();
        GamesDao dao = new GameDaoImpl();
        try{
            con.setAutoCommit(false);

            dao.addGame(game, con);
            dao.addParts(parts, con);
            
            con.commit();
        }catch (Exception e){
            e.printStackTrace();
            try{
                con.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }finally {
            MySQLConnection.close(con);
        }
    }

    public static void addItem(Items items, Document document) {
        Connection con = MySQLConnection.getConnection();
        ItemDaoImpl itemDao = new ItemDaoImpl();
        try{
            con.setAutoCommit(false);

            itemDao.addItem(items, con);
            itemDao.addDocument(document, con);
            con.commit();
        }catch (Exception e){
            e.printStackTrace();
            try{
                con.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }finally {
            MySQLConnection.close(con);
        }
    }

    public static void addApplyGame(String userId, int gameId) {
        new AccountDaoImpl().addUserApply(Integer.parseInt(userId), gameId);
    }

    public static void addGrade(String userId, String partexplains, String[] partflags, String[] grades, String itemsId) {
        ArrayList<PartGrade> partGrades = new ArrayList<>();
        double totalGrade = 0;
        for(int i = 0; i < grades.length; i++){
            PartGrade p = new PartGrade();
            p.setExpertId(Integer.parseInt(userId));
            p.setItemId(Integer.parseInt(itemsId));
            //p.setPartexplain(partexplains[i]);
            p.setPartgrade(Double.parseDouble(grades[i]));
            p.setPartflag(Integer.parseInt(partflags[i]));

            totalGrade += Double.parseDouble(grades[i]);
            partGrades.add(p);
        }
        String[] info = SelectService.selectGameId(itemsId).split(" ");
        Grade grade = new Grade();
        grade.setExpertId(Integer.parseInt(userId));
        grade.setGameId(Integer.parseInt(info[0]));
        grade.setItemId(Integer.parseInt(itemsId));
        grade.setTotalGrade(totalGrade);
        grade.setExplain(partexplains);
        grade.setUserId(Integer.parseInt(info[1]));


        Connection connection = MySQLConnection.getConnection();
        GradesImpl gradesImpl = new GradesImpl();

//      ItemDaoImpl itemImpl = new ItemDaoImpl();
        try{
            connection.setAutoCommit(false);

            gradesImpl.addPartGrades(partGrades, connection);
            gradesImpl.addTotalGrades(grade, connection);
            //itemImpl.setItemFlag(grade.getExpertId(), grade.getItemId());
            gradesImpl.setIsUsed(userId, itemsId);
            connection.commit();

        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            MySQLConnection.close(connection);
        }
    }

    public static void storeGame(Game game, Part[] parts, String userId) {
        Connection con = MySQLConnection.getConnection();
        GamesDao dao = new GameDaoImpl();
        try{
            con.setAutoCommit(false);

            dao.storeGame(game, con, userId);
            dao.storeParts(parts, con);

            con.commit();
        }catch (Exception e){
            e.printStackTrace();
            try{
                con.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }finally {
            MySQLConnection.close(con);
        }
    }
}
