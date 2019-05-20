package com.hust.springbootsso.controller;

import com.hust.springbootsso.entity.ResultObject;
import com.hust.springbootsso.servcice.RegisterService;

import com.hust.springbootsso.tool.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Check {

    @Autowired
    RegisterService registerService;

    @RequestMapping("/check/{param}/{type}")
    @ResponseBody
    public Object checkData(@PathVariable String param,@PathVariable Integer type,String callback){
        try {
            ResultObject result = registerService.checkData(param, type);
            if(StringUtils.isNotBlank(callback)){
                //第一种方式 ，把我们返回的数据转JSON后，然后拼接我们在js中定义的方法名，把json数据作为参数传递进去
                //返回 String
                String jsonStr = JsonUtils.objectToJson(result);
                return callback + "("+jsonStr+");";

                //第二种方式，使用Spring自带对象，前提是需要在Srping4.0的版本才有的哟。
                //返回 Object
                //请求为jsonp，需要支持
//                MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
//                mappingJacksonValue.setJsonpFunction(callback);
//                return mappingJacksonValue;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.build(500, "数据校验失败");
        }
    }
}
