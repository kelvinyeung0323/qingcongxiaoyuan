package com.yeungstech.qingcongxiaoyuan.wechat;


import com.google.common.collect.Lists;
import com.yeungstech.qingcongxiaoyuan.common.RestClient;
import com.yeungstech.qingcongxiaoyuan.wechat.pojo.Jscode2Session;
import com.yeungstech.qingcongxiaoyuan.wechat.pojo.UnifiedOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WechatApiService {

    //@Value("{wx.appid}")
    private String APP_ID="wx78a7676cd3f49bef";
    //@Value("{wx.appSecret}")
    private String APP_SECRET="507741ab99e8ed95c794ebd608d5565e";

    public String WX_SERVER="https://api.weixin.qq.com/";

    /** 小程序登录 */
    public String URL_JSCODE_2_SESSION="sns/jscode2session";
    /** 统一下单  */
    public String URL_UNIFIED_ORDER ="";

    /**
     * auth.code2Session
     * <link>https://developers.weixin.qq.com/miniprogram/dev/api-backend/auth.code2Session.html</link>
     * 登录凭证校验。通过 wx.login() 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
     * @param code
     * @return
     */
    public Jscode2Session jscode2session(String code){

        String url = WX_SERVER+URL_JSCODE_2_SESSION +"?appid="+APP_ID+"&secret="+APP_SECRET+"&js_code="+code +"&grant_type=authorization_code";
        Jscode2Session jscode2Session=  RestClient.getForObject(url, Jscode2Session.class);

        return jscode2Session;
    }



    public void unifiedOrder(UnifiedOrder order){
        String url = WX_SERVER+URL_UNIFIED_ORDER;
        //RestClient.getForObject()
    }

}
