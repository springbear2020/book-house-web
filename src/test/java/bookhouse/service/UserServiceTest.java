package bookhouse.service;

import com.bear.bookhouse.service.UserService;
import com.bear.bookhouse.service.impl.UserServiceImpl;
import org.junit.Test;



/**
 * @author Spring-_-Bear
 * @datetime 2022/3/24 11:07
 */
public class UserServiceTest {
    private final UserService userService = new UserServiceImpl();

    @Test
    public void getUserScore() {
        int userScore = userService.getUserScore(2);
        System.out.println(userScore);
    }

    @Test
    public void subUserScore() {
        boolean b = userService.subUserScore(10,2);
        System.out.println(b);
    }

    @Test
    public void updatePortrait() {
        System.out.println(userService.updateUserPortrait("static/picture/portrait/2.png", 1));
    }
}