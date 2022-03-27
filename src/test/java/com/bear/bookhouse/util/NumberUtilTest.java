package com.bear.bookhouse.util;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 9:02
 */
public class NumberUtilTest {

    @Test
    public void objectToInteger() {
        int i = NumberUtil.objectToInteger("1d2", 0);
        System.out.println(i);
    }

    @Test
    public void randomGenerateCode() {
        String s = NumberUtil.randomGenerateCodeInLength(6);
        System.out.println(s);
    }
}