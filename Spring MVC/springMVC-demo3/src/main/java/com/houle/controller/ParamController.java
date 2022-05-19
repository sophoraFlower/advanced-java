package com.houle.controller;

import com.houle.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/paramController")
public class ParamController {
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username=" + username + ",password=" + password);
        return "success";
    }

    // 形参和字段名一致
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("username=" + username + ",password=" + password);
        return "success";
    }

    // 同名形参多值
    @RequestMapping("/testParam2")
    public String testParam2(String username, String password, String hobby) {
        System.out.println("username=" + username + ", password=" + password + ", hobby=" + hobby);
        return "success";
    }

    // @RequestParam
    @RequestMapping("/testParam4")
    public String testParam4(@RequestParam("user_name") String username, String password, String[] hobby) {
        System.out.println("username=" + username + ", password=" + password + ", hobby=" + Arrays.toString(hobby));
        return "success";
    }

    @RequestMapping("/testParam5")
    public String testParam5(@RequestParam(value = "user_name", required = false) String username, String password, String[] hobby) {
        System.out.println("username=" + username + ", password=" + password + ", hobby=" + Arrays.toString(hobby));
        return "success";
    }

    @RequestMapping("/testParam6")
    public String testParam3(
            @RequestParam(value = "user_name", required = false, defaultValue = "heh") String username,
            String password, String[] hobby) {
        System.out.println("username=" + username + ", password=" + password + ", hobby=" + Arrays.toString(hobby));
        return "success";
    }

    @RequestMapping("/testServletSession")
    public String testServletSession(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        System.out.println("username=" + username + ",password=" + password);
        return "success";
    }

    @RequestMapping("/testCookie")
    public String testCookie(
            @CookieValue(value = "JSESSIONID") String jSessionId,
            @CookieValue(value = "Test", required = false, defaultValue = "CookieValue") String test) {
        System.out.println("jSessionId=" + jSessionId + ", test=" + test);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testRequestByModelAndView")
    public ModelAndView testRequestByModelAndView() {
        /**
         * ModelAndView有Model和View两个功能
         * Model用于向请求域共享数据
         * View用于设置视图，实现页面跳转
         */
        ModelAndView mv = new ModelAndView();
        // 向请求域共享数据
        mv.addObject("testRequestScope", "hello, ModelAndView!");
        // 设置视图，实现页面跳转
        mv.setViewName("successrequest");
        return mv;
    }

    @RequestMapping("/testRequestByModel")
    public String testRequestByModel(Model model) {
        //向请求域共享数据
        model.addAttribute("testRequestScope", "hello, ModelAndView!");
        return "successrequest";
    }

    @RequestMapping("/testRequestByMap")
    public String testRequestByMap(Map<String, Object> map) {
        //向请求域共享数据
        map.put("testRequestScope", "hello, Map!");
        return "successrequest";
    }

    @RequestMapping("/testRequestByModelMap")
    public String testRequestByModelMap(ModelMap modelMap) {
        //向请求域共享数据
        modelMap.addAttribute("testRequestScope", "hello, ModelMap!");
        return "successrequest";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        //向session域共享数据
        session.setAttribute("testSessionScope", "hello, HttpSession!");
        return "successsession";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello, application!");
        return "successapplication";
    }

}
