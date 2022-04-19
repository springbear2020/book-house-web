package com.bear.bookhouse.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/21 17:32
 */
public class DateUtil {
    /**
     * 时间格式化为文件名
     *
     * @param date java.util.Date
     * @return 格式化时间
     */
    public static String dateFormatFilename(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(date);
    }

    /**
     * 时间格式化为 2022-03-03 03:03:03 格式
     *
     * @param date 日期
     * @return 格式化的时间
     */
    public static String dateFormatDatetime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * 将 String 类型转换为 Date
     *
     * @param date 时间字符串
     * @return Date
     */
    public static Date stringFormatDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
