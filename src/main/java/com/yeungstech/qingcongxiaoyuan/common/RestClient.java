package com.yeungstech.qingcongxiaoyuan.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

public class RestClient {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static <T> T   getForObject(String url, Class<T> responseType){
        String str  = restTemplate.getForObject(url,String.class);
        try {
            T obj = objectMapper.readValue(str,responseType);
            return obj;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public static <T> T   getForObject(String url, Class<T> responseType, Map<String,Object> params){
       String str  = restTemplate.getForObject(url,String.class,params);
        try {
            T obj = objectMapper.readValue(str,responseType);
            return obj;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
