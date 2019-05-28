package com.yeungstech.qingcongxiaoyuan.wechat.pojo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WxErrorCode {

    SYSTEM_BUSY(-1, "系统繁忙，此时请开发者稍候再试"),
    SUCESS(0, "请求成功"),
    INVALID_APPID(40013,"无效的appid"),
    INVALID_CODE(40029, "code 无效"),
    REQUIRE_HTTPS(43003,"需要使用https"),
    FREQUENCY_RESTRICT(45011, "频率限制，每个用户每分钟100次"),
    UNKNOWN(-9999,"未知错误");

    private int code;
    private String msg;

    WxErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @JsonValue
    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

    public static WxErrorCode fromCode(Integer code){
        WxErrorCode[] wxErrorCodes = WxErrorCode.class.getEnumConstants();
        for(WxErrorCode e:wxErrorCodes){
            if(e.getCode()==code){
                return e;
            }
        }
        return UNKNOWN;
    }

}
