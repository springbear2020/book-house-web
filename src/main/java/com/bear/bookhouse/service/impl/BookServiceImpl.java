package com.bear.bookhouse.service.impl;

import com.bear.bookhouse.dao.BookDao;
import com.bear.bookhouse.dao.impl.BookDaoImpl;
import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;
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

    @Override
    public Page<Book> getBookPageData(int pageNum, int pageSize) {
        Page<Book> page = new Page<>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 获取图书总记录数
        int booksRecordTotalCount = bookDao.getBooksRecordTotalCount();
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
        // TODO java.sql.SQLException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '-5,5' at line 1 Query: SELECT `id`,`title`,`author`,`translator`,`keywords`,`downloads`,`collections`,`comment`,`book_path` bookPath,`cover_path` coverPath,`upload_username` uploadUsername,`upload_time` uploadTime FROM `t_book` LIMIT ?,?; Parameters: [-5, 5]
        page.setPageData(bookDao.listBooksByBeginAndOffset((pageNum - 1) * pageSize, pageSize));
        return page;
    }

    @Override
    public int getBooksRecordTotalCount() {
        return bookDao.getBooksRecordTotalCount();
    }

    @Override
    public String getBookPathById(int id) {
        return bookDao.getBookById(id).getBookPath();
    }
}