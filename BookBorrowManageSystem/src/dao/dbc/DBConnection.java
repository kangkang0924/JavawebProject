package dao.dbc;
import java.sql.*;
public class DBConnection {
	/*Mysql���ݿ������ַ���*/
	/*
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/BookManageSystem";
	private static  final String userName = "root";
    private static  final String password = "root";
    private  Connection conn = null;
    boolean flag = false;
    //*/
	/*SQLServer�����ַ���*/

    
    /** 
     * @���� �������ݿ����� 
     * @����ֵ connection��ֵ 
     */
//	/*
	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=BMSTable1";
    private static  final String userName = "sa";
    private static  final String password = "123456";
    private  Connection conn = null;
    boolean flag = false;
    //*/
    /** 
     * @���� �������ݿ����� 
     * @����ֵ connection��ֵ 
     */
    public Connection getConnection() {
        try {
        	Class.forName(driver); 
        	conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
        	e.printStackTrace();
           System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
        }
        return conn;
    }
    
     /** 
     * @���� �ر����ݿ�����
     */
    public void closed() {
    	if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�con����ʧ�ܣ�");
			}
    }
  
}