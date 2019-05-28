package com.yeungstech.qingcongxiaoyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article_comment")
public class ArticleComment {

    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    private String id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id",referencedColumnName = "id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


    @Column(name = "like_cnt")
    private Integer likeCnt;


    @Column(name = "created_time")
    private Date createdTime;

    @Column(name ="modified_time")
    private Date modifiedTime;
}
