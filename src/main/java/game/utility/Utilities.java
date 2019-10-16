package game.utility;

import game.core.ObjectsWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Random;

public class Utilities {
    public static ObjectsWrapper getAllBeanConcClass(String nameBean){
        ApplicationContext context = new AnnotationConfigApplicationContext("game.context");

        return (ObjectsWrapper) context.getBean(nameBean);
    }
    public static Object getRandomObjectOfArray(Object[] array){
        Random random = new Random();
        int number = random.nextInt(array.length);

        return array[number];
    }
}
