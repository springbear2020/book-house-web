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
        String sql = "INSERT INTO `t_book`(`title`,`author`,`keywords`,`downloads`,`collections`,`book_path`,`book_cover_path`,`upload_username`,`upload_time`) VALUES(?,?,?,?,?,?,?,?,?);";
        Object[] params = new Object[]{book.getTitle(), book.getAuthor(), book.getKeywords(), book.getDownloads(), book.getCollections(), book.getBookPath(), book.getBookCoverPath(), book.getUploadUsername(), book.getUploadTime()};
        return update(sql, params);
    }

    @Override
    public List<Book> listBooksByBeginAndOffset(int begin, int offset) {
        String sql = "SELECT `id`,`title`,`author`,`keywords`,`downloads`,`collections`,`book_path` bookPath,`book_cover_path` bookCoverPath,`upload_username` uploadUsername,`upload_time` uploadTime FROM `t_book` LIMIT ?,?;";
        return listRecord(Book.class, sql, begin, offset);
    }

    @Override
    public int getBooksRecordTotalCount() {
        String sql = "SELECT COUNT(id) FROM `t_book`;";
        return NumberUtil.objectToInteger(getSingleValue(sql), 0);
    }
}
