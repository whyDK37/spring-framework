package c7;

import c0.LoggingRequired;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * Created by Think on 2016/4/23.
 */
@Aspect
public class AspectJ4Logging {

    @Pointcut("execution(* *.*(..)) && @annotation(c0.LoggingRequired)")
    public void logging() {}

    /**
     * spring ��������е��࣬��������� LoggingRequired �ͻᱻaop���ء�
     * ����һ�ֻ����Զ���ע������ط�ʽ
     */
//    @Before("logging() && @annotation(logging)")
//    @Before("logging() && @annotation(c0.LoggingRequired)")
    @Before("logging()")
    public void beforeTest() {
        System.out.println("before test do logging");
    }
}
