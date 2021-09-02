package cn.advanced.java.example01;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = servletResponse.getWriter();
        printWriter.println("before doFilter ...");
        // 调用目标资源
        filterChain.doFilter(servletRequest, servletResponse);
        printWriter.println("after doFilter ...");
    }

    @Override
    public void destroy() {
    }
}
