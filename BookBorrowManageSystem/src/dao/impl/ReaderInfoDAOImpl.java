package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BookInfo;
import model.ReaderInfo;
import dao.ReaderInfoDAO;
import dao.dbc.DBConnection;

public class ReaderInfoDAOImpl implements ReaderInfoDAO {
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	boolean flag = false;
	DBConnection dbc = new DBConnection();
	private Connection conn = dbc.getConnection();

	@Override
	public ArrayList<ReaderInfo> findAllReaderInfo() throws Exception {		
		// TODO Auto-generated method stub
		ArrayList<ReaderInfo> allReaderInfo = new ArrayList();
		try{
			String sql = "select readerinfo.*,readertype.readertypename,readertype.number from readerinfo,readertype where readerinfo.readertypeid=readertype.readertypeid";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ReaderInfo readerinfo = new ReaderInfo();
				readerinfo.setReaderid(rs.getInt("readerid"));				
				readerinfo.setReadertypename(rs.getString("readertypename"));
				readerinfo.setReadername(rs.getString("readername"));
				readerinfo.setIdcard(rs.getString("idcard"));
				readerinfo.setNumber(rs.getInt("number"));
				readerinfo.setBorrownumber(rs.getInt("borrownumber"));			
    			allReaderInfo.add(readerinfo);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return allReaderInfo;
	}

	@Override
	public boolean doCreate(ReaderInfo readerinfo) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = dbc.getConnection();
			String sql = "insert into readerinfo values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, readerinfo.getReaderid());
			pstmt.setString(2, readerinfo.getReadername());
			pstmt.setInt(3, readerinfo.getReadertypeid());
			pstmt.setString(4, readerinfo.getIdcard());
			pstmt.setInt(5, readerinfo.getBorrownumber());		
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
	public ReaderInfo findReaderInfoById(int readerid) throws Exception {
		// TODO Auto-generated method stub
		ReaderInfo readerinfo = new ReaderInfo();
		try {
			String sql="select * from readerinfo where readerid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, readerid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				readerinfo.setReaderid(rs.getInt("readerid"));				
				readerinfo.setReadername(rs.getString("readername"));
				readerinfo.setReadertypeid(rs.getInt("readertypeid"));
				readerinfo.setIdcard(rs.getString("idcard"));
				readerinfo.setBorrownumber(rs.getInt("borrownumber"));	 

			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return readerinfo;
	}

	@Override
	public boolean doUpdate(ReaderInfo readerinfo) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql="update readerinfo set readername=?,readertypeid=?,idcard=?,borrownumber=? where readerid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, readerinfo.getReadername());
			pstmt.setInt(2, readerinfo.getReadertypeid());
			pstmt.setString(3, readerinfo.getIdcard());
			pstmt.setInt(4, readerinfo.getBorrownumber());
			pstmt.setInt(5, readerinfo.getReaderid());
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
	public boolean doDelete(int readerid) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql="delete from readerinfo where readerid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, readerid);
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
