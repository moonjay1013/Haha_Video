package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author moonjay
 */
@ApiModel(value = "BGM实体类", description = "bgm信息描述")
@Entity
@Table(name = "t_bgms")
@Setter
@Getter
public class Bgm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 64)
    private Integer id;
    @Column(nullable = false)
    private String author;
    @Column(name = "music_name", nullable = false)
    private String musicName;
    @Column(nullable = false)
    private String path;
}
