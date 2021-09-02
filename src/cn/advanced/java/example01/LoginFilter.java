package cn.advanced.java.example01;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {

    private static final String LOGIN_URI = "login_uri";
    public static final String HOME_URI = "home_uri";
    private String login_page;
    private String home_page;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 从web.xml中获取登录页面和首页的URI
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
                } else {
                    // 如果验证失败，则从请求对象中获取用户先前访问的URI
                    // 如果该URI存在，则再次将它作为"origin_uri"属性的值保存到请求对象中
                    String origin_uri = httpServletRequest.getParameter("origin_uri");
                    if (null != origin_uri && !"".equals(origin_uri)) {
                        httpServletRequest.setAttribute("origin_uri", origin_uri);
                    }
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    PrintWriter printWriter = httpServletResponse.getWriter();
                    printWriter.println("<h2>用户名或密码错误，请重新输入</h2>");
                    RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(login_page);
                    requestDispatcher.include(httpServletRequest, httpServletResponse);
                }
            } else {
                // 如果用户不是提交登陆信息，则调用chain.doFilter()方法调用登录页面
                chain.doFilter(request, response);
            }
        } else {
            // 如果访问的不是登录页面，则判断用户是否已登录
            String isLogin = (String) httpSession.getAttribute("isLogin");
            if ("true".equals(isLogin)) {
                chain.doFilter(request, response);
            } else {
                // 如果用户没有登录，则将用户的请求URI作为origin_uri属性的值保存到请求对象中
                String strQuery = httpServletRequest.getQueryString();
                if (null != strQuery) {
                    request_uri=request_uri+"?"+strQuery;
                }
                httpServletRequest.setAttribute("origin_uri", request_uri);
                // 将用户请求转发给登录页面
                RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(login_page);
                requestDispatcher.forward(httpServletRequest, httpServletResponse);
            }
        }

    }

    @Override
    public void destroy() {
    }
}
