package com.moon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moonjay
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!!";
    }
}

