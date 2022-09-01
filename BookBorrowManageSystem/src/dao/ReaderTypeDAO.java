package dao;

import java.util.ArrayList;

import model.ReaderType;

public interface ReaderTypeDAO {
	public ArrayList<ReaderType> findAllReaderType() throws Exception;
	   
	   public boolean doCreate(ReaderType readertype) throws Exception;
	   
	   public ReaderType findReaderTypeById(int readertypeid) throws Exception;
	   
	   public boolean doUpdate(ReaderType readertype) throws Exception;
	   
	   public boolean doDelete(int readertypeid) throws Exception;
}
