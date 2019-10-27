package com.groupthree.ordersystem.vo;

import lombok.Data;

@Data
public class ShowCommodityVo {

    private String commodityName;

    private String commodityDesc;

    private String imagePath;

    private Double price;
}
