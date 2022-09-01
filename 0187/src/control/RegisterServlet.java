package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import domain.User;

public class RegisterServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("code"));
		int num  = (int) request.getSession().getAttribute("num");
		if( num == code){
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setNickname(request.getParameter("nickname"));
			user.setSex(request.getParameter("sex"));
			user.setAddress(request.getParameter("address"));
			user.setPhone(request.getParameter("phone"));
			user.setLim(Integer.parseInt(request.getParameter("lim")));
			UserModel userModel = new UserModel();
			try {
				userModel.register(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msg", "注册成功");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "验证码输入错误");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
