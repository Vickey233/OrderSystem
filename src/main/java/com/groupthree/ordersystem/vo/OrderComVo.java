package com.groupthree.ordersystem.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderComVo {

    private String commodityName;

    private Double price;

    private Integer count;

    private Date createDate;
}
