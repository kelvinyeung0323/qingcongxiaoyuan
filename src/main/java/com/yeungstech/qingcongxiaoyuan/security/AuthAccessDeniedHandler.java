package com.yeungstech.qingcongxiaoyuan.security;

import com.yeungstech.qingcongxiaoyuan.common.RespReult;
import com.yeungstech.qingcongxiaoyuan.enums.RespStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        RespReult.out(httpServletResponse, RespStatus.FAIL,"拒绝访问",null);
    }
}
