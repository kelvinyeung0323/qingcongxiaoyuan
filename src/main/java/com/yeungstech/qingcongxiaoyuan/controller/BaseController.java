package com.yeungstech.qingcongxiaoyuan.controller;

import com.yeungstech.qingcongxiaoyuan.common.RespReult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @ExceptionHandler
    @ResponseBody
    public RespReult exceptionHandler(HttpServletRequest request, Exception ex){
        return  RespReult.fail(ex.getMessage());
    }


//    public  static final String SECURITY_USER= "estate.security.user";

//    public SysUser getCurrentUser(HttpServletRequest request){
//        return (SysUser)request.getSession().getAttribute(SECURITY_USER);
//    }
}
