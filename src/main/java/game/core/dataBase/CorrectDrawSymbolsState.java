package game.core.dataBase;

import lombok.NonNull;

public class CorrectDrawSymbolsState implements GameState<Integer> {
    private Integer drawSymbols;

    public CorrectDrawSymbolsState(@NonNull Integer drawSymbols) {
        this.drawSymbols = drawSymbols;
    }

    @Override
    public Integer get() {
        return drawSymbols;
    }
}
