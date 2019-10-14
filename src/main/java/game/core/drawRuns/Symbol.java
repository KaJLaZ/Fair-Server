package game.core.drawRuns;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.ArrayList;
@EqualsAndHashCode
public class Symbol {
    public static final int AMOUNT_COLUMNS = 4;
    public static final int AMOUNT_ROWS = 4;

    public static final Symbol defaultSymbol = new Symbol(new boolean[][] {{false, false, false, false},
                                                                           {false, false, false, false},
                                                                           {false, false, false, false},
                                                                           {false, false, false, false}
    });

    private boolean[][] appearance;

    public boolean[][] getAppearance() {
        return appearance;
    }

    public Symbol(@NonNull boolean[][] appearance) {
        if(appearance.length != AMOUNT_ROWS || appearance[0].length != AMOUNT_COLUMNS)
            throw new IllegalArgumentException("input massive is not correct");
        this.appearance = appearance;
    }

    public Symbol() { }

    public static boolean isSymbolCorrect(Symbol symbol, Symbol[] correctSymbols){

        for(Symbol i : correctSymbols){

            if(i.equals(symbol))
                return true;
        }
        return false;
    }
}
