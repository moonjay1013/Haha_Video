package com.moon.controller;

import com.moon.pojo.Comment;
import com.moon.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author moonjay
 */
@Controller
@Api(tags = "评论表CRUD操作")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/addC")
    public String addC(Model model, Comment comments){
        model.addAttribute("comment",comments);
        return "addComment";
    }

    /**comment添加功能  重定向动态表页面*/
    @PostMapping("/addComment")
    public String addReport(@ModelAttribute Comment comments){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        // 评论信息的默认创建时间为当前的日期
        comments.setCreateTime(currentTime);
        Integer id = (int)(1+Math.random()*10);
        comments.setFromUserId(id);
        System.out.println(comments.getFromUserId());
        commentService.addComment(comments);
        return "redirect:/table/dynamic";
    }

    /**删除comment 重定向到表格页*/
    @RequestMapping("/delComment")
    public String del(Comment comments){
        commentService.deleteComment(comments.getId());
        return "redirect:/table/dynamic";
    }

    /**comment更新页*/
    @GetMapping("/updateC/{id}")
    public String toUpdateReport(@PathVariable("id") Integer id, Model model) {
        Comment comments = commentService.getById(id);
        model.addAttribute("comment", comments);
        return "updateComment";
    }

    /**更新report*/
    @RequestMapping("/updateComment")
    public String updateBgm(@ModelAttribute Comment comments) {
        commentService.updateComment(comments.getComment(),comments.getId());
        return "redirect:/table/dynamic";
    }
}

