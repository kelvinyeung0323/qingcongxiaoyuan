package com.yeungstech.qingcongxiaoyuan.entity;

import com.yeungstech.qingcongxiaoyuan.enums.BillAction;
import com.yeungstech.qingcongxiaoyuan.enums.BillType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_id",referencedColumnName = "id")
    private User payer;//付款人；

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payee_id",referencedColumnName = "id")
    private User payee;//收款人；

    @Column(name = "type")
    private BillType type;

    @Column(name = "action")
    private BillAction action;

    @Column(name = "amt",length = 20)
    private String amt;

    @Column(name = "content")
    private String content;//

    @Column(name = "created_time")
    private Date createdTime;

}
