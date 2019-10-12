package game.core.lobby;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    String defaultDesc = "defaultDesc";
    Game.Games defaultGameEnum = Game.Games.CHOOSE_FATE;
    Game defGame;
    @BeforeEach
    public void initializeGame(){
        defGame = new Game(defaultDesc, defaultGameEnum);
    }
    @Test
    public void createGame(){
        Game game = new Game("asd", Game.Games.DRAW_RUNS);
    }
    @Test
    public void getInitializedDescription(){
        Assertions.assertEquals(defaultDesc, defGame.getDescription());
    }
    @Test
    public void getInitializedGameEnum(){
        Assertions.assertEquals(defaultGameEnum, defGame.getGame());
    }
    @Test
    public void createGameWithNull(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            Game game = new Game(null, defaultGameEnum);
        });
    }
}
