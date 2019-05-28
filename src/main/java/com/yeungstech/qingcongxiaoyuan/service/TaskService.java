package com.yeungstech.qingcongxiaoyuan.service;

import com.yeungstech.qingcongxiaoyuan.entity.Task;
import com.yeungstech.qingcongxiaoyuan.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2019/5/9 21:40
 * @description:
 */
@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;
    /**
     * 最新任务
     * @return
     */
    public List<Task> latestTask(){

        //TODO:返回最新20条任务
        Pageable pageable = PageRequest.of(1,20,new Sort(Sort.Direction.DESC,"modifiedTime"));
        Page<Task> tasks= taskRepository.findAll(pageable);
        return tasks.getContent();
    }


    /**
     * 发布任务
     * @param task
     * @return
     */
    public Task publish(Task task){

        //TODO:夜间21：00-03:00期间服务费将上调至最低5元起!

        //TODO:验证session_key是否有效？
        //TODO:调用支付统一下单API()
        //组合数据再次签名:

        //返回支付参数(5个参数和sign)
        return taskRepository.save(task);
    }

    /**
     * 取消任务
     * @return
     */
    public Task cancel(){
        /**
         * 取消任务
         */
        return null;
    }










}
