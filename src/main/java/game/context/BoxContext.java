package game.context;

import game.core.ObjectsWrapper;
import game.core.drawRuns.Box;
import game.core.drawRuns.Symbol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoxContext {

    @Bean
    public Box BoxWithPotato(Symbol StandardRun, Symbol FragileRun, Symbol ColdRun, Symbol DangerRun) {
        return new Box("Картопля", new ObjectsWrapper<>(StandardRun, FragileRun, ColdRun, DangerRun));
    }

    @Bean
    public Box BoxWithCristalVase(Symbol FragileRun, Symbol DangerRun) {
        return new Box("Кришталева ваза", new ObjectsWrapper<>(FragileRun, DangerRun));
    }

    @Bean
    public Box BoxWithSnake(Symbol DangerRun) {
        return new Box("Змія", new ObjectsWrapper<>(DangerRun));
    }

    @Bean
    public Box BoxWithIce(Symbol ColdRun) {
        return new Box("Лід", new ObjectsWrapper<>(ColdRun));
    }

    @Bean
    public Box BoxWithSchnapps(Symbol StandardRun, Symbol FragileRun, Symbol ColdRun) {
        return new Box("Шнапс", new ObjectsWrapper<>(StandardRun, FragileRun, ColdRun));
    }

    @Bean
    public Box BoxWithOil(Symbol StandardRun, Symbol ColdRun) {
        return new Box("Олія", new ObjectsWrapper<>(StandardRun, ColdRun));
    }

    @Bean
    public Box BoxWithGlass(Symbol StandardRun, Symbol FragileRun, Symbol ColdRun, Symbol WarmRun) {
        return new Box("Скло", new ObjectsWrapper<>(StandardRun, FragileRun, ColdRun, WarmRun));
    }

    @Bean
    public Box BoxWithCake(Symbol StandardRun, Symbol ColdRun) {
        return new Box("Торт", new ObjectsWrapper<>(StandardRun, ColdRun));
    }

    @Bean
    public ObjectsWrapper<Box> boxes(Box[] boxes) {
        return new ObjectsWrapper<>(boxes);
    }
}

