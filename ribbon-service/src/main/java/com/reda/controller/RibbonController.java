package com.reda.controller;

import com.reda.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@EnableHystrix
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @RequestMapping(value = "/hi/{name}" ,method = RequestMethod.GET)
    public String hi(@PathVariable String name) {
        return ribbonService.hiService(name);
    }

    @RequestMapping(value = "/cache/{str}",method = RequestMethod.GET)
    public String testCache(@PathVariable String str) {
        return ribbonService.getMsg(str);
    }

    @RequestMapping(value = "/cache/del",method = RequestMethod.GET)
    public void delCache() {
        ribbonService.delCache();
    }

    @RequestMapping(value = "/merge/{str1}/{str2}",method = RequestMethod.GET)
    public String testMerge(@PathVariable String str1,@PathVariable String str2) throws ExecutionException, InterruptedException {
        Future<String> result1 = ribbonService.get(str1);
        Future<String> result2 = ribbonService.get(str2);
        return result1.get()+"***"+ result2.get();
    }
}
