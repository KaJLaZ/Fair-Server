package game.core.lobby;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameRootTest {
    String defaultDesc = "defaultDesc";
    GameRoot.Games defaultGameEnum = GameRoot.Games.CHOOSE_FATE;
    GameRoot defGameRoot;
    @BeforeEach
    public void initializeGame(){
        defGameRoot = new GameRoot(defaultDesc, defaultGameEnum);
    }
    @Test
    public void createGame(){
        GameRoot gameRoot = new GameRoot("asd", GameRoot.Games.DRAW_RUNS);
    }
    @Test
    public void getInitializedDescription(){
        Assertions.assertEquals(defaultDesc, defGameRoot.getDescription());
    }
    @Test
    public void getInitializedGameEnum(){
        Assertions.assertEquals(defaultGameEnum, defGameRoot.getGame());
    }
    @Test
    public void createGameWithNull(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            GameRoot gameRoot = new GameRoot(null, defaultGameEnum);
        });
    }
}
