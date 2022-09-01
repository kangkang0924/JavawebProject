package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.factory.DAOFactory;
import model.Users;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		//1����ȡ����������˺����룩����ʵ���ำֵ
		Users user = new Users();
		user.setUserid(Integer.parseInt(request.getParameter("userid")));
		user.setUpwd(request.getParameter("upwd"));
		//2������findLogin����������user����
		//�жϽ��Ϊtrue����ת��������
		//�жϽ��Ϊfalse��ͣ���ڵ�¼ҳ
		try {
			if(DAOFactory.getUserDAOInstance().findLogin(user)){
				//�û�����
				//���û���������浽session
				request.getSession().setAttribute("loginname", user.getUname());
				request.getSession().setAttribute("limit", user.getLimit());
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	//����JSP�������������ݲ�ķ���
	//MVC���ʹ��������
	public void init() throws ServletException {
		// Put your code here
	}

}
