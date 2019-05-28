package com.yeungstech.qingcongxiaoyuan.entity;

import com.yeungstech.qingcongxiaoyuan.enums.ArticleStatus;
import com.yeungstech.qingcongxiaoyuan.enums.ArticleType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    private String id;

    @Column(name="type")
    private ArticleType type;

    @Column(name="title")
    private String title;

    @Column(name="cover_photo")
    private String coverPhoto;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(name="status")
    private ArticleStatus status;

    @Column(name="read_cnt")
    private Integer readCnt;

    @Column(name = "like_cnt")
    private Integer likeCnt;

    @Column(name = "shared_cnt")
    private Integer sharedCnt;

    @Column(name="created_time")
    private Date createdTime;

    @Column(name="modified_time")
    private Date modifiedTime;


}
