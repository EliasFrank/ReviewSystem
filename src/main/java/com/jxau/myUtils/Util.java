package com.jxau.myUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util{
	public static PreparedStatement pstmt = null;
	public static Connection con=null;
	public static ResultSet rs = null;
	private static ConnectionPool pool=null;
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
	//	public static String dbUrl="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";//连接数据库地址
//    public static String dbUerName = "root";//用户名
//    public static String dbPassword = "123456789";//密码
//    public static String jdbcName = "com.mysql.jdbc.Driver";//驱动名称
//    public static String driver,url,user,pwd;
	static {
		try {
			pool=new ConnectionPool();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 对于数据库的增，删，改操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean executeUpdate(String sql,Object[] params){
		System.out.println(params[3]);
		try {
			Connection con = Util.getConnection();
			pstmt=con.prepareStatement(sql);
			if(params!=null){
				for(int i = 0; i < params.length; i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			int result=pstmt.executeUpdate();
			if(result>0) {
				return true;
			}
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	/**
	 * 对于数据库的查询操作
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(String sql,Object[] params) throws SQLException{
		try {
			Connection con = Util.getConnection();
			pstmt=con.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			return pstmt.executeQuery();
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//獲取連接對象的方法
	public static Connection getConnection() throws Exception{
		Connection con  = threadLocal.get();
		if(con==null) {
			con = pool.getConnection();
			threadLocal.set(con);
		}
		return con;
	}
	//开启事务
	public void   beginTransactin() throws Exception {
		getConnection().setAutoCommit(false);
	}
	//提交事务
	public void commit() throws Exception{
		getConnection().commit();
	}
	//回滚事务
	public void rollback() throws Exception{
		getConnection().rollback();
	}
	public int run(String[] sqls,Object[][] params) throws Exception{
		Connection con = getConnection();
		con.setAutoCommit(false);
		int r =0;
		try {
			for(int i=0;i<sqls.length;i++) {
				PreparedStatement pst = con.prepareStatement(sqls[i]);
				for(int j=0,index=1;j<params[i].length;j++) {
					pst.setObject(index++, params[i][j]);
				}
				int rows = pst.executeUpdate();
			}
			con.commit();
			r=1;
		}catch (Exception e) {
			con.rollback();
		}
		return r;
	}
	public static void close(ResultSet rs,PreparedStatement pstmt) throws Exception {
		if(rs!=null) {
			rs.close();
		}
		if(pstmt!=null) {
			pstmt.close();
		}
	}
}
