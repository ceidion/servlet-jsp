package sample.javaee.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        String hoge = config.getInitParameter("hoge");
        System.out.println("hoge=" + hoge);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        
    }
}
