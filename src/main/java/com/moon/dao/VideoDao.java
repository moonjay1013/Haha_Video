package com.moon.dao;

import com.moon.pojo.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author moonjay
 */
@Transactional
public interface VideoDao extends JpaRepository<Video,Integer> {
    @Modifying
    @Query(value = "update t_videos v set v.videoPath = ?1, v.coverPath = ?2, v.videoDesc = ?3 where v.id = ?4",
            nativeQuery = true)
    void updateById(String videoPath, String coverPath, String videoDesc, Integer id);

    @Query(value = "select * from t_videos v where v.user_id = ?1", nativeQuery = true)
    List<Video> findAllByUserId(Integer user_id);
}
