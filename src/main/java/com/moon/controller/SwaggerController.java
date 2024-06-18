package com.moon.controller;

import com.moon.pojo.*;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author moonjay
 */
@Controller
@Api(tags = "使用swagger的@ApiModel 须使用@RequestBody 否则无法显示models")
public class SwaggerController {

    @RequestMapping("user")
    public String hello1(@RequestBody User user){
        return user.toString();
    }
}