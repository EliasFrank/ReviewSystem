package com.jxau.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jxau.domain.Items;
import com.jxau.myUtils.Util;
public class ItemsDao {

	public static boolean insert(Items ite) {
		String sql = "insert into items values(null,?,?,?,?,?,?)";
		Object[] params = {
				ite.getGameId(),
				ite.getUserId(),
				ite.getItemflag(),
				ite.getSubmitTime(),
				ite.getItemName(),
				ite.getIsSelected()
		};
		return Util.executeUpdate(sql, params);
	}
	
	public static ArrayList<Items> selectByUserId(int userId) throws Exception {
		ArrayList<Items> items = new ArrayList<Items>();
		String sql ="select * from items where userid=?";
		Object[] params = {userId};
		ResultSet rs = Util.executeQuery(sql, params);
		while(rs.next()) {
			Items i = new Items(
					rs.getInt("itemId"), 
					rs.getInt("gameId"), 
					rs.getInt("userId"), 
					rs.getInt("itemflag"), 
					rs.getString("submitTime"), 
					rs.getString("itemName"),
					rs.getString("isSelected")
					);
			items.add(i);
		}
		rs.close();
		Util.pstmt.close();
		return items;
	}
	public static int select_ItemId(int userId,int gameId,String itemName) throws Exception {
		String sql ="select * from items where userid=? and gameId=? and itemName=?";
		Object[] params = {userId,gameId,itemName};
		Items  i = null;
		ResultSet rs = Util.executeQuery(sql, params);
		if(rs.next()) {
			 i = new Items(
					rs.getInt("itemId"), 
					rs.getInt("gameId"), 
					rs.getInt("userId"), 
					rs.getInt("itemflag"), 
					rs.getString("submitTime"), 
					rs.getString("itemName"),
					rs.getString("isSelected")
					);
		}
		rs.close();
		Util.pstmt.close();
		return i.getItemId();
	}

	public static ArrayList<Items> select_all() throws Exception {
		ArrayList<Items> items = new ArrayList<Items>();
		String sql ="select * from items";
		Object[] params = {};
		ResultSet rs = Util.executeQuery(sql, params);
		while(rs.next()) {
			Items i = new Items(
					rs.getInt("itemId"), 
					rs.getInt("gameId"), 
					rs.getInt("userId"), 
					rs.getInt("itemflag"), 
					rs.getString("submitTime"), 
					rs.getString("itemName"),
					rs.getString("isSelected")
					);
			items.add(i);
		}
		rs.close();
		Util.pstmt.close();
		return items;
	}
	public static Items select_byItemId(int itemId) throws Exception {
		String sql ="select * from items where itemId=?";
		Object[] params = {itemId};
		Items i= null;
		ResultSet rs = Util.executeQuery(sql, params);
		if(rs.next()){
			i  = new Items(
					rs.getInt("itemId"), 
					rs.getInt("gameId"), 
					rs.getInt("userId"), 
					rs.getInt("itemflag"), 
					rs.getString("submitTime"), 
					rs.getString("itemName"),
					rs.getString("isSelected")
					);
		}
		rs.close();
		Util.pstmt.close();
		return i;
	}

	public static boolean exit(String gameid, int userId) throws Exception {
		String sql = "select * from items where gameId=? and userId=?";
		Object[] params = {gameid,userId};
		ResultSet rs = Util.executeQuery(sql, params);
		boolean end = rs.next();
		rs.close();
		Util.pstmt.close();
		return end;
	}

}
