package com.houle.web;

import com.houle.entity.User;
import com.houle.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 初始化模型视图对象
        ModelAndView modelAndView = new ModelAndView();
        // 设置视图名
        modelAndView.setViewName("hello");
        // 初始化User对象
        // User user = new User(1, "User 1");
        User user = new UserService().getUser();
                // 将User对象添加到模型数据中
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
