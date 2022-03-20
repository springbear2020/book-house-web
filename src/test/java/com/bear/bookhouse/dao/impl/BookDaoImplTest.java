package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BookDao;
import com.bear.bookhouse.pojo.Book;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 21:59
 */
public class BookDaoImplTest {
    private final BookDao bookDao = new BookDaoImpl();

    @Test
    public void saveBook() {
        System.out.println(bookDao.saveBook(new Book(null, "浪潮之巅", "吴军", "计算机", "", "", "Spring-_-Bear", new Date())));
    }
}