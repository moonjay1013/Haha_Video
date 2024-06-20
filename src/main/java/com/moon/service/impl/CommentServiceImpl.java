package com.moon.service.impl;

import com.moon.dao.CommentDao;
import com.moon.pojo.Comment;
import com.moon.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moonjay
 */
@Service("CommentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public void addComment(Comment comments) {
        commentDao.save(comments);
    }

    @Override
    public void deleteComment(Integer id) {
        Comment comment = commentDao.getById(id);
        commentDao.delete(comment);
    }

    @Override
    public void updateComment(String comment, Integer id) {
        commentDao.updateComment(comment, id);
    }

    @Override
    public Comment getById(Integer id) {
        return commentDao.getById(id);
    }
}
