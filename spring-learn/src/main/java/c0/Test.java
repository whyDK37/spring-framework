package c0;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by drug on 2016/4/15.
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("234234");
        System.out.println(bigDecimal.toString());

        BigInteger bigInteger = new BigInteger("234");
        bigInteger = new BigInteger("123456789987654321123456789987654321123456789987654321");
        System.out.println(bigInteger);
    }
}
