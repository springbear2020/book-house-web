package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.BookDao;
import com.bear.bookhouse.dao.impl.BookDaoImpl;
import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.service.BookService;

import java.util.List;

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

    @Override
    public Page<Book> getBookPageData(int pageNum, int pageSize) {
        Page<Book> page = new Page<>();
        // 设置每页显示的数据
        page.setPageSize(pageSize);
        // 获取图书总记录数
        int booksRecordTotalCount = bookDao.getBooksRecordTotalCount();
        // 根据总记录数和每页显示的数量求解总页数
        int pageTotal = booksRecordTotalCount / pageSize;
        if (booksRecordTotalCount % pageSize != 0) {
            pageTotal++;
        }
        page.setRecordTotal(booksRecordTotalCount);
        page.setPageTotal(pageTotal);
        if (pageNum < 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal) {
            pageNum = pageTotal;
        }
        page.setPageNum(pageNum);

        // 获取当前页的图书数据
        List<Book> items = bookDao.listBooksByBeginAndOffset((pageNum - 1) * pageSize, pageSize);
        page.setCurPageData(items);
        return page;
    }

    @Override
    public int getBooksRecordTotalCount() {
        return bookDao.getBooksRecordTotalCount();
    }
}