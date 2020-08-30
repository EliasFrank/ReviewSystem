package com.jxau.service;

import com.jxau.dao.GamesDao;
import com.jxau.daoImpl.AccountDaoImpl;
import com.jxau.daoImpl.GameDaoImpl;
import com.jxau.daoImpl.ItemDaoImpl;
import com.jxau.domain.*;
import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;

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
}
