package bookhouse.util;

import com.bear.bookhouse.util.NumberUtil;
import org.junit.Test;



/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 9:02
 */
public class NumberUtilTest {

    @Test
    public void objectToInteger() {
        int i = NumberUtil.objectToInteger("1d2", 0);
        System.out.println(i);
    }

    @Test
    public void randomGenerateCode() {
        String s = NumberUtil.generateCodeInLengthRandomly(6);
        System.out.println(s);
    }
}