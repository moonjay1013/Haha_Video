package com.moon.controller;

import com.moon.pojo.*;
import com.moon.service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author moonjay
 */
@Controller
@Api(tags = "Table Api")
public class TableController {
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private BgmService bgmService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ReportService reportService;

    /**基本表 --用户、视频、bgm*/
    @RequestMapping(value = "/table/basic")
    public String basic(Model model){
        List<User> userList = userService.findAll();
        List<Video> videoList = videoService.findAll();
        List<Bgm> bgmList = bgmService.findAll();
        model.addAttribute("users",userList);
        model.addAttribute("videos",videoList);
        model.addAttribute("bgms",bgmList);
        return "basic_table";
    }

    /**动态表  模糊查询*/
    @RequestMapping(value = "/table/dynamic")
    public String dynamic(Model model){
        List<Video> videoList = videoService.findAll();
        List<Bgm> bgmList = bgmService.findAll();
        List<Comment> commentsList = commentService.findAll();
        List<Report> reportList = reportService.findAll();
        model.addAttribute("videos",videoList);
        model.addAttribute("bgms",bgmList);
        model.addAttribute("comments",commentsList);
        model.addAttribute("reports",reportList);
        return "dynamic_table";
    }

    /**bgm添加页*/
    @RequestMapping(value = "/layout/blank")
    public String blank(Model model, Bgm bgm){
        model.addAttribute("bgm",bgm);
        return "blank_page";
    }

    /**video添加页*/
    @RequestMapping(value = "/layout/boxed")
    public String boxed(Model model, Video video){
        model.addAttribute("video",video);
        return "boxed_view";
    }
}
