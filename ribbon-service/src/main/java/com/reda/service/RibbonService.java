package com.reda.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.reda.entity.Obj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @HystrixCommand(fallbackMethod = "fallback")
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

    @Cacheable(value = "reda")
    public String getMsg(String param) {
        System.out.println("from db");
        return new Obj(param).toString();
    }

    @CacheEvict(value = "reda")
    public void delCache() {
        System.out.println("del cache");
    }

    public String fallback(String name) {
        return "sorry ,error" + name;
    }
}
