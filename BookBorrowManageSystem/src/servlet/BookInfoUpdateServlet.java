package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookInfo;
import dao.factory.DAOFactory;

public class BookInfoUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookInfoUpdateServlet() {
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
		BookInfo bookinfo = new BookInfo();
		bookinfo.setBookname(request.getParameter("bookname"));
		bookinfo.setAuthor(request.getParameter("author"));
		bookinfo.setPrice(Double.parseDouble(request.getParameter("price")));
		bookinfo.setIsbn(request.getParameter("isbn"));
		bookinfo.setNownumber(Integer.parseInt(request.getParameter("nownumber")));
		bookinfo.setTotal(Integer.parseInt(request.getParameter("total")));
		bookinfo.setPubname(request.getParameter("pubname"));
		bookinfo.setBooktypeid(Integer.parseInt(request.getParameter("booktypeid")));
		bookinfo.setCasename(request.getParameter("casename"));
		//从session中获取到原对象的id（id始终未变）
		BookInfo bookinfoold=(BookInfo)request.getSession().getAttribute("bookinfo");
		bookinfo.setBookid(bookinfoold.getBookid());
//		System.out.println("fenge");
//		System.out.println(request.getParameter("bookname"));
//		System.out.println(request.getParameter("author"));
//		System.out.println(Double.parseDouble(request.getParameter("price")));
//		System.out.println(request.getParameter("isbn"));
//		System.out.println(Integer.parseInt(request.getParameter("nownumber")));
//		System.out.println(Integer.parseInt(request.getParameter("total")));
//		System.out.println(request.getParameter("pubname"));
//		System.out.println(Integer.parseInt(request.getParameter("booktypeid")));
//		System.out.println(request.getParameter("casename"));
//		System.out.println(bookinfonew.getBookid());
//		System.out.println("fenge");
		try {
			//2.调用更新图书类型信息的方法
			if(DAOFactory.getBookInfoDAOInstance().doUpdate(bookinfo)) {
				//3.跳转查询所有信息的servlet
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
