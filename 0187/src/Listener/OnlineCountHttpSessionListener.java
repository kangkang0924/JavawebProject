package Listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 上线了
		HttpSession session = se.getSession();
		System.out.println(session.getId()+"上线了...");
		Integer count = (Integer) session.getServletContext().getAttribute("count");
		count++;
		session.getServletContext().setAttribute("count", count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		System.out.println(session.getId()+"离线了...");
		Integer count = (Integer) session.getServletContext().getAttribute("count");
		count--;
		session.getServletContext().setAttribute("count", count);
		
	}

}
