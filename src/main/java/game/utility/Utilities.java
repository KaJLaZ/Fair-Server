package game.utility;

import game.core.chooseFate.History;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Utilities {
    public static List getAllBeanConcClass(Class beanClass){
        ApplicationContext context = new AnnotationConfigApplicationContext("game.context");
        String[] beanNames = context.getBeanNamesForType(beanClass);
        List allBeans = new ArrayList();

        for (int i = 0; i < beanNames.length; i++)
            allBeans.add(context.getBean(beanNames[i]));

        return allBeans;
    }
    public static <T> T getRandomObjectOfList(List<T> list){
        Random random = new Random();
        int boxNumber = random.nextInt(list.size());

        return list.get(boxNumber);
    }
}
