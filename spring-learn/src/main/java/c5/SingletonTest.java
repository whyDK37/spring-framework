package c5;

import c0.A;
import c0.B;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by whydk on 2016/3/10.
 */
public class SingletonTest {

    public static void main(String[] args) {
        //
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(new ClassPathResource("c5/singleton.xml"));

        A a = bf.getBean("a", A.class);
        System.out.println(a);
        System.out.println(a.getB());
        B b = bf.getBean("b", B.class);
        System.out.println("--------");
        System.out.println(b);
        System.out.println(b.getA());

    }

}
