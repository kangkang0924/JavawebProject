package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import domain.User;

public class LoginServlet extends HttpServlet {

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

		//1.接收数据
				//处理中文乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=UTF-8");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				//一次性验证码的检验 接收验证码
				String checkcode1 = request.getParameter("checkcode");
				//从session中获取一次性验证码的值
				String checkcode2 = (String)request.getSession().getAttribute("checkcode");
				System.out.println(checkcode2);
				//为了保证验证码使用一次 应该将session中的清空
				request.getSession().removeAttribute("checkcode");
				//检验一次性验证码
				if(!checkcode1.equalsIgnoreCase(checkcode2)){
					/*request.setAttribute()和request.getsession().setAttribute()区别
					 * 生命周期不同 前者是一次请求 后者是session的生命周期 如果是session不销毁 则会一直存在
					 * 后台交互有时候只需要交互一次，这时候我们经常传递参数通过request.setAttibute()和request.getParameter()传递。
					 * 但是，有时候，我们需要这个参数在多次前后台来回跳转之后依然需要request.getSession().setAttribute()
					 */
					request.setAttribute("msg", "验证码输入错误");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					return;
				}
				//2.封装数据
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				//3.处理数据
				UserModel userModel = new UserModel();
				try {
					User existUser = userModel.login(user);
					System.out.println(existUser);
					if(existUser == null){
						//登陆失败
						//向request域中保存一个错误信息
						request.setAttribute("msg" , "用户名或者密码输入错误");
						request.getRequestDispatcher("/Login.jsp").forward(request, response);
					}else {
						//登陆成功 
						//保存用户信息 保存到当前会话
						request.getSession().setAttribute("existUser", existUser);
						//记住用户名
						//判断复选框示符已经勾选了
						String remember = request.getParameter("remember");
						if("true".equals(remember)){
							//已经勾选了
							Cookie cookie = new Cookie("remember", existUser.getUsername());
							//设置有效路径
							cookie.setPath("/0187");
							//设置有效时常   一天
							cookie.setMaxAge(60*60*24);
							//将Cookie写道浏览器
							response.addCookie(cookie);
						}
							//重定向到成功页面
						request.getRequestDispatcher("Success.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//页面跳转
				
				
			
	}

}
