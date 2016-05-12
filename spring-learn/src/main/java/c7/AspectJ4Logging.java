package c7;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Think on 2016/4/23.
 */
@Aspect
public class AspectJ4Logging {

    @Pointcut("execution(* *.*(..)) && @annotation(c0.LoggingRequired)")
    public void logging() {}

    /**
     * spring  LoggingRequired aop
     */
//    @Before("logging() && @annotation(logging)")
//    @Before("logging() && @annotation(c0.LoggingRequired)")
    @Before("logging()")
    public void beforeTest() {
        System.out.println("before test do logging");
    }
}
