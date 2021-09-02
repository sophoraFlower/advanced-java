package cn.advanced.java.example01;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        if (null == login_page || null == home_page) {
            throw new ServletException("没有指定登录页面或主页");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将请求对象和响应对象的类型转换为HttpServletRequest和HttpServletResponse
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpServletRequest.getSession();

        // 得到用户的请求URI
        String request_uri = httpServletRequest.getRequestURI();
        // 得到Web应用程序的上下文路径
        String ctxPath = httpServletRequest.getContextPath();
        // 去除上下文路径，得到剩余部分的路径
        String uri = request_uri.substring(ctxPath.length());

        // 判断用户访问的是否是登录页面
        if (login_page.equals(uri)) {
            // 如果是登录页面，则通过查看是否带附加的查询参数，来判断用户
            // 是访问页面，还是提交登陆信息
            String strLogin = httpServletRequest.getParameter("action");

            if ("login".equals(strLogin)) {
                // 如果是提交信息，则对用户进行验证
                String name = httpServletRequest.getParameter("name");
                String password = httpServletRequest.getParameter("password");

                if ("hole".equals(name) && "123456".equals(password)) {
                    // 验证通过后， 在Session对象中设置isLogin属性为true
                    httpSession.setAttribute("isLogin", "true");
                    httpSession.setAttribute("user", name);

                    // 从请求对象中取出用户先前访问的页面的URI
                    String origin_uri = httpServletRequest.getParameter("origin_uri");
                    // 如果origin_uri不为空，则将客户端重定向到用户先前访问的页面
                    // 否则，将客户端重定向到首页
                    if (null != origin_uri && !"".equals(origin_uri)) {
                        httpServletResponse.sendRedirect(origin_uri);
                    } else {
                        httpServletResponse.sendRedirect(ctxPath+home_page);
                    }
                    return;
                } else {
                    
                }
            }
        }

    }

    @Override
    public void destroy() {
    }
}
