package game.core.drawRuns;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
public class Symbol {
    public static final int AMOUNT_COLUMNS = 4;
    public static final int AMOUNT_ROWS = 4;

    public static final Symbol defaultSymbol = new Symbol(new boolean[][]{{false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false}
    });

    private boolean[][] appearance;

    public Symbol(@NonNull boolean[][] appearance) {
        if (appearance.length != AMOUNT_ROWS || appearance[0].length != AMOUNT_COLUMNS)
            throw new IllegalArgumentException("input massive is not correct");
        this.appearance = appearance;
    }

    public Symbol() {
    }

    public static boolean isSymbolCorrect(Symbol symbol, Symbol[] correctSymbols) {

        for (Symbol i : correctSymbols) {

            if (i.equals(symbol))
                return true;
        }
        return false;
    }

    public static boolean[][] transformToAppearance(String[] appearance) {
        int counter = 0;
        boolean[][] newAppearance = new boolean[AMOUNT_ROWS][AMOUNT_COLUMNS];

        for (int i = 0; i < appearance.length; i++) {
            appearance[i] = appearance[i].replace('"', ' ');
            appearance[i] = appearance[i].replace('[', ' ');
            appearance[i] = appearance[i].replace(']', ' ');
            appearance[i] = appearance[i].trim();
        }

        for (int i = 0; i < Symbol.AMOUNT_ROWS; i++) {
            for (int j = 0; j < Symbol.AMOUNT_COLUMNS; j++) {
                newAppearance[i][j] = Boolean.valueOf(appearance[counter++]);
            }
        }

        return newAppearance;
    }

    public boolean[][] getAppearance() {
        return appearance;
    }
}
