import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC的工具类
 * 
 * 传统方法获取连接
 * 
 * @author jt
 *
 */
public class JDBCUtils {
	private static final String driverClassName;
	private static final String url;
	private static final String username;
	private static final String password;
	
	static{
		driverClassName="com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/testconnection?useUnicode=true&characterEncoding=utf-8";
		username = "root";
		password = "123456";
	}

	/**
	 * 注册驱动的方法
	 */
	public static void loadDriver(){
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得连接的方法
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try{
			// 将驱动一并注册:
			loadDriver();
			// 获得连接
			conn = DriverManager.getConnection(url,username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源的方法
	 */
	public static void release(Statement stmt,Connection conn){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			stmt = null;
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	public static void release(ResultSet rs,Statement stmt,Connection conn){
		// 资源释放：
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			rs = null;
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			stmt = null;
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
