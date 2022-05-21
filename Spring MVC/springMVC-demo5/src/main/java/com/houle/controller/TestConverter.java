package com.houle.controller;

import com.houle.pojo.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/testConverter")
public class TestConverter {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody: " + requestBody);
        return "success";
    }

    @PostMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println("requestHeader: " + requestEntity.getHeaders());
        System.out.println("requestBody: " + requestEntity.getBody());
        return "success";
    }

    @GetMapping("/testResponseByServletAPI")
    public void testResponseByServletAPI(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello, response");
    }

    @GetMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() throws IOException {
        return "success";
    }

    @GetMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() throws IOException {
        return new User("admin", "123456");
    }

    @PostMapping("/testAxios")
    @ResponseBody
    public String testAxios(User user) {
        return user.getUsername() + "," + user.getPassword();
    }

}
