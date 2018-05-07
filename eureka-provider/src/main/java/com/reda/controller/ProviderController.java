package com.reda.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping("/{name}")
    public String sayHi(@PathVariable String name) {
        return "hi " +name;
    }
}
