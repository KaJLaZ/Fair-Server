package game.core.lobby;

import lombok.NonNull;

public class Game {
    private String description;

    public String getDescription() {
        return description;
    }

    public enum Games{
        APPLE_THEFT, CHOOSE_FATE, DRAW_RUNS, DRINKERS, SEQUENCE
    }

    Games game;

    public Games getGame() {
        return game;
    }

    public Game(@NonNull String description, @NonNull Games game) {
        this.description = description;
        this.game = game;
    }
}
