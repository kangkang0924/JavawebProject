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

		//1.��������
				//������������
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=UTF-8");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				//һ������֤��ļ��� ������֤��
				String checkcode1 = request.getParameter("checkcode");
				//��session�л�ȡһ������֤���ֵ
				String checkcode2 = (String)request.getSession().getAttribute("checkcode");
				System.out.println(checkcode2);
				//Ϊ�˱�֤��֤��ʹ��һ�� Ӧ�ý�session�е����
				request.getSession().removeAttribute("checkcode");
				//����һ������֤��
				if(!checkcode1.equalsIgnoreCase(checkcode2)){
					/*request.setAttribute()��request.getsession().setAttribute()����
					 * �������ڲ�ͬ ǰ����һ������ ������session���������� �����session������ ���һֱ����
					 * ��̨������ʱ��ֻ��Ҫ����һ�Σ���ʱ�����Ǿ������ݲ���ͨ��request.setAttibute()��request.getParameter()���ݡ�
					 * ���ǣ���ʱ��������Ҫ��������ڶ��ǰ��̨������ת֮����Ȼ��Ҫrequest.getSession().setAttribute()
					 */
					request.setAttribute("msg", "��֤���������");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					return;
				}
				//2.��װ����
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				//3.��������
				UserModel userModel = new UserModel();
				try {
					User existUser = userModel.login(user);
					System.out.println(existUser);
					if(existUser == null){
						//��½ʧ��
						//��request���б���һ��������Ϣ
						request.setAttribute("msg" , "�û������������������");
						request.getRequestDispatcher("/Login.jsp").forward(request, response);
					}else {
						//��½�ɹ� 
						//�����û���Ϣ ���浽��ǰ�Ự
						request.getSession().setAttribute("existUser", existUser);
						//��ס�û���
						//�жϸ�ѡ��ʾ���Ѿ���ѡ��
						String remember = request.getParameter("remember");
						if("true".equals(remember)){
							//�Ѿ���ѡ��
							Cookie cookie = new Cookie("remember", existUser.getUsername());
							//������Ч·��
							cookie.setPath("/0187");
							//������Чʱ��   һ��
							cookie.setMaxAge(60*60*24);
							//��Cookieд�������
							response.addCookie(cookie);
						}
							//�ض��򵽳ɹ�ҳ��
						request.getRequestDispatcher("Success.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ҳ����ת
				
				
			
	}

}
