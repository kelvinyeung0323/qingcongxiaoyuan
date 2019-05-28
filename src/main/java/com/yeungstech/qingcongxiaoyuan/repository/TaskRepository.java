package com.yeungstech.qingcongxiaoyuan.repository;

import com.yeungstech.qingcongxiaoyuan.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2019/5/9 21:46
 * @description:
 */
public interface TaskRepository extends JpaRepository<Task,String>{
}
