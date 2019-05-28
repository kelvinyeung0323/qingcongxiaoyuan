package com.yeungstech.qingcongxiaoyuan.security;

import com.yeungstech.qingcongxiaoyuan.common.RespReult;
import com.yeungstech.qingcongxiaoyuan.entity.User;
import com.yeungstech.qingcongxiaoyuan.enums.RespStatus;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.cache.CacheManager;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {


    @Value("${jwt.signKey}")
    private String JWT_SIGN_KEY;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authentication");
        if (header == null || !header.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }

        MiniProgramCodeAuthenticationToken authentication = getAuthentication(request, response);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }

    private MiniProgramCodeAuthenticationToken getAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authentication");
        if (token != null) {
            Claims claims = null;

            try {
                claims= Jwts.parser()
                        //TODO:sign key
                        .setSigningKey(JWT_SIGN_KEY)
                        .parseClaimsJws(token.replace("Bearer ", ""))
                        .getBody();
               String openId =  claims.getSubject();
               String sessionKey = claims.get("sessionKey",String.class);

                return new MiniProgramCodeAuthenticationToken(openId,sessionKey,null);


            } catch (ExpiredJwtException e) {
                logger.error("Token已过期: {} " + e);

            } catch (UnsupportedJwtException e) {
                logger.error("Token格式错误: {} " + e);
                RespReult.out(response, RespStatus.FAIL, "Token格式错误", null);
            } catch (MalformedJwtException e) {
                logger.error("Token没有被正确构造: {} " + e);
                RespReult.out(response, RespStatus.FAIL, "Token没有被正确构造", null);
            } catch (SignatureException e) {
                logger.error("签名失败: {} " + e);
                RespReult.out(response, RespStatus.FAIL, "签名失败", null);
            } catch (IllegalArgumentException e) {
                RespReult.out(response, RespStatus.FAIL, "非法参数异常", null);
            }
        }
        return null;
    }
}
