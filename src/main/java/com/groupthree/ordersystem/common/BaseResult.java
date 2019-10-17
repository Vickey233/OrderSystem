package com.groupthree.ordersystem.common;

import lombok.Data;

@Data
public class BaseResult<T> {

    private Integer code;

    private Integer status;

    private String msg;

    private T data;


}
