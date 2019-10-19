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
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userId",type = IdType.AUTO)
    private Integer userId;

    private String phoneNumber;

    private String passWord;

    private String realName;

    private Integer addressId;

    private Double money;

    @TableField(value = "createDate", fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(value = "updateDate", fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
