package com.groupthree.ordersystem.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderVO {

    private  Integer orderId;

    private Integer userId;

    private Integer realName;

    private String phoneNumber;

    private String address;
}
