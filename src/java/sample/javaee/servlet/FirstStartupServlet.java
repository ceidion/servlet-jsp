package sample.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class FirstStartupServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("FirstStartupServlet.init()");
    }
}
