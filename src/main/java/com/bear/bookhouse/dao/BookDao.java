package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Book;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 21:39
 */
public interface BookDao {
    /**
     * 保存图书
     *
     * @param book Book
     * @return 1 - 保存成功
     */
    int saveBook(Book book);
}
