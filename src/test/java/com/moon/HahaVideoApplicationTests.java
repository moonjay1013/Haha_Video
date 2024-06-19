package com.moon;

import com.moon.pojo.*;
import com.moon.service.BgmService;
import com.moon.service.UserService;
import com.moon.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class HahaVideoApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private BgmService bgmService;

    @Test
    void contextLoads() {
        System.out.println("This is Unit Test class");
    }

    @Test
    void testUserInsert(){
        /* org.junit.jupiter.api.extension.ParameterResolutionException:
          No ParameterResolver registered for parameter
          @Test func no need parameters
         */
        User user = new User();
        user.setFaceImage("");
        user.setName("moonjay");
        user.setNickname("moonjay");
        user.setPwd("123456");

        try {
            userService.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("user insert func completed!");
        }
    }

    @Test
    void testFindUserByNP(){
        try {
            User u = userService.findUser("moonjay", "123456");
            System.out.println(u.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testVideoInsert(){
        Video video = new Video();
        video.setVideoDesc("1st video");
        video.setAudioId(1);
        video.setVideoHeight(100);
        video.setVideoWidth(100);
        // 视频的长、宽默认为100
        // 点赞数默认为0,状态码默认为0
        video.setLikeCounts(0L);
        video.setStatus(0);
        video.setUserId(1);
        // 视频的默认创建时间为当前的日期
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        video.setCrateTime(currentTime);
        // 文件的path
        video.setVideoPath("/videos/funny01.mp4");
        video.setCoverPath("/videos/funny1.jpg");
        try {
            videoService.addVideo(video);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("video insert func completed!");
        }
    }

    @Test
    void testBgmInsert(){
        Bgm bgm = new Bgm();
        bgm.setAuthor("moonjay");
        bgm.setMusicName("love story");
        bgm.setPath("/bgm/许嵩 - 最佳歌手.mp3");
        try {
            bgmService.addBgm(bgm);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("bgm insert func completed!");
        }
    }

}
