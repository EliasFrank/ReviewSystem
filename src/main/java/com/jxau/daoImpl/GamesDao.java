package com.jxau.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jxau.domain.Game;
import com.jxau.myUtils.MySQLConnection;
import com.jxau.myUtils.Util;


public class GamesDao {
	public static boolean insert(Game g) {
		String sql = "insert into games values(null,?,?,?,?,?,?,?)";
		Object[] params = {g.getGameName()};
		return Util.executeUpdate(sql, params);
	}

	public static Game selectByGameName(int gameId) throws Exception {
		Game g = null;
		String sql="select * from games where gameId = ?";
		Object[] params = {gameId};
		ResultSet rs = Util.executeQuery(sql, params);
		if(rs.next()) {
			g = new Game(
					rs.getInt("gameId"), 
					rs.getString("gameName"),
					rs.getString("welcome"),
					rs.getString("type"),
					rs.getString("introduction"),
					rs.getString("annex"),
					rs.getDate("startTime"),
					rs.getDate("endTime")
					);
		}
		rs.close();
		Util.pstmt.close();
		return g;
	}
	public static ArrayList<Game> select_checked(int id) throws Exception {
		ArrayList<Game> games = new ArrayList<Game>();
		Connection connection = MySQLConnection.getConnection();
		String sql="select g.* from games g, `check` c " +
				"where c.gameId = g.gameId " +
				"and c.isCheck = 1 and c.userId = ?";
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Game g = new Game(
						rs.getInt("gameId"),
						rs.getString("gameName"),
						rs.getString("welcome"),
						rs.getString("type"),
						rs.getString("introduction"),
						rs.getString("annex"),
						rs.getDate("startTime"),
						rs.getDate("endTime")
				);
				games.add(g);
			}
			rs.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MySQLConnection.close(connection);
		}

		return games;
	}
	public static ArrayList<Game> select_all() throws Exception {
		ArrayList<Game> games = new ArrayList<Game>();
		String sql="select * from games";
		Object[] params = {};
		ResultSet rs = null;
		rs = Util.executeQuery(sql, params);
		while(rs.next()){
			Game g = new Game(
					rs.getInt("gameId"), 
					rs.getString("gameName"),
					rs.getString("welcome"),
					rs.getString("type"),
					rs.getString("introduction"),
					rs.getString("annex"),
					rs.getDate("startTime"),
					rs.getDate("endTime")
					);
			games.add(g);
		}
		rs.close();
		Util.pstmt.close();
		return games;
	}
}
