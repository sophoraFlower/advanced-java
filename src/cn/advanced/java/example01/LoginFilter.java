package cn.advanced.java.example01;

import javax.servlet.*;
import java.io.IOException;

public class LoginFilter implements Filter {

    private static final String LOGIN_URL = "login_uri";
    public static final String HOME_URI = "home_uri";
    private String login_page;
    private String home_page;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
    }
}
