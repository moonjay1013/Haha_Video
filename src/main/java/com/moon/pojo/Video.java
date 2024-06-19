package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author moonjay
 */
@ApiModel(value = "视频实体类", description = "视频信息描述")
@Entity
@Table(name = "t_videos")
@Setter
@Getter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "audio_id")
    private Integer audioId;
    @Column(name = "video_desc", length = 128)
    private String videoDesc;
    @Column(name = "video_path", nullable = false)
    private String videoPath;
    @Column(name = "video_seconds", precision = 6, scale = 2)
    /** precision和scale属性只在BigDecimal类型中有效*/
    private Float videoSeconds;
    @Column(name = "video_width")
    private Integer videoWidth;
    @Column(name = "video_height")
    private Integer videoHeight;
    @Column(name = "cover_path", nullable = false)
    private String coverPath;
    @Column(name = "like_counts")
    private Long likeCounts;
    private Integer status;
    @ApiModelProperty(value = "创建时间（datetime）")
    @Column(name = "create_time", nullable = false)
    private String crateTime;
    // 直接将java.util.Date存入数据库是不行的！
}
