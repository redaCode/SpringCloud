package com.reda.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-demo/hi?name="+name,String.class);
    }

    public String fallback(String name) {
        return "sorry ,error" + name;
    }
}
