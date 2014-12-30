package sample.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.printf("init() : hash=%d, thread=%s%n", this.hashCode(), Thread.currentThread().getName());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.printf("doGet() : hash=%d, thread=%s%n", this.hashCode(), Thread.currentThread().getName());
    }

    @Override
    public void destroy() {
        System.out.printf("destroy() : hash=%d, thread=%s%n", this.hashCode(), Thread.currentThread().getName());
    }
}
