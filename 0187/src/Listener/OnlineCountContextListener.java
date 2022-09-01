package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OnlineCountContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sc2) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext对象被销毁了...");
	}

	@Override
	public void contextInitialized(ServletContextEvent sc1) {
		//在服务器初始化时候初始化一个值0
		//写入到servletContext中
		sc1.getServletContext().setAttribute("count", 0);
		
	}

}
