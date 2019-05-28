package com.yeungstech.qingcongxiaoyuan.security;

import com.yeungstech.qingcongxiaoyuan.wechat.WechatApiService;
import com.yeungstech.qingcongxiaoyuan.wechat.pojo.Jscode2Session;
import com.yeungstech.qingcongxiaoyuan.wechat.pojo.WxErrorCode;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;

import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 微信小程序登录
 */
public class MiniProgramAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    @Value("${jwt.signKey}")
    private String JWT_SIGN_KEY;

    @Autowired
    private WechatApiService wechatApiService;
    protected MiniProgramAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String code = (String) request.getAttribute("code");
        //调用微信接口获取session
        Jscode2Session jscode2Session = wechatApiService.jscode2session(code);
        if(WxErrorCode.SUCESS !=jscode2Session.getErrcode()){
            throw new AuthenticationServiceException(jscode2Session.getErrcode().getMsg());
        }

        MiniProgramCodeAuthenticationToken token= new MiniProgramCodeAuthenticationToken(jscode2Session.getOpentId(),jscode2Session.getSession_key(),null);
        token.setAuthenticated(true);
        return token;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        if (logger.isDebugEnabled()) {
            logger.debug("Authentication success. Updating SecurityContextHolder to contain: "
                    + authResult);
        }

        SecurityContextHolder.getContext().setAuthentication(authResult);


        // Fire event
        if (this.eventPublisher != null) {
            eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(
                    authResult, this.getClass()));
        }

        //生成Jwt
        String token = Jwts.builder()
                //主题 放入用户名
                .setSubject((String)authResult.getPrincipal())
                //自定义属性 放入用户拥有权限
                .claim("sessionKey", authResult.getCredentials())
                //失效时间 7天
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 *7))
                //签名算法和密钥
                .signWith(SignatureAlgorithm.HS512,JWT_SIGN_KEY)
                .compact();
        token = "Bearer " + token;

        ((MiniProgramCodeAuthenticationToken)authResult).setJwtToken(token);
        getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
    }



}
