package game.context;

import game.core.drawRuns.Box;
import game.core.drawRuns.Symbol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoxContext {
    @Bean("boxWithPotato")
    public Box getBoxWithPotato(Symbol standartRun, Symbol fragileRun , Symbol coldRun, Symbol dangerRun){
        return new Box("potato", new Symbol[]{standartRun, fragileRun, coldRun, dangerRun});
    }
    @Bean("boxWithCristalVase")
    public Box getBoxWithCristalVase(Symbol fragileRun , Symbol dangerRun){
        return new Box("cristal vase", new Symbol[]{fragileRun, dangerRun});
    }
    @Bean("boxWithSnake")
    public Box getBoxWithSnake(Symbol dangerRun){
        return new Box("snake", new Symbol[]{dangerRun});
    }

    @Bean("boxWithIce")
    public Box getBoxWithIce( Symbol coldRun){
        return new Box("ice", new Symbol[]{coldRun});
    }

    @Bean("boxWithSchnapps")
    public Box getBoxWithSchnapps(Symbol standartRun, Symbol fragileRun , Symbol coldRun){
        return new Box("schnapps", new Symbol[]{standartRun, fragileRun, coldRun});
    }
    @Bean("boxWithOil")
    public Box getBoxWithOil(Symbol standartRun, Symbol coldRun){
        return new Box("oil", new Symbol[]{standartRun, coldRun});
    }
    @Bean("boxWithDesk")
    public Box getBoxWithGlass(Symbol standartRun, Symbol fragileRun , Symbol coldRun, Symbol warmRun){
        return new Box("glass", new Symbol[]{standartRun, fragileRun, coldRun, warmRun});
    }
    @Bean("boxWithCake")
    public Box getBoxWithCake(Symbol standartRun, Symbol coldRun){
        return new Box("cake", new Symbol[]{standartRun, coldRun});
    }
}

