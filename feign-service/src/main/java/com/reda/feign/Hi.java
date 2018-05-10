package com.reda.feign;

import com.reda.feign.fallback.HiError;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-provider",fallback = HiError.class)
public interface Hi {
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    String hi(@PathVariable("name")String name);
}
