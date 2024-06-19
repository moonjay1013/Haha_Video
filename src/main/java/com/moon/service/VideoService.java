package com.moon.service;

import com.moon.pojo.Video;

import java.util.List;

/**
 * @author moonjay
 */
public interface VideoService {
    List<Video> findAll();

    void addVideo(Video video);

    void deleteVideo(Integer id);

    void updateVideo(String videoPath,String coverPath,String videoDesc,Integer id);

    List<Video> findAllById(Integer id);
}
