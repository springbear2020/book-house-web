package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;


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
     * @param pageNum  页码
     * @param pageSize 每页显示的数量
     * @return 图书分页对象
     */
    Page<Book> getBookPageData(int pageNum, int pageSize);

    /**
     * 获取图书记录总数量
     *
     * @return 图书记录总数量
     */
    int getBooksRecordTotalCount();
}
