package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ReaderType;
import dao.ReaderTypeDAO;
import dao.dbc.DBConnection;

public class ReaderTypeDAOImpl implements ReaderTypeDAO{
	
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	boolean flag = false;
	DBConnection dbc = new DBConnection();
	private Connection conn = dbc.getConnection();
	
	@Override
	public ArrayList<ReaderType> findAllReaderType() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ReaderType> allReaderType = new ArrayList();
		try{
			String sql = "select * from readertype";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ReaderType readertype = new ReaderType();
				readertype.setReadertypeid(rs.getInt("readertypeid"));
				readertype.setReadertypename(rs.getString("readertypename"));
				readertype.setNumber(rs.getInt("number"));
				allReaderType.add(readertype);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return allReaderType;
	}

	@Override
	public boolean doCreate(ReaderType readertype) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = dbc.getConnection();
			String sql = "insert into readertype values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, readertype.getReadertypeid());
			pstmt.setString(2, readertype.getReadertypename());
			pstmt.setInt(3, readertype.getNumber());
			int count = pstmt.executeUpdate();
			if(count>0) {
				flag = true;
			}
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.closed();
		}
		return flag;
	}

	@Override
	public ReaderType findReaderTypeById(int readertypeid) throws Exception {
		// TODO Auto-generated method stub
		ReaderType readertype = new ReaderType();
		try {
			String sql="select * from readertype where readertypeid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, readertypeid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				readertype.setReadertypeid(rs.getInt("readertypeid"));
				readertype.setReadertypename(rs.getString("readertypename"));
				readertype.setNumber(rs.getInt("number"));
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return readertype;
	}

	@Override
	public boolean doUpdate(ReaderType readertype) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql="update readertype set readertypename=?, number=? where readertypeid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, readertype.getReadertypename());
			pstmt.setInt(2, readertype.getNumber());
			pstmt.setInt(3, readertype.getReadertypeid());
			int count = pstmt.executeUpdate();
			if(count>0){
				flag=true;
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int readertypeid) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql="delete from readertype where readertypeid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, readertypeid);
			int count = pstmt.executeUpdate();
			if(count>0){
				flag=true;
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return flag;
	}
	

}
