package com.yeungstech.qingcongxiaoyuan.enums;

public enum ArticleType {

    FRESH_EVENT(1,"新鲜事"),
    NEWS_FLASH(2,"快讯");

    private Integer value;
    private String desc;

    ArticleType(Integer value, String desc){
        this.value = value;
        this.desc = desc;
    }
}
