package com.yaya.serviceribbonhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    //降级方法必须的参数应该与被执行的方法参数一致,否则hystrix不会查询到降级方法,会直接抛出异常,降级方法也可以同步异步执行
    @HystrixCommand(fallbackMethod = "hiError" )
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name, String.class);
    }

    public String hiError(String name){
        return  "hi,"+name+",sorry,error!";
    }
}
