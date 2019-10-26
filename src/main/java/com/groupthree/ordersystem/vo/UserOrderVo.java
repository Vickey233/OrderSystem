package com.groupthree.ordersystem.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserOrderVo {

    private String commodityName;

    private Integer count;

    private Date createDate;

    private String statue;

    private Double sum;
}
