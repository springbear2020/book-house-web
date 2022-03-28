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
     * 通过 id 查询图书信息
     *
     * @param id 图书 id
     * @return Book or null
     */
    Book getBookById(int id);

    /**
     * 通过指定 begin 和 offset 获取指定页的图书数据
     *
     * @param begin  起始位置
     * @param offset 偏移量
     * @return Books or null
     */
    List<Book> listBooksByBeginAndOffset(int begin, int offset);

    /**
     * 获得图书总记录数
     *
     * @return 图书总记录数
     */
    int getBookCounts();

    /**
     * 获取符合书名条件的图书记录数
     *
     * @param title 书名
     * @return 记录数
     */
    int getBookCountsByTitle(String title);

    /**
     * 在指定书名作为过滤条件的基础上,
     * 指定起始位置和偏移量查询图书分页数据
     *
     * @param begin  开始位置
     * @param offset 偏移量
     * @param title  书名
     * @return Books or null
     */
    List<Book> listBooksThoughTitleByBeginAndOffset(int begin, int offset, String title);

    /**
     * 通过图书 id 增加图书下载量
     *
     * @param addDownload 增加的下载量
     * @param bookId      图书 id
     * @return 1 - 增加成功
     */
    int updateBookDownloadsById(int addDownload, int bookId);

    /**
     * 通过图书 id 增加图书收藏量
     *
     * @param addCollection 增加的收藏量
     * @param bookId        图书 id
     * @return 1 - 增加成功
     */
    int updateBookFavoritesById(int addCollection, int bookId);
}
