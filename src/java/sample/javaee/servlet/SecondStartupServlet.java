package sample.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SecondStartupServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("SecondStartupServlet.init()");
    }
}
