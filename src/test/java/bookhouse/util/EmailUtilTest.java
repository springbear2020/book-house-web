package bookhouse.util;


import com.bear.bookhouse.util.EmailUtil;
import org.junit.Test;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/15 17:25
 */
public class EmailUtilTest {
    @Test
    public void sendEmail() {
        try {
            EmailUtil instance = EmailUtil.getInstance();
            instance.sendEmail("springbear2020@163.com");
            String verifyCode = instance.getVerifyCode();
            System.out.println(verifyCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}