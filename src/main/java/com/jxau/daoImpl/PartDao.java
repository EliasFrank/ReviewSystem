package com.jxau.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jxau.domain.Part;
import com.jxau.myUtils.Util;

public class PartDao {

	public static ArrayList<Part> select_bygameId(int gameId) throws Exception {
		String sql = "select * from part where gamesId = ?";
		Object[] params = {gameId};
		ArrayList<Part> parts = new ArrayList<Part>();
		ResultSet rs = Util.executeQuery(sql, params);
		Part p = null;
		while(rs.next()) {
			p = new Part(
					rs.getInt("id"),
					rs.getString("partExplain") ,
					rs.getInt("gamesId"),
					rs.getDouble("grade")
					);
			parts.add(p);
		}
		return parts;
	}

}
