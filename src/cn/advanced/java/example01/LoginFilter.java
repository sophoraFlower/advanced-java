package cn.advanced.java.example01;

import javax.servlet.*;
import java.io.IOException;

public class LoginFilter implements Filter {

    private static final String LOGIN_URI = "login_uri";
    public static final String HOME_URI = "home_uri";
    private String login_page;
    private String home_page;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 从部署描述符中获取登录页面和首页的URI
        login_page = filterConfig.getInitParameter(LOGIN_URI);
        home_page = filterConfig.getInitParameter(HOME_URI);

        if (null == login_page) {
            throw new ServletException("没有指定登录页面或主页");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
    }
}
