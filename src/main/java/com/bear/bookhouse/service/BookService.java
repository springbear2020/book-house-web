package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Book;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 22:01
 */
public interface BookService {
    /**
     * 保存图书
     *
     * @param book Book
     * @return true  - 保存成功
     */
    boolean saveBook(Book book);

    /**
     * 根据指定页码和偏移量获取图书数据
     *
     * @param pageNum 页码
     * @param offset  偏移量
     * @return Books or null
     */
    List<Book> getPageBookItemsByPageNum(int pageNum, int offset);
}
