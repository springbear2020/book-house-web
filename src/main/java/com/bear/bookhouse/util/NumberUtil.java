package com.bear.bookhouse.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
     * 随机生成指定位数的数字验证码
     *
     * @return 指定位数数字验证码字符串
     */
    public static String generateCodeInLengthRandomly(int len) {
        StringBuilder builder = new StringBuilder();
        for (int j = 1; j <= len; j++) {
            int randomNum = new Random().nextInt(10);
            builder.append("0123456789".charAt(randomNum));
        }
        return builder.toString();
    }

    /**
     * 随机生成一个指定上限的随机数
     *
     * @param bound 上限
     * @return 随机值
     */
    public static int generateOneNumberInBoundRandomly(int bound) {
        Random random = new Random();
        int number = random.nextInt(bound);
        return number == 0 ? number + 1 : number;
    }

    /**
     * 在指定范围内生成指定个数的不重复的随机正整数
     *
     * @param size  随机数个数
     * @param bound 界限
     * @return integers or null
     */
    public static Integer[] generateNumbersInBoundAndSizeRandomly(int size, int bound) {
        Set<Integer> integersSet = new HashSet<>();
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            int number = random.nextInt(bound);
            // 如果加入失败（数字已存在）则再次生成
            if (number == 0 || !integersSet.add(number)) {
                --i;
            }
        }
        return integersSet.toArray(new Integer[]{});
    }
}
