package com.hust.springbootconfig.winter.controller;

import com.hust.springbootconfig.winter.config.MyProperties1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donghua.Chen on 2018/6/1.
 */
@RequestMapping("/properties")
@RestController
public class PropertiesController {

    private static final Logger log = LoggerFactory.getLogger(PropertiesController.class);

    private final MyProperties1 myProperties1;

    @Autowired
    public PropertiesController(MyProperties1 myProperties1) {
        this.myProperties1 = myProperties1;
    }

    @GetMapping("/2")
    public MyProperties1 myProperties1() {
        log.info("=================================================================================================");
        log.info(myProperties1.toString());
        log.info("=================================================================================================");
        return myProperties1;
    }
}