package com.houle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/viewController")
public class TestViewController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/testThymeleaftView")
    public String testThymeleaftView() {
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/viewController/testThymeleaftView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/viewController/testThymeleaftView";
    }

    /*
    @RequestMapping("/view")
    public String view() {
        return "index";
    }
    */
}
