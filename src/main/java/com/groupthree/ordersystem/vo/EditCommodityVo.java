package com.groupthree.ordersystem.vo;

import lombok.Data;

@Data
public class EditCommodityVo {
    private Integer commodityId;

    private String commodityName;

    private String imagePath;

    private Double price;

    private String commodityDesc;
}
