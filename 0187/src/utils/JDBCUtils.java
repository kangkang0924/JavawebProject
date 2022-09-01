package utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 利用cp30获取连接
 * JDBC的工具类
 * @author jt
 *
 */
public class JDBCUtils {
	// 创建一个连接池：但是这个连接池只需要创建一次即可。  
	//创建连接池默认去类路径下查找c3p0-config.xml
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/**
	 * 获得连接的方法
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 获得连接池:
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}

