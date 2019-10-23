package com.groupthree.ordersystem.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.Version;

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
 * @since 2019-10-18
 */
@Data
@Accessors(chain = true)
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "addressId", type = IdType.AUTO)
    private Integer addressId;

    private Integer userId;

    private String address;

    private String contact;

    private String phoneNumber;

    @Override
    protected Serializable pkVal() {
        return this.addressId;
    }

}
