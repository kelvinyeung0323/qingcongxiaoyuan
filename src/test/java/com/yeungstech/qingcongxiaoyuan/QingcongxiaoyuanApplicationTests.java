package com.yeungstech.qingcongxiaoyuan;

import com.yeungstech.qingcongxiaoyuan.wechat.WechatApiService;
import com.yeungstech.qingcongxiaoyuan.wechat.pojo.Jscode2Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QingcongxiaoyuanApplicationTests {


    @Autowired
    WechatApiService wechatApiService;
    @Test
    public void contextLoads() {

       Jscode2Session jscode2Session =  wechatApiService.jscode2session("abc");
       System.out.println(jscode2Session);
    }

}
