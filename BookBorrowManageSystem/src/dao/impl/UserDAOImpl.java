package dao.impl;

import java.sql.*;

import model.Users;
import dao.UserDAO;
import dao.dbc.DBConnection;

public class UserDAOImpl implements UserDAO{
	Connection conn = null;         //定义数据库的连接对象
    private PreparedStatement pstmt = null; //定义数据库操作对象
    private ResultSet rs = null;//结果集
    boolean flag = false;//定义标志位
    DBConnection db = new DBConnection();
	public boolean findLogin(Users user) throws Exception {
		
		// TODO Auto-generated method stub		
        try{
        	//1.连接数据库
    		conn = db.getConnection(); 		               
    		//2.定义sql，并执行
            String sql = "select * from users where userid = ? and upwd = ?";
            pstmt = conn.prepareStatement(sql);  // 实例化操作
            pstmt.setInt(1, user.getUserid());   // 设置用户id
            pstmt.setString(2, user.getUpwd());  // 设置password
            rs = pstmt.executeQuery();           // 取得查询结果，结果集
            if(rs.next()){                       //遍历，判断有无记录   
                flag = true;
                user.setUname(rs.getString("uname"));  //取得姓名
                user.setLimit(rs.getInt("limit"));
            }
            rs.close();
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        	db.closed();
        }
        	//3.如果能查到数据返回true，否则返回false
        return flag;
    }
    	    	
}
