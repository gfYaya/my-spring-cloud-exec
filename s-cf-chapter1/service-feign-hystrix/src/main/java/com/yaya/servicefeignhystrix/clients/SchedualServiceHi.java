package com.yaya.servicefeignhystrix.clients;

import com.yaya.servicefeignhystrix.clients.fallback.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    //只用@ReuqestParam String name 不行,需要指定此Annotation具体的value值
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
