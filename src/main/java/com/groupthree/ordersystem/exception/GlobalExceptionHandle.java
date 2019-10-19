package com.groupthree.ordersystem.exception;

import com.groupthree.ordersystem.base.BaseException;
import com.groupthree.ordersystem.base.BaseResult;
import com.groupthree.ordersystem.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handle(Exception e) {
        if (e instanceof BaseException) {
            Integer code = 100;
            BaseException exception = (BaseException) e;
            if (exception.getCode() != 0) {
                code = exception.getCode();
            }
            return ResultUtil.error(code, e.getMessage());
        }
        return ResultUtil.error(500, e.getMessage() == null ? "服务器内部错误" : e.getMessage());
    }
}
