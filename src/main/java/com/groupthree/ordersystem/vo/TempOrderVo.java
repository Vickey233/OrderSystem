package com.groupthree.ordersystem.vo;

import lombok.Data;

@Data
public class TempOrderVo {
    private Integer userId;

    private Integer addressId;

    private Double sum;

    private String password;

    private Integer[] commodityList;

    private int[] commodityCount;

}
