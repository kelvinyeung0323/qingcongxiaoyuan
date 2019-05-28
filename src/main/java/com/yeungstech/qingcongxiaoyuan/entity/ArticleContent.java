package com.yeungstech.qingcongxiaoyuan.entity;

import com.yeungstech.qingcongxiaoyuan.enums.ArticleContentType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "article_content")
public class ArticleContent {

    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    private String id;
    @Column(name = "type")
    private ArticleContentType type;

    @Column(name = "text")
    private String text;

    @Column(name = "img_url")
    private String imgUrl;

}
