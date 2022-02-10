package com.mr.mr_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("login")
    public String toIndex(){
        return "login";
    }

    @RequestMapping("login-error")
    public String loginerr(){
        return "loginError";
    }


}
