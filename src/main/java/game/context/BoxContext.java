package game.context;

import game.core.drawRuns.Box;
import game.core.drawRuns.Symbol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoxContext {

    @Bean
    public Box BoxWithPotato(Symbol StandardRun, Symbol FragileRun , Symbol ColdRun, Symbol DangerRun){
        return new Box("potato", new Symbol[]{StandardRun, FragileRun, ColdRun, DangerRun});
    }
    @Bean
    public Box BoxWithCristalVase(Symbol FragileRun , Symbol DangerRun){
        return new Box("cristal vase", new Symbol[]{FragileRun, DangerRun});
    }
    @Bean
    public Box BoxWithSnake(Symbol DangerRun){
        return new Box("snake", new Symbol[]{DangerRun});
    }

    @Bean
    public Box BoxWithIce( Symbol ColdRun){
        return new Box("ice", new Symbol[]{ColdRun});
    }

    @Bean
    public Box BoxWithSchnapps(Symbol StandardRun, Symbol FragileRun , Symbol ColdRun){
        return new Box("schnapps", new Symbol[]{StandardRun, FragileRun, ColdRun});
    }
    @Bean
    public Box BoxWithOil(Symbol StandardRun, Symbol ColdRun){
        return new Box("oil", new Symbol[]{StandardRun, ColdRun});
    }
    @Bean
    public Box BoxWithGlass(Symbol StandardRun, Symbol FragileRun , Symbol ColdRun, Symbol WarmRun){
        return new Box("glass", new Symbol[]{StandardRun, FragileRun, ColdRun, WarmRun});
    }
    @Bean
    public Box BoxWithCake(Symbol StandardRun, Symbol ColdRun){
        return new Box("cake", new Symbol[]{StandardRun, ColdRun});
    }
}

