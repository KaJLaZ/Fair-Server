package game.core.dataBase;

import lombok.NonNull;

public class IsStolenApplesState implements GameState<Boolean> {
    private Boolean isStolenApples;

    public IsStolenApplesState(@NonNull Boolean isStolenApples) {
        this.isStolenApples = isStolenApples;
    }

    @Override
    public Boolean get() {
        return isStolenApples;
    }
}
