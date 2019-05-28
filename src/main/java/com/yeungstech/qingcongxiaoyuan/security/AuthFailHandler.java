package com.yeungstech.qingcongxiaoyuan.security;

import com.yeungstech.qingcongxiaoyuan.common.RespReult;
import com.yeungstech.qingcongxiaoyuan.enums.RespStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Component
public class AuthFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) {
        String msg=null;
        if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
            msg="用户名或密码输入错误，登录失败!";
        } else if (exception instanceof DisabledException) {
            msg="账户被禁用，登录失败，请联系管理员!";
        } else {
            msg="登录失败！";
        }

        RespReult.fail(RespStatus.FAIL,msg);

    }
}
