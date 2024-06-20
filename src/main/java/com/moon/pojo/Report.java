package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@ApiModel(value = "Report实体类", description = "用户对某个视频的反馈")
@Entity
@Table(name = "t_reports")
@Setter
@Getter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 64)
    private Integer id;
    @Column(name = "dealt_user_id", length = 64, nullable = false)
    private Integer userId;
    @Column(name = "dealt_video_id", length = 64, nullable = false)
    private Integer videoId;
    @Column(length = 128, nullable = false)
    private String title;
    private String content;
    @Column(length = 64, nullable = false)
    private Integer uId;
    @Column(name = "create_time", nullable = false)
    private String createTime;

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", uId=" + uId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
