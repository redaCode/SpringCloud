package com.reda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String test() {
        return "hi, i am eureka client demo";
    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String hi(@RequestParam String name) {
        return "hi, i am " +name;
    }
}
