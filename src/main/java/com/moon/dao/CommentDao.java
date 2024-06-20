package com.moon.dao;

import com.moon.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author moonjay
 */
@Transactional
public interface CommentDao extends JpaRepository<Comment,Integer> {
    @Modifying
    @Query(value = "update t_comments c set c.comment = ?1 where c.id = ?2", nativeQuery = true)
    void updateComment(String comment,Integer id);
}
