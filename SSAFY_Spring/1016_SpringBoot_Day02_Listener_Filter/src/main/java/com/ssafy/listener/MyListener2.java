package com.ssafy.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener2 implements ServletContextListener {

    public MyListener2() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("web.xml에 등록 안한 리스너 시작");
    	// context-param 으로 초기화한 전역 파라미터에 접근할 수 있는
    	// ServletContext 객체를 불러오자
    	ServletContext context = sce.getServletContext();
    	// 반환값은 param-value
    	String MSG = context.getInitParameter("MSG");
    	
    	System.out.println(MSG);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("web.xml에 등록 안한 리스너 종료 ");
    }
	
}
