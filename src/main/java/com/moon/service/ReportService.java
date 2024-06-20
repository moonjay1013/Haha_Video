package com.moon.service;

import com.moon.pojo.Report;

import java.util.List;

public interface ReportService {
    List<Report> findAll();

    void addReport(Report userReport);

    void deleteReport(Integer id);

    void updateReport(String content,String title,Integer id);

    Report getById(Integer id);
}