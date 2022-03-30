package bookhouse.dao;

import com.bear.bookhouse.dao.UserInfoDao;
import com.bear.bookhouse.dao.impl.UserInfoImpl;
import com.bear.bookhouse.pojo.UserInfo;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

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