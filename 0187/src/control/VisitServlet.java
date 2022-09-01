package control;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CookieUtils;


/**
 * ��¼�û��ϴη���ʱ���Servlet
 */
public class VisitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * �û�����Servlet
		 * 	* ����ǵ�һ�η���
		 * 		* ��ʾ ���ã���ӭ��������վ
		 * 		* ��¼��ǰ����ʱ�䣬���뵽Cookie����д�������
		 *  * ������ǵ�һ�η���
		 *  	* ��cookie�л���ϴ�ʱ�䣬��ʾ��ҳ��
		 *  	* ��¼��ǰ����ʱ�䣬���뵽Cookie����д�������
		 */
		// �ж��Ƿ��ǵ�һ�η��ʣ���ָ����Cookie�������л�ȡָ�����Ƶ�Cookie��
		// ��ô�����������������е�Cookie:
		Cookie[] cookies = request.getCookies();
		// ���������ҵ�ָ�����Ƶ�Cookie:
		Cookie cookie = CookieUtils.findCookie(cookies, "lastVisit");
		// �ж��Ƿ��ǵ�һ�η��ʣ�
		if(cookie == null){
			// �ǵ�һ�η���
			// ��ʾ��ҳ����һ������:
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<h1>���ã���ӭ��������վ��</h1>");
		}else{
			// ���ǵ�һ�η���
			// ���cookie�е��ϴη���ʱ�䣬��ʾ��ҳ��
			String value = cookie.getValue();
			// ��ʾ��ҳ����һ������:
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<h1>���ã������ϴη���ʱ��Ϊ��"+value+"</h1>");
		}
		// ��¼��ǰϵͳʱ����뵽Cookie����д�������
		Date d = new Date();
		// ���뵽Cookie:
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(d);
		//��format�����ַ�����
		String date = URLEncoder.encode(format,"utf-8");
		Cookie c = new Cookie("lastVisit",date);
		// ��Cookie������Ч·��
		c.setPath("/0187");
		// ��Cookie������Чʱ��
		c.setMaxAge(60 * 60 * 24 * 30); // ������Чʱ��Ϊ1����
		// ��д���������
		response.addCookie(c);
		response.getWriter().print("<h3>5�����ת����½����<h3>");
		response.setHeader("refresh", "5,url=/0187/Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
