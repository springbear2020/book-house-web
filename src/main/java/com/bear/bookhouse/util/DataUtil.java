package com.bear.bookhouse.util;

import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.LoginLog;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 15:27
 */
public class DataUtil {
    /**
     * 首页每页显示的图书数量
     */
    private static Integer pageSize;
    /**
     * 用户上传图书、封面保存路径
     */
    private static String uploadSavePath;
    /**
     * 用户记录每页显示的数量
     */
    private static Integer recordPageSize;

    // 静态代码块从配置文件读取配置信息
    static {
        Properties properties = new Properties();
        try {
            InputStream resourceAsStream = DataUtil.class.getClassLoader().getResourceAsStream("data.properties");
            properties.load(resourceAsStream);
            pageSize = NumberUtil.objectToInteger(properties.getProperty("pageSize"), Book.PAGE_SIZE);
            recordPageSize = NumberUtil.objectToInteger(properties.getProperty("recordPageSize"), LoginLog.RECORD_PAGE_SIZE);
            uploadSavePath = properties.getProperty("uploadSavePath");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer getPageSize() {
        return pageSize;
    }

    public static String getUploadSavePath() {
        return uploadSavePath;
    }

    public static Integer getRecordPageSize() {
        return recordPageSize;
    }
}
