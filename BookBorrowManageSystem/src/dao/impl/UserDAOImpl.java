package dao.impl;

import java.sql.*;

import model.Users;
import dao.UserDAO;
import dao.dbc.DBConnection;

public class UserDAOImpl implements UserDAO{
	Connection conn = null;         //�������ݿ�����Ӷ���
    private PreparedStatement pstmt = null; //�������ݿ��������
    private ResultSet rs = null;//�����
    boolean flag = false;//�����־λ
    DBConnection db = new DBConnection();
	public boolean findLogin(Users user) throws Exception {
		
		// TODO Auto-generated method stub		
        try{
        	//1.�������ݿ�
    		conn = db.getConnection(); 		               
    		//2.����sql����ִ��
            String sql = "select * from users where userid = ? and upwd = ?";
            pstmt = conn.prepareStatement(sql);  // ʵ��������
            pstmt.setInt(1, user.getUserid());   // �����û�id
            pstmt.setString(2, user.getUpwd());  // ����password
            rs = pstmt.executeQuery();           // ȡ�ò�ѯ����������
            if(rs.next()){                       //�������ж����޼�¼   
                flag = true;
                user.setUname(rs.getString("uname"));  //ȡ������
                user.setLimit(rs.getInt("limit"));
            }
            rs.close();
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        	db.closed();
        }
        	//3.����ܲ鵽���ݷ���true�����򷵻�false
        return flag;
    }
    	    	
}
