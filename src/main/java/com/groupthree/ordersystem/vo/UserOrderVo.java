package com.groupthree.ordersystem.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserOrderVo {

    private String orderId;

    private String statue;

    private Double sum;
}
