package com.groupthree.ordersystem.base;

import lombok.Data;

@Data
public class BaseResult<T> {

    private Integer code;

    private Integer status;

    private String msg;

    private T data;


}
