package com.wisely.lite_boot.common.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @Author: Chris
 * @Date: 2020/3/21 7:35
 * @Description: 日期时间工具类
 */
public class DateTimeUtil {
    public static Long getTimeStamp() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
    }
}
