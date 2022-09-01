package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookInfo;
import model.ReaderInfo;
import dao.factory.DAOFactory;

public class ReaderInfoUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReaderInfoUpdateServlet() {
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
		ReaderInfo readerinfo = new ReaderInfo();
		readerinfo.setReadername(request.getParameter("readername"));
		readerinfo.setReadertypeid(Integer.parseInt(request.getParameter("readertypeid")));
		readerinfo.setIdcard(request.getParameter("idcard"));
		readerinfo.setBorrownumber(Integer.parseInt(request.getParameter("borrownumber")));
		//从session中获取到原对象的id（id始终未变）
		ReaderInfo readerinfoold=(ReaderInfo)request.getSession().getAttribute("readerinfo");
		readerinfo.setReaderid(readerinfoold.getReaderid());
		try {
			//2.调用更新图书类型信息的方法
			if(DAOFactory.getReaderInfoDAOInstance().doUpdate(readerinfo)) {
				//3.跳转查询所有信息的servlet
				request.getRequestDispatcher("ReaderInfoQueryAllServlet").forward(request, response);
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
