package com.yaya.servicehi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    public static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value="/hi")
    public String callHome(){
        LOG.log(Level.INFO,"calling trace service-hi");
        return restTemplate.getForObject("http://localhost:8989/miya",String.class); //如此配置 发送请求 http://localhost:8989/miya,无任何信息在 http://localhost:9411/dependency 控制台上
        //return restTemplate.getForObject("http://localhost:8989/hi",String.class); //即便是如此配置 依然只显示 只有请求 http://localhost:8988/hi 才会在zipkin平台上有反应
    }

    @RequestMapping(value="/info")
    public String info(){
        LOG.log(Level.INFO, "calling trace service-hi");
        return "i'm service-hi";
    }

    @Bean
    public AlwaysSampler defaultSampler(){ //开发者还可以直接在代码中创建AlwaysSampler实例来指定100%输出日志，效果跟spring.sleuth.sampler.percentage=1是一样的。
        return new AlwaysSampler();
    }
}
