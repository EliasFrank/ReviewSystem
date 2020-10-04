package com.jxau.service;

import com.jxau.daoImpl.AccountDaoImpl;
import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;

public class UpdateSrvice {
    public static void checkAddExpert(String[] id, String flag){
        Connection con = MySQLConnection.getConnection();
        AccountDaoImpl dao = new AccountDaoImpl();
        try{
            con.setAutoCommit(false);
            dao.updateUserFlag(id, flag, con);
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

    public static void resetPwd(String id) {
        AccountDaoImpl dao = new AccountDaoImpl();
        dao.resetPwd(id);
    }

    public static void delUser(String id) {
        AccountDaoImpl dao = new AccountDaoImpl();
        dao.delUser(id);
    }
}
