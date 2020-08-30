package com.jxau.service;

import com.jxau.daoImpl.AccountDaoImpl;
import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;

public class UpdateSrvice {
    public static void checkAddExpert(int id, int flag){
        Connection con = MySQLConnection.getConnection();
        AccountDaoImpl dao = new AccountDaoImpl();
        try{
            con.setAutoCommit(false);
            dao.updateUserFlag(id, flag, con);
            dao.deleteExpertApply(id, con);
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

    public static void agreeApply(int id) {
        new AccountDaoImpl().agreeApply(id);
    }

    public static boolean distributeExperts(int[] expertsId, int itemId) {
        Connection con = MySQLConnection.getConnection();
        AccountDaoImpl dao = new AccountDaoImpl();
        try{
            con.setAutoCommit(false);

            dao.addJudges(expertsId, itemId, con);
            dao.updateItemSelect(itemId, con);
            con.commit();
        }catch (Exception e){
            e.printStackTrace();
            try{
                con.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
                return false;
            }
            return false;
        }finally {
            MySQLConnection.close(con);
        }
        return true;
    }
}
