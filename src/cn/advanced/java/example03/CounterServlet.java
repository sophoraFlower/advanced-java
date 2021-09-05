package cn.advanced.java.example03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Integer count = null;
        // 避免线程安全问题
        synchronized (context)
        {
            count = (Integer) context.getAttribute("counter");
            if (null == count) {
                count = new Integer(1);
            } else {
                count = new Integer(count.intValue() + 1);
            }
            context.setAttribute("counter", count);
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head>");
        out.println("<title>页面访问统计～</title>");
        out.println("</head><body>");
        out.println("该页面已经被访问了" + "<b>" + count + "</b>" + "次");
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
