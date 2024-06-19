package com.moon.dao;

import com.moon.pojo.Bgm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author moonjay
 */
@Transactional
public interface BgmDao extends JpaRepository<Bgm, Integer> {
    @Modifying
    @Query(value = "update t_bgms b SET b.path = ?1,b.musicName=?2,b.author=?3 where b.id =?4", nativeQuery = true)
    void updateBgmAddress(String address,String musicName, String author,Integer bgmId);
}