package com.moon.service.impl;

import com.moon.dao.ReportDao;
import com.moon.pojo.Report;
import com.moon.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;

    @Override
    public List<Report> findAll() {
        return reportDao.findAll();
    }

    @Override
    public void addReport(Report userReport) {
        reportDao.save(userReport);
    }

    @Override
    public void deleteReport(Integer id) {
        Report userReport = reportDao.getById(id);
        reportDao.delete(userReport);
    }

    @Override
    public void updateReport(String content, String title, Integer id) {
        reportDao.updateReport(content, title, id);
    }

    @Override
    public Report getById(Integer id) {
        return reportDao.getById(id);
    }
}
