package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@ApiModel(value = "Comment实体类", description = "video comment")
@Entity
@Table(name = "t_comments")
@Setter
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "from_user_id",nullable = false)
    private Integer fromUserId;
    @Column(name = "video_id",nullable = false)
    private Integer videoId;
    @Column(nullable = false)
    private String comment;
    @Column(name = "create_time", nullable = false)
    private String createTime;

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", fromUserId=" + fromUserId +
                ", videoId=" + videoId +
                ", comment='" + comment + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
