package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.BookDao;
import com.bear.bookhouse.dao.UserDao;
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

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 获取图书总记录数
        int booksRecordTotalCount = bookDao.getBooksTotalCount();
        // 根据总记录数和每页显示的数量求解总页数
        int pageTotal = booksRecordTotalCount / pageSize;
        if (booksRecordTotalCount % pageSize != 0) {
            pageTotal++;
        }
        // 设置当前页总记录数和总页数
        page.setRecordTotal(booksRecordTotalCount);
        page.setPageTotal(pageTotal);

        // 当前页码数据边界性检查
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal && pageTotal != 0) {
            pageNum = pageTotal;
        }
        page.setPageNum(pageNum);

        // 获取当前页的图书数据
        page.setPageData(bookDao.listBooksByBeginAndOffset((pageNum - 1) * pageSize, pageSize));
        return page;
    }

    @Override
    public Page<Book> getBooksByTitlePageData(int pageNum, int pageSize, String title) {
        Page<Book> bookPage = new Page<>();

        bookPage.setPageSize(pageSize);
        // 获取符合书名的图书总记录数
        int countsByTitle = bookDao.getBooksTotalCountThoughTitle(title);
        // 根据每页显示的数量和总记录数计算总页数
        int pageTotal = countsByTitle / pageSize;
        if (countsByTitle % pageSize != 0) {
            pageTotal++;
        }
        // 设置当前页总记录数和总页数
        bookPage.setRecordTotal(countsByTitle);
        bookPage.setPageTotal(pageTotal);
        // 当前页码数据边界性检查
        if (pageNum <= 0) {
            pageNum = 1;
        } else if (pageNum > pageTotal && pageTotal != 0) {
            pageNum = pageTotal;
        }
        bookPage.setPageNum(pageNum);

        bookPage.setPageData(bookDao.listBooksThoughTitleByBeginAndOffset((pageNum - 1) * pageSize, pageSize, title));
        return bookPage;
    }

    @Override
    public int getBooksRecordTotalCount() {
        return bookDao.getBooksTotalCount();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public boolean increaseBookDownloads(int bookId) {
        return bookDao.updateBookDownloads(1, bookId) == 1;
    }

    @Override
    public boolean increaseBookCollections(int bookId) {
        return bookDao.updateBookFavorites(1, bookId) == 1;
    }
}