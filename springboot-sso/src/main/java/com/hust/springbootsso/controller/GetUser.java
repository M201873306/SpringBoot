package com.hust.springbootsso.controller;

import com.hust.springbootsso.entity.ResultObject;
import com.hust.springbootsso.servcice.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetUser {
    @Autowired
    LoginService loginService;

    @RequestMapping("/user/token/{token}")
    @ResponseBody
    public Object getUserByToken(@PathVariable String token, String callback){
        try {
            ResultObject result = loginService.getUserByToken(token);
            if(StringUtils.isNotBlank(callback)){
                System.out.println("callback!!");
                MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(result);
                System.out.println(mappingJacksonValue.toString());
                return mappingJacksonValue;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.build(500, "获取用户信息失败");
        }
    }
}
