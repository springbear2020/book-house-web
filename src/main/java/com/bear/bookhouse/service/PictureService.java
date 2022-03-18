package com.bear.bookhouse.service;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/18 19:41
 */
public interface PictureService {
    /**
     * 通过指定的图片 id 数组获取多张图片的 url 信息
     *
     * @param id 图片 id 数组
     * @return 图片 url
     */
    List<String> getPicturesUrlById(Integer[] id);
}
