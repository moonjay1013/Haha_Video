package com.moon.service;

import com.moon.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    void addComment(Comment comments);

    void deleteComment(Integer id);

    void updateComment(String comment,Integer id);

    Comment getById(Integer id);
}
