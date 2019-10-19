package com.groupthree.ordersystem.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@Data
@Accessors(chain = true)
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "orderId",type = IdType.AUTO)
    private Integer orderId;

    private Integer userId;

    private Integer commodityId;

    private Integer statue;

    private Double sum;

    @TableField(value = "createDate", fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(value = "updateDate", fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}