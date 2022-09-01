package dao;

import java.util.ArrayList;

import model.ReaderInfo;

public interface ReaderInfoDAO {
	public ArrayList<ReaderInfo> findAllReaderInfo() throws Exception;
	 
	public boolean doCreate(ReaderInfo readerinfo) throws Exception;
	   
	public ReaderInfo findReaderInfoById(int readerid) throws Exception;
	   
	public boolean doUpdate(ReaderInfo readerinfo) throws Exception;
	   
	public boolean doDelete(int readerid) throws Exception;
}
