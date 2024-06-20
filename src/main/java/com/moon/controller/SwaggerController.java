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

    @RequestMapping("bgm")
    public String hello2(@RequestBody Bgm bgm){
        return bgm.toString();
    }

    @RequestMapping("video")
    public String hello3(@RequestBody Video video){
        return video.toString();
    }

    @RequestMapping("comment")
    public String hello4(@RequestBody Comment comment){
        return comment.toString();
    }

    @RequestMapping("report")
    public String hello5(@RequestBody Report report){
        return report.toString();
    }
}