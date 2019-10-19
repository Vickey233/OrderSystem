package com.groupthree.ordersystem.vo;

import lombok.Data;

import java.util.Date;


@Data
public class CommodityVo {

    private Integer commodityId;

    private String commodityName;

    private String imagePath;

    private Double price;

    private String commodityDesc;

    private Date createDate;

    private Date updateDate;
}

