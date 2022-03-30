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
     * 通过图书 id 获取对应图书信息
     *
     * @param id 图书 id
     * @return 图书
     */
    Book getBookById(int id);

    /**
     * 图书数据分页显示
     *
     * @param pageNum  当前页码
     * @param pageSize 每页显示的数量
     * @return 图书分页对象
     */
    Page<Book> getBookPageData(int pageNum, int pageSize);

    /**
     * 根据书名查询图书分页数据
     *
     * @param pageNum  页码
     * @param pageSize 每页显示的数量
     * @param title    书名
     * @return 图书分页对象
     */
    Page<Book> getBookPageDataByTitle(int pageNum, int pageSize, String title);

    /**
     * 增加图书下载量
     *
     * @param addDownload 增加的下载量
     * @param bookId      图书 id
     * @return true - 增加成功
     */
    boolean addBookDownloads(int addDownload, int bookId);

    /**
     * 增加图书收藏量
     *
     * @param addCollection 增加的图书收藏量
     * @param bookId        图书 id
     * @return true - 增加成功
     */
    boolean addBookFavorites(int addCollection, int bookId);

    /**
     * 随机获取一本图书
     *
     * @return Book or null
     */
    Book getOneBookRandomly();
}
