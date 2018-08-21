package com.yaya.feignservice.web;

import com.yaya.feignservice.clients.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//使用RestController 相当于@Controller 和 @RequestBody
@RestController
public class HiContoller {

    @Autowired
    SchedualServiceHi schedualServiceHi; //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
