package com.yeungstech.qingcongxiaoyuan.entity;

import com.yeungstech.qingcongxiaoyuan.enums.TaskStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 任务操作流水
 */
@Entity
@Table(name = "task_log")
public class TaskLog {

    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    @Column(length = 32)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private Task task;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    private User user;
    @Column(name = "action_type")
    private TaskStatus actionType;
    @Column(name = "remark",length = 255)
    private String remark; //备注
    @Column(name = "created_time")
    private Date createdTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskStatus getActionType() {
        return actionType;
    }

    public void setActionType(TaskStatus actionType) {
        this.actionType = actionType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "TaskLog{" +
                "id='" + id + '\'' +
                ", task=" + task +
                ", user=" + user +
                ", actionType=" + actionType +
                ", remark='" + remark + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
