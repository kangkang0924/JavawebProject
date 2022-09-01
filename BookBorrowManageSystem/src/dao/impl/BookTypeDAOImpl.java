package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BookType;
import dao.BookTypeDAO;
import dao.dbc.DBConnection;

public class BookTypeDAOImpl implements BookTypeDAO{
	
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	boolean flag = false;
	DBConnection dbc = new DBConnection();
	private Connection conn = dbc.getConnection();
	public ArrayList<BookType> findAllBookType() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<BookType> allBookType = new ArrayList();
		try{
			String sql = "select * from booktype";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				BookType booktype = new BookType();
				booktype.setBooktypeid(rs.getInt("booktypeid"));
				booktype.setBooktypename(rs.getString("booktypename"));
				allBookType.add(booktype);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return allBookType;
	}

	@Override
	public boolean doCreate(BookType booktype) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = dbc.getConnection();
			String sql = "insert into booktype values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, booktype.getBooktypeid());
			pstmt.setString(2, booktype.getBooktypename());
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
		
	public BookType findBookTypeById(int booktypeid) throws Exception {
		BookType booktype = new BookType();
		try {
			String sql="select * from booktype where booktypeid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, booktypeid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				booktype.setBooktypeid(rs.getInt("booktypeid"));
				booktype.setBooktypename(rs.getString("booktypename"));				
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return booktype;
		
	}

	@Override
	public boolean doUpdate(BookType booktype) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql="update booktype set booktypename=? where booktypeid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, booktype.getBooktypename());
			pstmt.setInt(2, booktype.getBooktypeid());
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
	public boolean doDelete(int booktypeid) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql="delete from booktype where booktypeid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, booktypeid);
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
