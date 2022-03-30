package bookhouse.service;

import com.bear.bookhouse.pojo.Favorite;
import com.bear.bookhouse.service.RecordService;
import com.bear.bookhouse.service.impl.RecordServiceImpl;
import org.junit.Test;

import java.util.Date;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:32
 */
public class FavoriteServiceTest {
    private final RecordService recordService = new RecordServiceImpl();

    @Test
    public void addFavorite() {
        boolean b = recordService.addFavorite(new Favorite(null, 2, 2, "浪潮之巅", "吴军", null, new Date()));
        System.out.println(b);
    }
}