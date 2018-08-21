package com.yaya.servicefeignhystrix.clients.fallback;

import com.yaya.servicefeignhystrix.clients.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,"+name;
    }
}
