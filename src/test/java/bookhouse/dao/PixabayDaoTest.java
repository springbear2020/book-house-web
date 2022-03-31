package bookhouse.dao;

import com.bear.bookhouse.dao.PixabayDao;
import com.bear.bookhouse.dao.impl.PixabayDaoImpl;
import com.bear.bookhouse.pojo.Pixabay;
import org.junit.Test;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:42
 */
public class PixabayDaoTest {
    private final PixabayDao pixabayDao = new PixabayDaoImpl();

    @Test
    public void getPixabayById() {
        Pixabay pixabayById = pixabayDao.getPixabayById(250);
        System.out.println(pixabayById);
    }

    @Test
    public void getPixabayCounts() {
        System.out.println(pixabayDao.getPixabayCounts());
    }

    @Test
    public void deletePixabayById() {
        System.out.println(pixabayDao.deletePixabayById(501));
    }

    @Test
    public void getFirstPixabay() {
        Pixabay firstPixabay = pixabayDao.getFirstPixabay();
        System.out.println(firstPixabay);
    }
}