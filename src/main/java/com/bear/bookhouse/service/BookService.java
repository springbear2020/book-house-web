package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;

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
     * 图书数据分页显示
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

    /**
     * 通过图书 id 获取对应图书信息
     *
     * @param id 图书 id
     * @return 图书
     */
    Book getBookById(int id);

    /**
     * 根据书名查询图书分页数据
     *
     * @param pageNum  页码
     * @param pageSize 每页显示的数量
     * @param title    书名
     * @return 图书分页对象
     */
    Page<Book> getBooksByTitlePageData(int pageNum, int pageSize, String title);

    /**
     * 增加图书下载量，默认增加 1
     *
     * @param bookId 图书 id
     * @return true - 增加成功
     */
    boolean increaseBookDownloads(int bookId);

    /**
     * 增加图书收藏量，默认增加 1
     *
     * @param bookId 图书 id
     * @return true - 增加成功
     */
    boolean increaseBookCollections(int bookId);
}
