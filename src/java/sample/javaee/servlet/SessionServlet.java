package sample.javaee.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (this.notExistsSession(req)) {
            this.createSession(req);
        }
        
        if ("/delete".equals(req.getPathInfo())) {
            this.deleteSession(req);
        } else {
            this.countUp(req);
        }
    }
    
    private boolean notExistsSession(HttpServletRequest request) {
        return request.getSession(false) == null;
    }
    
    private void createSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("count", 0);
        
        System.out.printf("session is created. id=%s%n", session.getId());
    }

    private void deleteSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        
        System.out.printf("session is deleted. id=%s%n", session.getId());
    }

    private void countUp(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        int count = (int)session.getAttribute("count");
        session.setAttribute("count", ++count);
        
        System.out.printf("count up. id=%s, count=%d%n", session.getId(), count);
    }
}
