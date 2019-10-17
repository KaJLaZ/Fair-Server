package game.core.drawRuns;

import game.core.ObjectsWrapper;
import lombok.NonNull;

public class Box {
    private String nameGoods;
    private ObjectsWrapper<Symbol> correctSymbols;

    public Box(@NonNull String nameGoods, @NonNull ObjectsWrapper<Symbol> correctSymbols) {
        if (isCorrectSymbolsEmpty(correctSymbols.getObjects()))
            throw new IllegalArgumentException("correct Symbols are Empty");

        this.nameGoods = nameGoods;
        this.correctSymbols = correctSymbols;
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public Symbol[] getCorrectSymbols() {
        return correctSymbols.getObjects();
    }

    private boolean isCorrectSymbolsEmpty(Symbol[] correctSymbols) {
        for (Symbol i : correctSymbols) {

            if (i != null)
                return false;
        }

        return true;
    }
}
