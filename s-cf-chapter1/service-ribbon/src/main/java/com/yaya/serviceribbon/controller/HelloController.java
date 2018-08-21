package com.yaya.serviceribbon.controller;

import com.yaya.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //使用RestController 相当于@Controller 和 @RequestBody
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value="/hi") //@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。该注解将HTTP Get 映射到 特定的处理方法上。
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
