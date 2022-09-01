package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookInfo;
import dao.factory.DAOFactory;

public class BookInfoAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookInfoAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		BookInfo bookinfo = new BookInfo();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		double price = Double.parseDouble(request.getParameter("price"));
		String isbn = request.getParameter("isbn");
		int nownumber = Integer.parseInt(request.getParameter("nownumber"));
		int total = Integer.parseInt(request.getParameter("total"));
		String pubname = request.getParameter("pubname");
		int booktypeid = Integer.parseInt(request.getParameter("booktypeid"));
		String casename = request.getParameter("casename");
		bookinfo.setBookid(bookid);
		bookinfo.setBookname(bookname);
		bookinfo.setAuthor(author);
		bookinfo.setPrice(price);
		bookinfo.setIsbn(isbn);
		bookinfo.setNownumber(nownumber);
		bookinfo.setTotal(total);
		bookinfo.setPubname(pubname);
		bookinfo.setBooktypeid(booktypeid);
		bookinfo.setCasename(casename);   
		//1.调用查询所有图书类型的方法

		
		try {
			//2.调用插入数据库的方法
			if(DAOFactory.getBookInfoDAOInstance().doCreate(bookinfo)) {
				//3.如果插入成功，跳转查询所有图书类型的servlet
				request.getRequestDispatcher("BookInfoQueryAllServlet").forward(request, response);
			} else request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	


	
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
