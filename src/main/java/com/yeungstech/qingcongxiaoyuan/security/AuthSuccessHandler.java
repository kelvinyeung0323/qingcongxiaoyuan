package com.yeungstech.qingcongxiaoyuan.security;


import com.yeungstech.qingcongxiaoyuan.common.RespReult;
import com.yeungstech.qingcongxiaoyuan.enums.RespStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    Logger LOG = LoggerFactory.getLogger(AuthSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)  {
        //获取登陆成功用户名
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        LOG.info("登陆成功:{}",username);
        String jwtToken = ((MiniProgramCodeAuthenticationToken)authentication).getJwtToken();
        RespReult.out(httpServletResponse, RespStatus.OK,"登录成功",jwtToken);
    }
}
