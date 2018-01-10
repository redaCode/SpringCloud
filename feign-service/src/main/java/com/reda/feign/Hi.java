package com.reda.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-demo")
public interface Hi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String hi(@RequestParam("name")String name);
}
