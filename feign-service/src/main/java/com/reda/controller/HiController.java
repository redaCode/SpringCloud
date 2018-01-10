package com.reda.controller;

import com.reda.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HiController {

    @Autowired
    HiService hiService;

    @RequestMapping(value = "/hi/{name}",method = RequestMethod.GET)
    public String hi(@PathVariable String name) {
        return hiService.sayHi(name);
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map info() {
        return new HashMap();
    }
}
