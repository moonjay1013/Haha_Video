package com.moon.controller;

import com.moon.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/user_API")
    public User user(){
        /*
        * only test swagger doc
        * */
        return new User();
    }
}

