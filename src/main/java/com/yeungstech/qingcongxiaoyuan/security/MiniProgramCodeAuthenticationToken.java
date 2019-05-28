package com.yeungstech.qingcongxiaoyuan.security;

import com.yeungstech.qingcongxiaoyuan.wechat.pojo.Jscode2Session;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2019/5/6
 * @description:
 */
public class MiniProgramCodeAuthenticationToken extends AbstractAuthenticationToken {

    private String sessionKey;
    private String openId;
    private String jwtToken;

    public MiniProgramCodeAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public MiniProgramCodeAuthenticationToken(String openId,String sessionKey,Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.openId = openId;
        this.sessionKey = sessionKey;
    }

    @Override
    public Object getCredentials() {
        return this.sessionKey;
    }

    @Override
    public Object getPrincipal() {
        return openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
