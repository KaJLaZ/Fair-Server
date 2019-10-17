package game.core.dataBase;

import lombok.NonNull;

public class GameCounterState implements GameState<Integer> {
    private Integer gameCounter;

    public GameCounterState(@NonNull Integer gameCounter) {
        this.gameCounter = gameCounter;
    }

    @Override
    public Integer get() {
        return gameCounter;
    }
}
