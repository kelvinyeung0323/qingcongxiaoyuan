package com.yeungstech.qingcongxiaoyuan.enums;

public enum RespStatus {

    OK(200,"ok"),
    FAIL(500,"fail");

    private Integer code;
    private String msg;

    RespStatus(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
