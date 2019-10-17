package game.core.dataBase;

import lombok.NonNull;

public class DayCounterState implements GameState<Integer> {
    private Integer dayCounter;

    public DayCounterState(@NonNull Integer dayCounter) {
        this.dayCounter = dayCounter;
    }

    @Override
    public Integer get() {
        return dayCounter;
    }
}
