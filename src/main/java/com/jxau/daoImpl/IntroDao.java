package com.jxau.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.jxau.domain.Intro;
import com.jxau.myUtils.Util;

public class IntroDao {
	public static boolean insert(Intro in) {
		String sql = "insert into  intro values(?,?,null)";
		Object[] params = {
				in.getItemId(),
				in.getIntroduce()
		};
		return Util.executeUpdate(sql, params);
	}

	public static ArrayList<Intro> select_all() throws Exception {
		String sql ="select * from intro";
		ArrayList<Intro> ins = new ArrayList<Intro>();
		Object[] params = {};
		ResultSet rs =  Util.executeQuery(sql, params);
		while(rs.next()) {
			Intro d = new Intro(
					rs.getInt("itemId"), 
					rs.getString("introduce"), 
					rs.getInt("introId")
					);
			ins.add(d);
		}
		rs.close();
		Util.pstmt.close();
		return ins;
	}
	public static Intro select_byid(int id) throws Exception {
		String sql ="select * from intro where itemId = ?";
		Object[] params = {id};
		Intro d  = null;
		ResultSet rs =  Util.executeQuery(sql, params);
		if(rs.next()) {
				d = new Intro(
					rs.getInt("itemId"), 
					rs.getString("introduce"), 
					rs.getInt("introId")
					);
		}
		rs.close();
		Util.pstmt.close();
		return d;
	}
}
