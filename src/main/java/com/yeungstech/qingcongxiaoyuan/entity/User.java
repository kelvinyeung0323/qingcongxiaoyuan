package com.yeungstech.qingcongxiaoyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    private String id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "phone")
    private String phone;

    @Column(name="last_login_time")
    private Date lastLoginTime; //最后登录时间

    @Column(name = "create_time")
    private Date createdTime;





}
