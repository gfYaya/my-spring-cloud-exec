package com.yaya.serviceribbonhystrix.controller;

import com.yaya.serviceribbonhystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //使用RestController 相当于@Controller 和 @RequestBody
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value="hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
