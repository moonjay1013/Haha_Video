package com.moon;

import com.moon.pojo.*;
import com.moon.service.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Autowired
    private CommentService commentService;
    @Autowired
    private ReportService reportService;

    // 指定要打印日志的目标类
    private static final Logger log = LoggerFactory.getLogger(HahaVideoApplicationTests.class);

    Date dt = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentTime = sdf.format(dt);

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

    @Test
    void testCommentInsert(){
        Comment c = new Comment();
        c.setComment("hahahaha so funny");
        c.setVideoId(1);
        c.setCreateTime(currentTime);
        c.setFromUserId(1);

        try {
            commentService.addComment(c);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("comment insert func completed!");
        }
    }

    @Test
    void testReportInsert(){
        Report r = new Report();
        r.setContent("视频质量不高！");
        r.setCreateTime(currentTime);
        r.setTitle("匿名举报");
        r.setUserId(2);  // 被举报视频的上传者
        r.setVideoId(2);
        r.setUId(1);  // 报告人

        try {
            reportService.addReport(r);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Report insert func completed!");
        }
    }

    @Test
    public void TestLogFactory() {
        log.warn("Hello ExecutorService");
        log.error("Hello ExecutorService");
        log.info("Hello ExecutorService");
        log.debug("Hello ExecutorService");
    }

}
