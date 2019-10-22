package com.groupthree.ordersystem.vo;

import lombok.Data;

@Data
public class OrderComVo {

    private String commodityName;

    private Double price;

    private Integer count;
}
