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
        Book book = new Book(null, "Java编程思想(第4版)", "Burce Eckel", "Java 编程语言", 0, 0, "Java编程思想(第4版).pdf", "http://localhost:8080/bookhouse/static/img/cover/Java编程思想(第4版).jpeg", "Bear", new Date());
        System.out.println(book);
        for (int i = 1; i <= 100; i++) {
            System.out.println(bookDao.saveBook(book));
        }
    }

    @Test
    public void listBooksByBeginAndOffset() {
        int pageNum = 1;
        int offset = 5;
        int begin = pageNum * offset;
        List<Book> books = bookDao.listBooksByBeginAndOffset(begin, offset);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void getBooksRecordTotalCount() {
        int booksRecordTotalCount = bookDao.getBooksRecordTotalCount();
        System.out.println(booksRecordTotalCount);
    }
}