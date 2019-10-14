package game.core.drawRuns;

import lombok.NonNull;

public class Box {
    private String nameGoods;

    public String getNameGoods() {
        return nameGoods;
    }

    private Symbol[] correctSymbols;

    public Symbol[] getCorrectSymbols() {
        return correctSymbols;
    }

    public Box(@NonNull String nameGoods,@NonNull Symbol[] correctSymbols) {
        if(isCorrectSymbolsEmpty(correctSymbols))
            throw new IllegalArgumentException("correct Symbols are Empty");

        this.nameGoods = nameGoods;
        this.correctSymbols = correctSymbols;
    }

    private boolean isCorrectSymbolsEmpty(Symbol[] correctSymbols){
        for(Symbol i : correctSymbols){

            if(i != null)
                return false;
        }

        return true;
    }
}
