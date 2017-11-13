package com.github.houbb.paradise.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 日期格式化
     */
    public static final String DATE_FORMAT = "yyyyMMdd";


    /**
     * 时间戳格式化
     * 17位长度
     */
    public static final String TIMESTAMP_FORMAT_17 = "yyyyMMddHHmmssSSS";

    /**
     * 获取日期当前字符串形式
     * @return
     */
    public static String getCurrentDateStr() {
        Date now = new Date();
        return new SimpleDateFormat(DATE_FORMAT).format(now);
    }

    /**
     * 获取当前时间戳。
     * @return
     */
    public static String getCurrentTimeStampStr() {
        Date now = new Date();
        return new SimpleDateFormat(TIMESTAMP_FORMAT_17).format(now);
    }

}
