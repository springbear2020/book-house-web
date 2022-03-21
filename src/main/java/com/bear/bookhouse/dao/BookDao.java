package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Book;

import java.util.List;

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

    /**
     * 通过指定 begin 和 offset 获取指定页的图书数据
     *
     * @param begin  起始位置
     * @param offset 偏移量
     * @return Books or null
     */
    List<Book> listBooksByBeginAndOffset(int begin, int offset);
}
