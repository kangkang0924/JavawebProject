package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReaderType;
import dao.factory.DAOFactory;

public class ReaderTypeAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReaderTypeAddServlet() {
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
		ReaderType readertype = new ReaderType();
		int readertypeid = Integer.parseInt(request.getParameter("readertypeid"));
		String readertypename = request.getParameter("readertypename");
		int number = Integer.parseInt(request.getParameter("number"));
		readertype.setReadertypeid(readertypeid);
		readertype.setReadertypename(readertypename);
		readertype.setNumber(number);
		try {
			//2.调用插入数据库的方法
			if(DAOFactory.getReaderTypeDAOInstance().doCreate(readertype)) {
				//3.如果插入成功，跳转查询所有图书类型的servlet
				request.getRequestDispatcher("ReaderTypeQueryAllServlet").forward(request, response);
			}
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
