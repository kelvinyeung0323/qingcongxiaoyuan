package com.yeungstech.qingcongxiaoyuan.enums;

public enum Gender {
    UNKNOWN(0,"未知"),
    MALE(0,"男"),
    FEMALE(0,"女");

    private Integer value;
    private String desc;
    Gender(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue(){
        return this.value;
    }
}
