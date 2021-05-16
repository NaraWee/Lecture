package com.greedy.section02.sessionlistener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListenerTest
 *
 */
@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionListenerTest() {
    	/* context가 로드될 시 인스턴스는 생성된다.*/
    	System.out.println("session listener 인스턴스 생성");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	/* 세션이 생성될 때 동작한다. */
    	System.out.println("session created!!");
    	System.out.println("생성된 session id : " + se.getSession().getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	/* 세션이 만료 될 시 동작 */
    	System.out.println("session destroyed!!");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  {
    	/* session에 attribute가 추가될 때 동작한다. */
    	System.out.println("session attribute added!!");
    	System.out.println("session에서 추가된 attr : " + se.getName() + ", " + se.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	/* session에 attribute가 제거될 때 동작 */
    	System.out.println("session attribute removed!!");
    	System.out.println("session에서 제거된 attr : " + se.getName() + ", " + se.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	/* session에 attribute가 갱신될 때 동작 */
    	System.out.println("session attribute replaced!!");
    	System.out.println("session에서 갱신된 attr : " + se.getName() + ", " + se.getValue());
    }
	
}
