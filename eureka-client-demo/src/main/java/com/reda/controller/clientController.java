package com.reda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientController {

    @RequestMapping("/")
    public String hi() {
        return "hi, i am eureka client demo";
    }
}
