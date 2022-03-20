package com.bear.bookhouse.util;

import java.util.Random;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/18 19:35
 */
public class NumberUtil {

    /**
     * 将 Object 类型转换为 Integer
     *
     * @param obj          Object
     * @param defaultValue 转换失败时返回的默认值
     * @return Integer
     */
    public static int objectToInteger(Object obj, int defaultValue) {
        try {
            return Integer.parseInt(String.valueOf(obj));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 在指定范围内生成指定个数的随机正整数
     *
     * @param bound  最大值
     * @param counts 随机数个数
     * @return 随机数数组 或 null
     */
    public static Integer[] generateIntegers(int bound, int counts) {
        if (bound <= 0 || counts <= 0) {
            return null;
        }
        Integer[] res = new Integer[counts];
        Random random = new Random();
        for (int i = 0; i < counts; i++) {
            res[i] = random.nextInt(bound);
        }
        return res;
    }

    /**
     * 随机生成验证码
     *
     * @return 指定位数验证码字符串
     */
    public static String randomGenerateCode(int len) {
        StringBuilder builder = new StringBuilder();
        for (int j = 1; j <= len; j++) {
            int randomNum = new Random().nextInt(10);
            builder.append("0123456789".charAt(randomNum));
        }
        return builder.toString();
    }
}
