package bookhouse.dao;

import com.bear.bookhouse.dao.DownloadDao;
import com.bear.bookhouse.dao.impl.DownloadDaoImpl;
import com.bear.bookhouse.pojo.Download;
import org.junit.Test;

import java.util.Date;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:41
 */
public class DownloadDaoTest {
    private final DownloadDao downloadDao = new DownloadDaoImpl();

    @Test
    public void saveDownload() {
        System.out.println(downloadDao.saveDownload(new Download(null, 2, "下载图书", "-10", new Date(), "浪潮之巅")));
    }

    @Test
    public void listDownloadByUserId() {
        System.out.println(downloadDao.listDownloadThoughUserIdByBeginAndOffset(2, 1, 1));
    }
}