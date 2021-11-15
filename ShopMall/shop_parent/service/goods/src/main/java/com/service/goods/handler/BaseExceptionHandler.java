package com.service.goods.handler;

import ch.qos.logback.core.status.Status;
import com.common.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 统一异常处理
 */

@ControllerAdvice   //增强类
public class BaseExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, Status.ERROR, "server busy");
    }
}
