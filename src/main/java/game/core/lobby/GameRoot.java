package game.core.lobby;

import lombok.NonNull;

public class GameRoot {
    private String description;

    public String getDescription() {
        return description;
    }

    public enum Games{
        APPLE_THEFT(0), CHOOSE_FATE(1), DRAW_RUNS(2), DRINKERS(3),
        SEQUENCE(4), END_GAME(5);

        private int numberOfGame;

        public int getNumberOfGame() {
            return numberOfGame;
        }

        Games(int numberOfGame) {
            this.numberOfGame = numberOfGame;
        }
    }

    Games game;

    public Games getGame() {
        return game;
    }

    public static final int AMOUNT_BOX_FOR_ONE_GAME = 3;

    public static final double CENTER_OF_SQUARE_X = 550;
    public static final double CENTER_OF_SQUARE_Y = 200;
    public static final double LENGTH_OF_HALF_SIDE = 45;

    public GameRoot(@NonNull String description, @NonNull Games game) {
        this.description = description;
        this.game = game;
    }
}
