package com.ranx.chowder.jdbcpool;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * @Description 数据库连接池
 * @author ranx
 * @date 2018年11月30日 上午9:55:17
 *
 *       DataSource接口中定义了两个重载的getConnection方法： Connection getConnection()
 *       Connection getConnection(String username, String password)
 * 
   
    *           实现DataSource接口，并实现连接池功能的步骤：
 *      s1: 在DataSource构造函数中批量创建与数据库的连接，并把创建的连接加入LinkedList对象中。
 *      s2: 实现getConnection方法，让getConnection方法每次调用时，从LinkedList中取一个Connection返回给用户。
 *      s3: 当用户使用完Connection，调用Connection.close()方法时，Collection对象应保证将自己返回到LinkedList中,而不要把conn还给数据库。
 */
public class JdbcPool implements DataSource {

	//由于要频繁读写List集合，故采用LinkedList集合来存放db链接
	private static LinkedList<Connection> listConnectons = new LinkedList<Connection>();
	
	static {
		//在静态代码块中加载db.properties
		InputStream in = JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			String driver = prop.getProperty("dbcp.driverClassName");
			String url = prop.getProperty("dbcp.url");
			String username = prop.getProperty("dbcp.username");
			String password = prop.getProperty("dbcp.password");
			//db连接池的初始化连接数大小
			int jdbcPoolInitSize = Integer.parseInt(prop.getProperty("dbcp.initialSize"));
			//加载数据驱动
			Class.forName(driver);
			for (int i=0; i<jdbcPoolInitSize; i++) {
				Connection conn = DriverManager.getConnection(url, username, password);
				System.out.println("获取到了链接：" + conn);
				//将获取到的数据库连接加入到listConnections集合中，listConnections集合此时就是一个存放了数据库连接的连接池
				listConnectons.add(conn);
			}
		} catch (Exception e) {
			 throw new ExceptionInInitializerError(e);
		}
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 获取db连接
	 */
	@Override
	public Connection getConnection() throws SQLException {
		if (listConnectons.size() > 0) {
			//从集合中去一个db连接
			final Connection conn = listConnectons.removeFirst();
			System.out.println("listConnectonsDBPOOL的大小是：" + listConnectons.size());
			//返回Connection对象的代理对象 (使用动态代理技术构建连接池中的connection)
			return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(),
					conn.getClass().getInterfaces(), new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							if (!"close".equals(method.getName())) {
								return method.invoke(conn, args);
							} else {
								//如果调用的是Connection对象的close方法，就把conn还给db连接池
								listConnectons.add(conn);
								System.out.println(conn + "被还给listConnections数据库连接池了！");
								System.out.println("listConnectonsDBPOOL的大小是：" + listConnectons.size());
							}
							return null;
						}
				
			});
		} else {
			throw new RuntimeException("sorry, db is busy");
		}
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
