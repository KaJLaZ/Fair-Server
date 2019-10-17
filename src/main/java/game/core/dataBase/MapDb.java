package game.core.dataBase;

import game.core.ObjectsWrapper;
import game.core.drawRuns.Box;
import game.core.drawRuns.Symbol;
import game.core.lobby.GameRoot;
import game.utility.Utilities;
import lombok.NonNull;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MapDb<T extends GameState> {
    private static MapDb mapDBB;

    private Map<Type, T> base;

    private MapDb() {
        base = new HashMap<>();

        GameState<Box> boxState = new SentBoxState(new Box("", new ObjectsWrapper<>(Symbol.defaultSymbol)));
        GameState<ObjectsWrapper<GameRoot>> currentRootState = new CurrentRootState(Utilities.getBean("firstDayFirstRoot"));
        GameState<String> consequenceState = new ConsequenceState("");

        GameState<Boolean> isHasMoneyState = new HasMoneyState(false);
        GameState<Boolean> isStolenApples = new IsStolenApplesState(false);
        GameState<Boolean> isDrunkState = new IsDrunkState(true);

        GameState<Integer> gameCounterState = new GameCounterState(0);
        GameState<Integer> sentBoxCounter = new SentBoxCounterState(0);
        GameState<Integer> corDrawSymbState = new CorrectDrawSymbolsState(0);
        GameState<Integer> dayCounterState = new DayCounterState(1);

        base.put(SentBoxState.class, (T) boxState);
        base.put(CurrentRootState.class, (T) currentRootState);
        base.put(ConsequenceState.class, (T) consequenceState);

        base.put(HasMoneyState.class, (T) isHasMoneyState);
        base.put(IsStolenApplesState.class, (T) isStolenApples);
        base.put(IsDrunkState.class, (T) isDrunkState);

        base.put(GameCounterState.class, (T) gameCounterState);
        base.put(SentBoxCounterState.class, (T) sentBoxCounter);
        base.put(CorrectDrawSymbolsState.class, (T) corDrawSymbState);
        base.put(DayCounterState.class, (T) dayCounterState);
    }

    public static MapDb getMapDb() {
        if (mapDBB == null)
            mapDBB = new MapDb();

        return mapDBB;
    }

    public T get(@NonNull Type type) {
        T value = base.get(type);

        if (value == null)
            throw new NullPointerException();

        return value;
    }

    public void replace(@NonNull Type type, @NonNull GameState gameState) {

        GameState value = base.replace(type, (T) gameState);

        if (value == null)
            throw new NullPointerException();
    }

}
