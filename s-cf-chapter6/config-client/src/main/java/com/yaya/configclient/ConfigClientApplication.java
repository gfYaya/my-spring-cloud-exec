package com.yaya.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope // A Scope implementation that allows for beans to be refreshed dynamically at runtime (see refresh(String) and refreshAll()).
@RestController
public class ConfigClientApplication {
    /*
     * http://localhost:8881/actuator/bus-refresh ,post请求之后,需要修改idea 下的target项目中的配置文件才有效,会自动刷新配置,因为@RefreshScope
     */

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

   @Value("${foo}")
    String foo;

    @RequestMapping(value="/hi")
    public String hi(){
        return foo;
    }

}
