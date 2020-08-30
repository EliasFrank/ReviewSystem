package com.jxau.myUtils;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Properties;

public class ConnectionPool {
	private String driverClass;//驱动类类名
	private String url;//数据库地址
	private String userName;//登录用户名
	private String pwd;//登录密码

	private int initCount;//初始大小
	private int maxCount;//最大大小

	private LinkedList<Connection> connections;// 保存连接对象的集合,队列方式管理
	private int realCount;//已经创建的大小

	private Connection create(){
		Connection proxy =null;
		try {
			Class.forName(driverClass);
			final Connection con =  DriverManager.getConnection(url, userName, pwd);
			//动态产生con对象的代理对象
			proxy =(Connection) Proxy.newProxyInstance(con.getClass().getClassLoader(),
					new Class[] {Connection.class},new InvocationHandler() {
						@Override           //proxy代理对象   method拦截到的方法   实参
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							Object result=null;
							if(method.getName().equals("close")) {
								connections.addLast((Connection)proxy);//代理对象放回到连接池
							}
							else {
								result = method.invoke(con, args);
							}
							return result;
						}

					});
			this.realCount++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return proxy;
		}
	}

	public ConnectionPool(){
		//读取配置文件db.properties
		try {
			Properties prop = new Properties();

			prop.load(Util.class.getClassLoader().getResourceAsStream("db.properties"));
			driverClass = prop.getProperty("driverName");
			url = prop.getProperty("url");
			userName = prop.getProperty("user");
			pwd = prop.getProperty("pwd");
			initCount=Integer.parseInt( prop.getProperty("initCount"));
			maxCount=Integer.parseInt( prop.getProperty("maxCount"));

			this.connections = new LinkedList<Connection>();
			//按照最小大小创建连接对象
			for(int i=0;i<this.initCount;) {
				Connection con = create();
				if(con!=null) {
					connections.addLast(con);//在队尾加入新连接
					i++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//获取Connection对象
	public Connection getConnection() throws Exception{
		//判断connections集合中还有没有Connection
		Connection con= null;
		if(connections.size()==0) {
			//没有了,如果已经创建的数量<最大大小，创建并返回
			if(this.realCount<this.maxCount){
				return create();
			}else {
				throw new Exception("连接池中没有可用的连接，请稍候，等待连接的返回......");
			}
		}else {
			con = this.connections.removeFirst();//在队列的头部拿出连接
			return con;
		}
	}
	public int size() {
		return this.realCount;
	}
}
