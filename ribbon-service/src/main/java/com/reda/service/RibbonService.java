package com.reda.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.reda.entity.Obj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class RibbonService {

    @Autowired
    LoadBalancerClient loadBalancerClient;


    public String hiService(String name) {
        ServiceInstance si = loadBalancerClient.choose("eureka-provider");
        StringBuffer url = new StringBuffer("http://");
        url.append(si.getHost());
        url.append(":");
        url.append(si.getPort());
        url.append("/");
        url.append(name);

        System.out.println(url.toString());

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url.toString(),String.class);

    }

    @CachePut(value = "reda",key = "#param")
    public String getMsg(String param) {
        System.out.println("from db");
        return new Obj(param).toString();
    }

    @CacheEvict(value = "reda",allEntries = true)
    public void delCache() {
        System.out.println("del cache");
    }

    @HystrixCollapser(batchMethod = "batchGet", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "10"),
            @HystrixProperty(name = "maxRequestsInBatch", value = "200"),
    })
    public Future<String> get(String name) {
        System.out.println("not execute");
        return null;
    }

    @HystrixCommand
    public List<String> batchGet(List<String> names) {
        List<String> result = new ArrayList<>();
        System.out.println("batch method");
        for (String name:names) {
            System.out.println(name);
        }
        return result;

    }

    public String fallback(String name) {
        return "sorry ,error" + name;
    }

}
