package com.yaya.servicehi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RestController
@EnableHystrix //声明这是一个Hystrix Client,并打开该断路器,让默认配置找到断路器
@EnableHystrixDashboard
@EnableCircuitBreaker //Annotation to enable a CircuitBreaker implementation.
public class ServiceHiApplication {

    /**
     * 访问地址 http://localhost:8762/actuator/hystrix.stream
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name",defaultValue = "yaya") String name){
        return "hi " + name + " , I am from port:"+ port;
    }

    //降级方法必须的参数应该与被执行的方法参数一致,否则hystrix不会查询到降级方法,会直接抛出异常,降级方法也可以同步异步执行
    public String hiError(String name){
        return "hi " + name + ", sorry error";
    }

}
