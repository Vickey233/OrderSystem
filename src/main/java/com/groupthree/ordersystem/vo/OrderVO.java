package com.groupthree.ordersystem.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;

import java.util.Date;

@Data
public class OrderVO {

    private  Integer orderId;

    private Integer realName;

    private Integer commodityName;

    private Integer statue;

    private Double sum;

    private Date createDate;

    private Date updateDate;
}
