package game.core.dataBase;

import lombok.NonNull;

public class SentBoxCounterState implements GameState<Integer> {
    private Integer boxCounter;

    public SentBoxCounterState(@NonNull Integer boxCounter) {
        this.boxCounter = boxCounter;
    }

    @Override
    public Integer get() {
        return boxCounter;
    }
}
