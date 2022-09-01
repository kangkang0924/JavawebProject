package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import model.BookType;

public class BookTypeUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookTypeUpdateServlet() {
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
		//1.获取参数信息，给实体类赋值
		BookType booktype = new BookType();		
		booktype.setBooktypename(request.getParameter("booktypename"));
		//从session中获取到原对象的id（id始终未变）
		BookType booktypeold=(BookType)request.getSession().getAttribute("booktype");
		booktype.setBooktypeid(booktypeold.getBooktypeid());
//		System.out.println("fenge");
//		System.out.println(booktypeid);
//		System.out.println(booktypename);
//		System.out.println("fenge");
		try {
			//2.调用更新图书类型信息的方法
			if(DAOFactory.getBookTypeDAOInstance().doUpdate(booktype)) {
				//3.跳转查询所有信息的servlet
				request.getRequestDispatcher("BookTypeQueryAllServlet").forward(request, response);
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
