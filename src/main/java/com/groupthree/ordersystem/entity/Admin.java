package com.groupthree.ordersystem.entity;

import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
 * @since 2019-10-18
 */
@Data
@Accessors(chain = true)
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "adminId", type = IdType.AUTO)
    private Integer adminId;

    private String phoneNumber;

    private String realName;

    private String passWord;

    @TableField(value = "createDate", fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(value = "updateDate", fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;


    @Override
    protected Serializable pkVal() {
        return this.adminId;
    }

}
