package com.reda.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public String fallback(String name) {
        return "sorry ,error" + name;
    }
}
