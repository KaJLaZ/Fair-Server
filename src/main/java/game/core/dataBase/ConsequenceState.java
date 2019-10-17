package game.core.dataBase;

import lombok.NonNull;

public class ConsequenceState implements GameState<String> {
    private String consequence;

    public ConsequenceState(@NonNull String consequence) {
        this.consequence = consequence;
    }

    @Override
    public String get() {
        return consequence;
    }
}
