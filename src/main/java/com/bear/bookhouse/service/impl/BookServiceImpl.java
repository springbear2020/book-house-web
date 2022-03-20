package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.BookDao;
import com.bear.bookhouse.dao.impl.BookDaoImpl;
import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.service.BookService;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 22:02
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public boolean saveBook(Book book) {
        return bookDao.saveBook(book) == 1;
    }
}
