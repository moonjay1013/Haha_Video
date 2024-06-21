package com.moon.controller;

import com.moon.pojo.Video;
import com.moon.service.VideoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author moonjay
 */
@Controller
@Api(tags = "用户信息，附加页面（404/500）")
public class ExtraController {
    @Autowired
    private VideoService videoService;

    /**用户详情页 显示该用户上传的视频*/
    @RequestMapping(value = "/extra/profile/{id}")
    public String profile(Model model, @PathVariable Integer id){
        // 根据用户id查询其上传的所有视频
        List<Video> videoList = videoService.findAllById(id);
        model.addAttribute("vs",videoList);
        return "profile";
    }

    @RequestMapping(value = "/extra/404")
    public String notFound(){ return "error/404"; }

    @RequestMapping(value = "/extra/500")
    public String errorPage(){ return "error/500"; }

    @RequestMapping(value = "/extra/lock")
    public String lock(){
        return "lock_screen";
    }
}
