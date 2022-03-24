package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/21 11:23
 */
public class BookServiceTest {
    private final BookService bookService = new BookServiceImpl();

    @Test
    public void getBookPageData() {
        Page<Book> bookPageData = bookService.getBookPageData(1, 5);
        int booksRecordTotalCount = bookService.getBooksTotalCount();
        System.out.println(booksRecordTotalCount);
        System.out.println(bookPageData);
    }

    @Test
    public void getBooksByTitlePageData() {
        Page<Book> pages = bookService.getBookPageDataThoughTitle(0, 5, "Java");
        List<Book> pageData = pages.getPageData();
        for (Book book : pageData) {
            System.out.println(book);
        }
        System.out.println(pages);
    }
}