package com.reda.controller;

import com.reda.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableHystrix
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @RequestMapping(value = "/hi/{name}" ,method = RequestMethod.GET)
    public String hi(@PathVariable String name) {
        return ribbonService.hiService(name);
    }

}
