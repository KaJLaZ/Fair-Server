package game.utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Utilities {
    public static Object[] getAllBeanConcClass(Class beanClass){

            ApplicationContext context = new AnnotationConfigApplicationContext("game.context");
            String[] beanNames = context.getBeanNamesForType(beanClass);
            Object[] allBeans = new Object[beanNames.length];

            for (int i = 0; i < beanNames.length; i++)
                allBeans[i] = context.getBean(beanNames[i]);

            return allBeans;
    }
}
