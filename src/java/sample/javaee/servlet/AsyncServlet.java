package sample.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("AsyncServlet start.");
        
        AsyncContext ctx = req.startAsync();
        
        ctx.addListener(new AsyncListenerImpl());
        
        ctx.start(() -> {
            try (PrintWriter pw = ctx.getResponse().getWriter()) {
                Thread.sleep(5000);
                System.out.println("async process.");
                pw.println("<h1>Async Process</h1>");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                ctx.complete();
            }
        });
        
        resp.getWriter().println("<h1>AsyncServlet</h1>");
        
        System.out.println("AsyncServlet end.");
    }
    
    private static class AsyncListenerImpl implements AsyncListener {

        @Override
        public void onStartAsync(AsyncEvent event) throws IOException {
            System.out.println("onStartAsync");
        }
        
        @Override
        public void onComplete(AsyncEvent event) throws IOException {
            System.out.println("onComplete");
        }

        @Override
        public void onTimeout(AsyncEvent event) throws IOException {
            System.out.println("onTimeout");
        }

        @Override
        public void onError(AsyncEvent event) throws IOException {
            System.out.println("onError");
        }
    }
}
