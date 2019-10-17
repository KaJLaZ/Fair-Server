package game.core.dataBase;

import game.core.drawRuns.Box;
import lombok.NonNull;

public class SentBoxState implements GameState<Box> {
    private Box box;

    public SentBoxState(@NonNull Box box) {
        this.box = box;
    }

    @Override
    public Box get() {
        return box;
    }
}
