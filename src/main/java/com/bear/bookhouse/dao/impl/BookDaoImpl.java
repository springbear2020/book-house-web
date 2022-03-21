package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.BookDao;
import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.util.NumberUtil;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 21:39
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int saveBook(Book book) {
        String sql = "INSERT INTO `t_book`(`title`,`author`,`translator`,`keywords`,`downloads`,`collections`,`comment`,`book_path`,`cover_path`,`upload_username`,`upload_time`) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
        Object[] params = new Object[]{book.getTitle(), book.getAuthor(), book.getTranslator(), book.getKeywords(), book.getDownloads(), book.getCollections(), book.getComment(), book.getBookPath(), book.getCoverPath(), book.getUploadUsername(), book.getUploadTime()};
        return update(sql, params);
    }

    @Override
    public List<Book> listBooksByBeginAndOffset(int begin, int offset) {
        String sql = "SELECT `id`,`title`,`author`,`translator`,`keywords`,`downloads`,`collections`,`comment`,`book_path` bookPath,`cover_path` coverPath,`upload_username` uploadUsername,`upload_time` uploadTime FROM `t_book` LIMIT ?,?;";
        return listRecord(Book.class, sql, begin, offset);
    }

    @Override
    public int getBooksRecordTotalCount() {
        String sql = "SELECT COUNT(`id`) FROM `t_book`;";
        return NumberUtil.objectToInteger(getSingleValue(sql), 0);
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT `id`,`title`,`author`,`translator`,`keywords`,`downloads`,`collections`,`comment`,`book_path` bookPath,`cover_path` coverPath,`upload_username` uploadUsername,`upload_time` uploadTime FROM `t_book` WHERE `id` = ?;";
        return getRecord(Book.class, sql, id);
    }
}
