package com.bear.bookhouse.dao;

import com.bear.bookhouse.dao.impl.BookDaoImpl;
import com.bear.bookhouse.pojo.Book;
import org.junit.Test;

import java.util.Date;
import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 21:59
 */
public class BookDaoTest {
    private final BookDao bookDao = new BookDaoImpl();

    @Test
    public void saveBook() {
        Book book = new Book(null, "Java开发手册(嵩山版)", "阿里巴巴", "Bear", "Java 编程语言", 0, 0, "Java 届永远滴神", "WEB-INF/book/Java开发手册(嵩山版).pdf", "static/img/cover/Java开发手册(嵩山版).png", "Bear", new Date());
        int i = bookDao.saveBook(book);
        System.out.println(i);
    }

    @Test
    public void listBooksByBeginAndOffset() {
        int pageNum = 2;
        int offset = 2;
        int begin = (pageNum - 1) * offset;
        List<Book> books = bookDao.listBooksByBeginAndOffset(begin, offset);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void getBooksRecordTotalCount() {
        int booksRecordTotalCount = bookDao.getBooksTotalCount();
        System.out.println(booksRecordTotalCount);
    }

    @Test
    public void getBookById() {
        Book bookById = bookDao.getBookById(1);
        System.out.println(bookById);
    }

    @Test
    public void getBooksByTitle() {
        List<Book> books = bookDao.listBooksThoughTitleByBeginAndOffset(1, 5, "Java");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void getCountsByTitle() {
        int java = bookDao.getBooksTotalCountThoughTitle("Java");
        System.out.println(java);
    }

    @Test
    public void bookDownloadsIncrease() {
        System.out.println(bookDao.updateBookDownloads(10000, 2));
    }

    @Test
    public void bookFavoritesIncrease() {
        System.out.println(bookDao.updateBookFavorites(10000, 2));

    }
}