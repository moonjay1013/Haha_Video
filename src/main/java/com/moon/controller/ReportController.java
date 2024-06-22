package com.moon.controller;

import com.moon.pojo.Report;
import com.moon.service.ReportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Api(tags = "举报信息表CRUD操作")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/addR")
    public String addB(Model model, Report report){
        model.addAttribute("report",report);
        return "addReport";
    }
    /**Report添加功能  重定向动态表页面*/
    @PostMapping("/addReport")
    public String addReport(@ModelAttribute Report report){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        // 举报信息的默认创建时间为当前的日期
        Integer id = (int)(1+Math.random()*10);
        report.setUId(id);
        report.setCreateTime(currentTime);
        reportService.addReport(report);
        return "redirect:/table/dynamic";
    }

    /**删除report 重定向到表格页*/
    @RequestMapping("/delReport")
    public String del(Report userReport){
        reportService.deleteReport(userReport.getId());
        return "redirect:/table/dynamic";
    }

    /**report更新页*/
    @GetMapping("/updateR/{id}")
    public String toUpdateReport(@PathVariable("id") Integer id, Model model) {
        Report userReport = reportService.getById(id);
        model.addAttribute("report", userReport);
        return "updateReport";
    }

    /**更新report*/
    @RequestMapping("/updateReport")
    public String updateBgm(@ModelAttribute Report userReport) {
        reportService.updateReport(userReport.getContent(),userReport.getTitle(),userReport.getId());
        return "redirect:/table/dynamic";
    }
}