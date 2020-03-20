package com.wisely.lite_boot.common.exception.advice;

import com.wisely.lite_boot.common.exception.CMSException;
import com.wisely.lite_boot.common.result.Result;
import com.wisely.lite_boot.common.result.ResultCodeEnum;
import com.wisely.lite_boot.common.util.ExceptionUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Chris
 * @Date: 2020/3/21 7:06
 * @Description: 使用@ExceptionHandler注解捕获指定或自定义的异常；
 * 使用@ControllerAdvice集成@ExceptionHandler的方法到一个类中；
 * 必须定义一个通用的异常捕获方法，便于捕获未定义的异常信息；
 * 自定一个异常类，捕获针对项目或业务的异常;
 * 异常的对象信息补充到统一结果枚举中；
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * -------- 通用异常处理方法 --------
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return Result.error();    // 通用异常结果
    }

    /**
     * -------- 指定异常处理方法 --------
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result error(NullPointerException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.setResult(ResultCodeEnum.NULL_POINT);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Result error(IndexOutOfBoundsException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.setResult(ResultCodeEnum.HTTP_CLIENT_ERROR);
    }

    /**
     * -------- 自定义定异常处理方法 --------
     **/
    @ExceptionHandler(CMSException.class)
    @ResponseBody
    public Result error(CMSException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().message(e.getMessage()).code(e.getCode());
    }
}
