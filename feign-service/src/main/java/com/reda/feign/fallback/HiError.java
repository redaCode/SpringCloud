package com.reda.feign.fallback;

import com.reda.feign.Hi;
import org.springframework.stereotype.Component;

@Component
public class HiError implements Hi {
    @Override
    public String hi(String name) {
        return "sorry, " +name;
    }
}
