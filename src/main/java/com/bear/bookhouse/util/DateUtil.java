package com.bear.bookhouse.util;

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
     * @return 格式化后的文件名
     */
    public static String fileNameFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(date);
    }

    /**
     * 时间格式化为指定格式
     *
     * @param date 时间
     * @return 格式化的时间
     */
    public static String timeFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        return dateFormat.format(date);
    }
}
