package com.bear.bookhouse.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 15:27
 */
public class DataUtil {
    /**
     * 每页显示的图书数量
     */
    private static Integer pageSize;
    /**
     * 用户注册默认积分
     */
    private static Integer registerScore;
    /**
     * 上传、下载图书积分变化量
     */
    private static Integer scoreChange;
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
            pageSize = NumberUtil.objectToInteger(properties.getProperty("pageSize"), 25);
            registerScore = NumberUtil.objectToInteger(properties.getProperty("registerScore"), 100);
            scoreChange = NumberUtil.objectToInteger(properties.getProperty("scoreChange"), 10);
            uploadSavePath = properties.getProperty("uploadSavePath");
            recordPageSize = NumberUtil.objectToInteger(properties.getProperty("recordPageSize"), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer getPageSize() {
        return pageSize;
    }

    public static Integer getRegisterScore() {
        return registerScore;
    }

    public static Integer getScoreChange() {
        return scoreChange;
    }

    public static String getUploadSavePath() {
        return uploadSavePath;
    }

    public static Integer getRecordPageSize() {
        return recordPageSize;
    }
}
