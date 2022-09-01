package dao.factory;

import dao.BookInfoDAO;
import dao.BookTypeDAO;
import dao.ReaderInfoDAO;
import dao.ReaderTypeDAO;
import dao.UserDAO;
import dao.impl.BookInfoDAOImpl;
import dao.impl.BookTypeDAOImpl;
import dao.impl.ReaderInfoDAOImpl;
import dao.impl.ReaderTypeDAOImpl;
import dao.impl.UserDAOImpl;

//工厂类：生产实现类对象
public class DAOFactory {
	public static UserDAO getUserDAOInstance(){
		return new UserDAOImpl();//实现类的对象
	}
	public static BookTypeDAO getBookTypeDAOInstance(){
		return new BookTypeDAOImpl();
	}
	public static BookInfoDAO getBookInfoDAOInstance(){
		return new BookInfoDAOImpl();
	}
	public static ReaderTypeDAO getReaderTypeDAOInstance(){
		return new ReaderTypeDAOImpl();
	}
	public static ReaderInfoDAO getReaderInfoDAOInstance(){
		return new ReaderInfoDAOImpl();
	}
}
