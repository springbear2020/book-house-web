package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.BookDao;
import com.bear.bookhouse.pojo.Book;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 21:39
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int saveBook(Book book) {
        String sql = "INSERT INTO `t_book`(`title`,`author`,`keywords`,`book_path`,`book_cover_path`,`upload_username`,`upload_time`) VALUES(?,?,?,?,?,?,?);";
        Object[] params = new Object[]{book.getTitle(), book.getAuthor(), book.getKeywords(), book.getBookPath(), book.getBookCoverPath(), book.getUploadUsername(), book.getUploadTime()};
        return update(sql,params);
    }
}
