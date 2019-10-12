package game.context;

import game.controllers.AppleTheftController;
import game.core.lobby.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameContext {
    @Bean
    public Game appleTheft(){
        String desc = "APPLE_THEFT";
        return new Game(desc, Game.Games.APPLE_THEFT);
    }
    @Bean
    public Game chooseFate(){
        String desc = "CHOOSE_FATE";
        return new Game(desc, Game.Games.CHOOSE_FATE);
    }
    @Bean
    public Game drawRuns(){
        String desc = "DRAW_RUNS";
        return new Game(desc, Game.Games.DRAW_RUNS);
    }
    @Bean
    public Game drinkers(){
        String desc = "DRINKERS";
        return new Game(desc, Game.Games.DRINKERS);
    }
}
