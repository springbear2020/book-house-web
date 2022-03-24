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
        return update(sql, book.getTitle(), book.getAuthor(), book.getTranslator(), book.getKeywords(), book.getDownloads(), book.getCollections(), book.getComment(), book.getBookPath(), book.getCoverPath(), book.getUploadUsername(), book.getUploadTime());
    }

    @Override
    public List<Book> listBooksByBeginAndOffset(int begin, int offset) {
        String sql = "SELECT `id`,`title`,`author`,`translator`,`keywords`,`downloads`,`collections`,`comment`,`book_path` bookPath,`cover_path` coverPath,`upload_username` uploadUsername,`upload_time` uploadTime FROM `t_book` LIMIT ?,?;";
        return listRecord(Book.class, sql, begin, offset);
    }

    @Override
    public int getBooksTotalCount() {
        String sql = "SELECT COUNT(`id`) FROM `t_book`;";
        return NumberUtil.objectToInteger(getSingleValue(sql), -1);
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT `id`,`title`,`author`,`translator`,`keywords`,`downloads`,`collections`,`comment`,`book_path` bookPath,`cover_path` coverPath,`upload_username` uploadUsername,`upload_time` uploadTime FROM `t_book` WHERE `id` = ?;";
        return getRecord(Book.class, sql, id);
    }

    @Override
    public List<Book> listBooksThoughTitleByBeginAndOffset(int begin, int offset, String title) {
        String sql = "SELECT `id`,`title`,`author`,`translator`,`keywords`,`downloads`,`collections`,`comment`,`book_path` bookPath,`cover_path` coverPath,`upload_username` uploadUsername,`upload_time` uploadTime FROM `t_book` WHERE `title` LIKE ? LIMIT ?,?;";
        Object[] params = new Object[]{"%" + title + "%", begin, offset};
        return listRecord(Book.class, sql, params);
    }

    @Override
    public int getBooksTotalCountThoughTitle(String title) {
        String sql = "SELECT COUNT(`id`) FROM `t_book` WHERE `title` LIKE ?;";
        Object[] params = new Object[]{"%" + title + "%"};
        return NumberUtil.objectToInteger(getSingleValue(sql, params), -1);
    }

    @Override
    public int updateBookDownloads(int addDownload, int bookId) {
        String sql = "UPDATE `t_book` SET `downloads` = `downloads` + ? WHERE `id` = ?;";
        return update(sql, addDownload, bookId);
    }

    @Override
    public int updateBookFavorites(int addCollection, int bookId) {
        String sql = "UPDATE `t_book` SET `collections` = `collections` + ? WHERE `id` = ?;";
        return update(sql, addCollection, bookId);
    }
}
