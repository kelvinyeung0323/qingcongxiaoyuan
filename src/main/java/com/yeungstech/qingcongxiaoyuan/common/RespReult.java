package com.yeungstech.qingcongxiaoyuan.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeungstech.qingcongxiaoyuan.enums.RespStatus;
import org.springframework.data.domain.Page;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespReult {

    private RespStatus status;
    private String msg ;
    private Object data;

    //分页信息
    private Integer pageSize;
    private Integer pageNum;
    private Long totalSize;

    public RespStatus getStatus() {
        return status;
    }

    public void setStatus(RespStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RespReult() {

    }

    //分页信息------------------------
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }


    //-----------------构造函数
    private RespReult(RespStatus status) {
        this.msg = status.getMsg();
        this.status = status;
    }

    private RespReult(RespStatus status, Object data) {
        this.msg = status.getMsg();
        this.status = status;
        this.data = data;
    }


    private RespReult(RespStatus status, String msg, Object data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    private RespReult(RespStatus status, String msg, Object data,Long totalSize,Integer pageNum,Integer pageSize){
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.totalSize = totalSize;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public RespReult page(Page page){
        this.pageSize = page.getSize();
        this.data = page.getContent();
        this.pageNum = page.getNumber();
        this.totalSize= page.getTotalElements();
        return this;
    }

    //---------------------------

    public static RespReult ok() {

        return new RespReult(RespStatus.OK);
    }

    public static RespReult ok(Object data) {

        return new RespReult(RespStatus.OK, data);
    }

    public static RespReult ok(Object data, String msg) {
        return new RespReult(RespStatus.OK, msg, data);
    }

    public static RespReult fail() {

        return new RespReult(RespStatus.FAIL);
    }

    public static RespReult fail(Object data) {

        return new RespReult(RespStatus.FAIL, data);
    }

    public static RespReult fail(Object data, String msg) {
        return new RespReult(RespStatus.FAIL, msg, data);
    }


    public static RespReult page(Object data,Long totalSize,Integer pageNum,Integer pageSize){

        return new RespReult(RespStatus.OK,  RespStatus.OK.getMsg(),  data, totalSize, pageNum, pageSize);
    }

    public static RespReult page(Object data,Long totalSize,Integer pageNum,Integer pageSize,String msg){

        return new RespReult(RespStatus.OK,  msg,  data, totalSize, pageNum, pageSize);
    }

    public static RespReult page(Page page,String msg){
        return new RespReult(RespStatus.OK,msg,page.getContent(),page.getTotalElements(),page.getNumber(),page.getSize());
    }


    public static void out(HttpServletResponse  response, RespStatus status, String msg, String data) {
        RespReult respResult = new RespReult(status,msg,data);
        try {
            response.getWriter().write(respResult.toJSON());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String toJSON(){
        ObjectMapper om = new ObjectMapper();
        String str = "{\"status\":500,\"msg\":\"JSON转换错误\"}";
        try {
            str = om.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }



}
