package com.yeungstech.qingcongxiaoyuan.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class LoginController {

    @Value(value = "{appId}")
    private String APP_ID;

    @GetMapping("wxlogin")
    public void wxLogin(@RequestParam String code){

    }
}
