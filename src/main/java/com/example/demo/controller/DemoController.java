package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第一个SpringBoot接口测试
 */
@RestController
public class DemoController {
    /**
     * 输出HelloWorld！
     * @return String "HelloWorld!"
     */
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String helloWorld(){
        return "HelloWorld!";
    }
}
