package dao;

import java.util.ArrayList;

import model.BookType;

public interface BookTypeDAO {
   public ArrayList<BookType> findAllBookType() throws Exception;
   
   public boolean doCreate(BookType booktype) throws Exception;
   
   public BookType findBookTypeById(int booktypeid) throws Exception;
   
   public boolean doUpdate(BookType booktype) throws Exception;
   
   public boolean doDelete(int booktypeid) throws Exception;
   
}