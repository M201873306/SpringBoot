package com.hust.springbootsso.controller;

import com.hust.springbootsso.entity.ResultObject;
import com.hust.springbootsso.servcice.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Login {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/user/login",method= RequestMethod.POST)
    @ResponseBody
    public ResultObject login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        try {
            ResultObject result = loginService.login(username, password, request, response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.build(500, "登录失败");
        }
    }

}
