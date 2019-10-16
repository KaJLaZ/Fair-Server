package game.core.drawRuns;

import game.core.ObjectsWrapper;
import lombok.NonNull;

public class Box {
    private String nameGoods;

    public String getNameGoods() {
        return nameGoods;
    }

    private ObjectsWrapper<Symbol> correctSymbols;

    public Symbol[] getCorrectSymbols() {
        return correctSymbols.getObjects();
    }

    public Box(@NonNull String nameGoods,@NonNull ObjectsWrapper<Symbol> correctSymbols) {
        if(isCorrectSymbolsEmpty(correctSymbols.getObjects()))
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
