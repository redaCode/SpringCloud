package com.reda.controller;

import com.reda.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @RequestMapping(value = "/hi/{name}" ,method = RequestMethod.GET)
    public String hi(@PathVariable String name) {
        return ribbonService.hiService(name);
    }

}
