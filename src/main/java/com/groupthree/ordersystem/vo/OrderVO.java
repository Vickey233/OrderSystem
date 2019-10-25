package com.groupthree.ordersystem.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderVO {

    private  String orderId;

    private Integer userId;

    private String realName;

    private String phoneNumber;

    private String address;

    private Date createDate;

    private Date updateDate;
}
