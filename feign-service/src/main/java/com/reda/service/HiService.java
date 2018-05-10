package com.reda.service;

import com.reda.feign.Hi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    Hi hi;

    public String sayHi(String name) {
        return hi.hi(name);
    }
}
