package game.core.dataBase;

import lombok.NonNull;

public class HasMoneyState implements GameState<Boolean> {
    private Boolean hasMoney;

    public HasMoneyState(@NonNull Boolean hasMoney) {
        this.hasMoney = hasMoney;
    }

    @Override
    public Boolean get() {
        return hasMoney;
    }
}
