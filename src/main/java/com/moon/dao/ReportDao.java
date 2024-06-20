package com.moon.dao;

import com.moon.pojo.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author moonjay
 */
@Transactional
public interface ReportDao extends JpaRepository<Report,Integer> {
    @Modifying
    @Query(value = "update t_reports r set r.content = ?1,r.title = ?2 where r.id=?3", nativeQuery = true)
    void updateReport(String content,String title,Integer id);
}
