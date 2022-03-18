package com.bear.bookhouse.service;

import com.bear.bookhouse.service.impl.PictureServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/18 19:40
 */
public class PictureServiceTest {
    private final PictureService pictureService = new PictureServiceImpl();

    @Test
    public void getPicturesUrlById() {
        Integer[] integers = new Integer[]{1, 5, 2, 4};
        List<String> resList = pictureService.getPicturesUrlById(integers);
        System.out.println(resList);
    }
}