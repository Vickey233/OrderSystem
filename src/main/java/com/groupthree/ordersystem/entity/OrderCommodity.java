package com.groupthree.ordersystem.entity;

import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotations.Version;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2019-10-22
 */
@Data
@Accessors(chain = true)
@TableName("order_commodity")
public class OrderCommodity extends Model<OrderCommodity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ordercomId", type = IdType.AUTO)
    private Integer ordercomId;

    private Integer orderId;

    private Integer commodityId;

    private Integer count;

    @TableField(value = "createDate", fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(value = "updateDate", fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;


    @Override
    protected Serializable pkVal() {
        return this.ordercomId;
    }

}
