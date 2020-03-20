package com.wisely.lite_boot.common.exception;

import com.wisely.lite_boot.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @Author: Chris
 * @Date: 2020/3/21 7:49
 * @Description: 自定义异常
 */
@Data
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}