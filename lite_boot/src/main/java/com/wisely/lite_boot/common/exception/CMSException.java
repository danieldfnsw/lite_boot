package com.wisely.lite_boot.common.exception;

import com.wisely.lite_boot.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @Author: Chris
 * @Date: 2020/3/21 7:01
 * @Description: 自定义全局异常类
 * 是一种作用于控制层的切面通知（Advice），该注解能够将通用的@ExceptionHandler、@InitBinder和@ModelAttributes方法收集到一个类型，并应用到所有控制器上
 * 使用@ExceptionHandler注解捕获指定或自定义的异常；
 * 使用@ControllerAdvice集成@ExceptionHandler的方法到一个类中；
 * 必须定义一个通用的异常捕获方法，便于捕获未定义的异常信息；
 * 自定一个异常类，捕获针对项目或业务的异常;
 * 异常的对象信息补充到统一结果枚举中；
 */
@Data
public class CMSException extends RuntimeException {
    private Integer code;

    public CMSException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CMSException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}

