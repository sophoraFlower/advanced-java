package com.houle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/requestMappingController")
public class RequestMappingController {
    @GetMapping("/success")
    public String successGet() {
        return "successget";
    }
    @PostMapping("/success")
    public String successPost() {
        return "successpost";
    }
    @PutMapping("/success")
    public String successPut() {
        return "successpost";
    }
    @DeleteMapping("/success")
    public String successDelete() {
        return "successpost";
    }

    @RequestMapping(
            value = {"/testParams"},
            params = {"username"}
    )
    public String testParams() {
        return "success";
    }
}

