package com.yeungstech.qingcongxiaoyuan.wechat.pojo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Jscode2Session {

    private String opentId;
    private String session_key;
    private String unionid;

    private WxErrorCode errcode;
    private String errmsg;


    public String getOpentId() {
        return opentId;
    }

    public void setOpentId(String opentId) {
        this.opentId = opentId;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public WxErrorCode getErrcode() {
        return errcode;
    }

    public void setErrcode(WxErrorCode errcode) {
        this.errcode = errcode;
    }

    @JsonSetter("errcode")
    public void setErrCode(Integer errcode) {
        this.errcode = WxErrorCode.fromCode(errcode);
    }
    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
