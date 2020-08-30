package com.jxau.daoImpl;

import com.jxau.domain.User;
import com.jxau.myUtils.MySQLConnection;
import com.jxau.myUtils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDao {

	public static boolean insert(User user) {
		String sql ="insert into User values(?,?,null,?,?)";
		Object[] params = {
				user.getNumber(),
				user.getPassword(),
				user.getEmail(),
				user.getUserflag()
				};
		return Util.executeUpdate(sql, params);
	}

	public static boolean update(User user) {
		String sql = "update User set userNumber = ? , userPassword=?,userEmail=?,userflag=? where userId=?";
		Object[] params = {
				user.getNumber(),
				user.getPassword(),
				user.getEmail(),
				user.getUserflag(),
				user.getUserId()
				};
		return Util.executeUpdate(sql, params);
	}

	public static ArrayList<User> select_all() throws Exception {
		ArrayList<User> users = new ArrayList<User>();
		String sql = "select * from user";
		Object[] params = {};
		ResultSet rs = Util.executeQuery(sql, params);
		while(rs.next()) {
			User u = new User(
						rs.getInt("userId") +"",
						rs.getString("number"),
						rs.getString("password"),
						rs.getInt("userflag"),
						rs.getString("email"),
						rs.getString("name"),
						rs.getString("tel")
					);
			users.add(u);
		}
		return users;
	}

	public static boolean update(User user, int id) {
		System.out.println(user.getName());
		int result = 0;
		String sql = "update `user` set `number` = ? ,`password` = ?, `email` = ?, `name` = ? ,tel = ? where userId=?";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, user.getNumber());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getTel());
			pstmt.setInt(6, id);

			result = pstmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MySQLConnection.close(connection);
		}
		if(result == 0)
			return false;
		else return true;
		/*Object[] params = {
				user.getNumber(),
				user.getPassword(),
				user.getEmail(),
				user.getName(),
				user.getTel(),
				id
		};
		return Util.executeUpdate(sql, params);*/
		
	}

	public static User select_byId(int i) throws Exception {
		User u = null;
		String sql = "select * from user where userId=?";
		Object[] params = {i};
		ResultSet rs = Util.executeQuery(sql, params);
		while(rs.next()) {
			u = new User(
						rs.getInt("userId") +"",
						rs.getString("number"),
						rs.getString("password"),
						rs.getInt("userflag"),
						rs.getString("email"),
						rs.getString("name"),
						rs.getString("tel")
					);
		}
		return u;
	}
	
}
