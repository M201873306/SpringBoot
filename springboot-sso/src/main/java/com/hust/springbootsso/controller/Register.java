package com.hust.springbootsso.controller;

import com.hust.springbootsso.entity.ResultObject;

import com.hust.springbootsso.entity.TbUser;
import com.hust.springbootsso.servcice.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Register{

    @Autowired
    RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject register(TbUser user) {
        try {
            ResultObject result = registerService.register(user);
            System.out.println(result.getStatus() + "====" + result.getMsg());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.build(500, "用户注册失败");
        }
    }
}