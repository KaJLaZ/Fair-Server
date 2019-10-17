package game.core.dataBase;

import lombok.NonNull;

public class IsDrunkState implements GameState<Boolean> {
    private Boolean isDrunk;

    public IsDrunkState(@NonNull Boolean isDrunk) {
        this.isDrunk = isDrunk;
    }

    @Override
    public Boolean get() {
        return isDrunk;
    }
}
