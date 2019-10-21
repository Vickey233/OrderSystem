package com.groupthree.ordersystem.utils;

import com.groupthree.ordersystem.base.BaseResult;

public class ResultUtil {


    public static Object success(Object data) {
        return commonResult(1, 200, "请求成功", data);
    }

    public static Object success(String msg,Object data) {
        return commonResult(1, 200, msg, data);
    }

    public static Object successTip(String msg) {
        return commonResultTip(1, 200, msg);
    }

    public static Object error(String errorMsg) {
        return error(200, errorMsg);
    }

    public static Object error(Integer code, String errorMsg) {
        return commonResult(0, code, errorMsg, null);
    }

    private static Object commonResult(Integer status, Integer code, String errMsg, Object data) {
        BaseResult result = new BaseResult();
        result.setStatus(status);
        result.setCode(code);
        result.setMsg(errMsg);
        result.setData(data);
        return result;
    }

    private static Object commonResultTip(Integer status, Integer code, String errMsg) {
        BaseResult result = new BaseResult();
        result.setStatus(status);
        result.setCode(code);
        result.setMsg(errMsg);
        return result;
    }
}
