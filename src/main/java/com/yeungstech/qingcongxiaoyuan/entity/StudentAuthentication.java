package com.yeungstech.qingcongxiaoyuan.entity;

import com.yeungstech.qingcongxiaoyuan.enums.Gender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_autentication")
public class StudentAuthentication {


    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_9id",referencedColumnName = "id")
    private User user;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "photo1")
    private String photo1;

    @Column(name = "photo2")
    private String photo2;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "modified_time")
    private Date modifiedTime;

}
