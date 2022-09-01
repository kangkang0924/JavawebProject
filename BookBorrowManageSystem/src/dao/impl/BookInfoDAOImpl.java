package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BookInfo;
import dao.BookInfoDAO;
import dao.dbc.DBConnection;

public class BookInfoDAOImpl implements BookInfoDAO {
	
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	boolean flag = false;
	DBConnection dbc = new DBConnection();
	private Connection conn = dbc.getConnection();
	public ArrayList<BookInfo> findAllBookInfo() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<BookInfo> allBookInfo = new ArrayList();
		try{
			String sql = "select bookinfo.*,booktype.booktypename from bookinfo,booktype where bookinfo.booktypeid=booktype.booktypeid";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				BookInfo bookinfo = new BookInfo();
				bookinfo.setBookid(rs.getInt("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBooktypename(rs.getString("booktypename"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPrice(rs.getDouble("price"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setNownumber(rs.getInt("nownumber"));
				bookinfo.setTotal(rs.getInt("total"));
				bookinfo.setPubname(rs.getString("pubname"));
				bookinfo.setBooktypeid(rs.getInt("booktypeid"));
				bookinfo.setCasename(rs.getString("casename"));				
    			allBookInfo.add(bookinfo);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return allBookInfo;
	}
	
	@Override
	public boolean doCreate(BookInfo bookinfo) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = dbc.getConnection();
			String sql = "insert into bookinfo values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookinfo.getBookid());
			pstmt.setString(2, bookinfo.getBookname());
			pstmt.setString(3, bookinfo.getAuthor());
			pstmt.setDouble(4, bookinfo.getPrice());
			pstmt.setString(5, bookinfo.getIsbn());
			pstmt.setInt(6, bookinfo.getNownumber());
			pstmt.setInt(7, bookinfo.getTotal());
			pstmt.setString(8, bookinfo.getPubname());
			pstmt.setInt(9, bookinfo.getBooktypeid());
			pstmt.setString(10, bookinfo.getCasename());
			
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
	public BookInfo findBookInfoById(int bookid) throws Exception {
		// TODO Auto-generated method stub
		BookInfo bookinfo = new BookInfo();
		try {
			String sql="select * from bookinfo where bookid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bookinfo.setBookid(rs.getInt("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBooktypeid(rs.getInt("booktypeid"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setPrice(rs.getDouble("price"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setNownumber(rs.getInt("nownumber"));
				bookinfo.setTotal(rs.getInt("total"));
				bookinfo.setPubname(rs.getString("pubname"));			
				bookinfo.setCasename(rs.getString("casename"));   

			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return bookinfo;
	}

	@Override
	public boolean doUpdate(BookInfo bookinfo) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql="update bookinfo set bookname=?,author=?,price=?,isbn=?,nownumber=?,total=?,pubname=?,booktypeid=?,casename=? where bookid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bookinfo.getBookname());
			pstmt.setString(2, bookinfo.getAuthor());
			pstmt.setDouble(3, bookinfo.getPrice());
			pstmt.setString(4, bookinfo.getIsbn());
			pstmt.setInt(5, bookinfo.getNownumber());
			pstmt.setInt(6, bookinfo.getTotal());
			pstmt.setString(7, bookinfo.getPubname());
			pstmt.setInt(8, bookinfo.getBooktypeid());
			pstmt.setString(9, bookinfo.getCasename());
			pstmt.setInt(10, bookinfo.getBookid());
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
	public boolean doDelete(int bookid) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql="delete from bookinfo where bookid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
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
