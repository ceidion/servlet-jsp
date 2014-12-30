package sample.javaee.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        String value = (String)event.getServletContext().getInitParameter("hoge");
        System.out.println("contextInitialized() hoge=" + value);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("contextDestroyed()");
    }
}
