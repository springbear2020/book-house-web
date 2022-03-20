package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Book;

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
}
