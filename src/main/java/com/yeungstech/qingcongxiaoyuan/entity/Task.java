package com.yeungstech.qingcongxiaoyuan.entity;

import com.yeungstech.qingcongxiaoyuan.enums.TaskStatus;
import com.yeungstech.qingcongxiaoyuan.enums.TaskType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    private String id;

    @Column(name="type")
    private TaskType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id",referencedColumnName = "id")
    private User employer;
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private User employee;

    @Column(name ="description")
    private String description;//任务描述

    @Column(name ="address1")
    private String address1;

    @Column(name ="longitude1",length = 20)
    private String longitude1; //经度

    @Column(name ="latitude1",length = 20)
    private String latitude1;//纬度

    @Column(name ="address2")
    private String address2;

    @Column(name ="longitude2",length = 20)
    private String longitude2; //经度

    @Column(name ="latitude2",length = 20)
    private String latitude2;//纬度

    @Column(name ="closingDate")
    private Date closingDate;

    @Column(name ="amt",length = 20)
    private String amt;  //价格或重量

    @Column(name ="fee",length = 20)
    private String fee; //服务费

    @Column(name ="remark")
    private String remark;

    @Column(name ="isAgree")
    private Boolean isAgree;
    @Column(name ="status")
    private TaskStatus status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public User getEmployer() {
        return employer;
    }

    public void setEmployer(User employer) {
        this.employer = employer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getLongitude1() {
        return longitude1;
    }

    public void setLongitude1(String longitude1) {
        this.longitude1 = longitude1;
    }

    public String getLatitude1() {
        return latitude1;
    }

    public void setLatitude1(String latitude1) {
        this.latitude1 = latitude1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getLongitude2() {
        return longitude2;
    }

    public void setLongitude2(String longitude2) {
        this.longitude2 = longitude2;
    }

    public String getLatitude2() {
        return latitude2;
    }

    public void setLatitude2(String latitude2) {
        this.latitude2 = latitude2;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getAgree() {
        return isAgree;
    }

    public void setAgree(Boolean agree) {
        isAgree = agree;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", employer=" + employer +
                ", employee=" + employee +
                ", description='" + description + '\'' +
                ", address1='" + address1 + '\'' +
                ", longitude1='" + longitude1 + '\'' +
                ", latitude1='" + latitude1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", longitude2='" + longitude2 + '\'' +
                ", latitude2='" + latitude2 + '\'' +
                ", closingDate=" + closingDate +
                ", amt='" + amt + '\'' +
                ", fee='" + fee + '\'' +
                ", remark='" + remark + '\'' +
                ", isAgree=" + isAgree +
                ", status=" + status +
                '}';
    }
}
