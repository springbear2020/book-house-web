package bookhouse.dao;

import com.bear.bookhouse.dao.UserInfoDao;
import com.bear.bookhouse.dao.impl.UserInfoImpl;
import org.junit.Test;


/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 22:14
 */
public class UserInfoDaoTest {
    private final UserInfoDao userInfoDao = new UserInfoImpl();

    @Test
    public void getUserInfoByUserId() {
        System.out.println(userInfoDao.getUserInfoByUserId(2));
    }
}