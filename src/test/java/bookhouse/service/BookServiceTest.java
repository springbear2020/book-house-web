package bookhouse.service;

import com.bear.bookhouse.pojo.Book;
import com.bear.bookhouse.pojo.Page;
import com.bear.bookhouse.service.BookService;
import com.bear.bookhouse.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/21 11:23
 */
public class BookServiceTest {
    private final BookService bookService = new BookServiceImpl();

    @Test
    public void saveBook() {
        System.out.println(bookService.saveBook(new Book()));
    }

    @Test
    public void getBooksByTitlePageData() {
        Page<Book> pages = bookService.getBookPageDataByTitle(0, 5, "Java");
        List<Book> pageData = pages.getPageData();
        for (Book book : pageData) {
            System.out.println(book);
        }
        System.out.println(pages);
    }

    @Test
    public void addBookDownloads() {
        boolean b = bookService.addBookDownloads(1,2);
        System.out.println(b);
    }
}