package dao;

import java.util.ArrayList;

import model.BookInfo;

public interface BookInfoDAO {
	
	public ArrayList<BookInfo> findAllBookInfo() throws Exception;
	 
	public boolean doCreate(BookInfo bookinfo) throws Exception;
	   
	public BookInfo findBookInfoById(int bookid) throws Exception;
	   
	public boolean doUpdate(BookInfo bookinfo) throws Exception;
	   
	public boolean doDelete(int bookid) throws Exception;
}
