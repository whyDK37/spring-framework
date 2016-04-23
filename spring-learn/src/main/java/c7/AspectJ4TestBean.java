package c7;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Think on 2016/4/23.
 */
@Aspect
public class AspectJ4TestBean {
    @Pointcut("execution(* *.test(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.printf("before test");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("after test");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint point) {
        System.out.println("before around");
        Object o = null;
        try {
            o = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after around");
        return o;
    }
}
