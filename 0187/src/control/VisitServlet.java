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
 * 记录用户上次访问时间的Servlet
 */
public class VisitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 用户访问Servlet
		 * 	* 如果是第一次访问
		 * 		* 显示 您好，欢迎来到本网站
		 * 		* 记录当前访问时间，存入到Cookie，回写到浏览器
		 *  * 如果不是第一次访问
		 *  	* 从cookie中获得上次时间，显示到页面
		 *  	* 记录当前访问时间，存入到Cookie，回写到浏览器
		 */
		// 判断是否是第一次访问：从指定的Cookie的数组中获取指定名称的Cookie。
		// 获得从浏览器带过来的所有的Cookie:
		Cookie[] cookies = request.getCookies();
		// 从数组中找到指定名称的Cookie:
		Cookie cookie = CookieUtils.findCookie(cookies, "lastVisit");
		// 判断是否是第一次访问：
		if(cookie == null){
			// 是第一次访问
			// 显示到页面上一段内容:
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<h1>您好，欢迎来到本网站！</h1>");
		}else{
			// 不是第一次访问
			// 获得cookie中的上次访问时间，显示到页面
			String value = cookie.getValue();
			// 显示到页面上一段内容:
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<h1>您好，您的上次访问时间为："+value+"</h1>");
		}
		// 记录当前系统时间存入到Cookie，回写到浏览器
		Date d = new Date();
		// 存入到Cookie:
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(d);
		//把format进行字符编码
		String date = URLEncoder.encode(format,"utf-8");
		Cookie c = new Cookie("lastVisit",date);
		// 给Cookie设置有效路径
		c.setPath("/0187");
		// 给Cookie设置有效时长
		c.setMaxAge(60 * 60 * 24 * 30); // 设置有效时长为1个月
		// 回写到浏览器：
		response.addCookie(c);
		response.getWriter().print("<h3>5秒后跳转到登陆界面<h3>");
		response.setHeader("refresh", "5,url=/0187/Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
