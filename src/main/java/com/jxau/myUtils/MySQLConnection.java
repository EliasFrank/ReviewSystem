package com.jxau.myUtils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MySQLConnection {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
