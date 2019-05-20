package com.hust.springbootsso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * 展示登录页面
     */
    @RequestMapping("/page/login")
    public String showLogin(String redirectURL, Model model){
        //需要把参数传递到jsp,页面回调
        model.addAttribute("redirect", redirectURL);
        return "login";
    }

    /**
     * 展示注册页面
     */
    @RequestMapping("/page/register")
    public String showRegister(){
        return "register";
    }
}