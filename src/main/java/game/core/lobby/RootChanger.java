package game.core.lobby;

import game.core.ObjectsWrapper;
import game.core.dataBase.*;
import game.utility.Utilities;
import lombok.NonNull;

public class RootChanger {
    private MapDb mapBase;

    public RootChanger(@NonNull MapDb mapBase) {
        this.mapBase = mapBase;
    }

    public static int getRelevantRootNumber(GameRoot[] root, MapDb mapBase) {
        int order = (int) mapBase.get(GameCounterState.class).get();
        mapBase.replace(GameCounterState.class, new GameCounterState(order + 1));

        if (order == root.length) {

            int day = (int) mapBase.get(DayCounterState.class).get();
            mapBase.replace(DayCounterState.class, new DayCounterState(day + 1));

            mapBase.replace(IsStolenApplesState.class, new IsStolenApplesState(false));
            mapBase.replace(HasMoneyState.class, new HasMoneyState(false));

            order = 0;
            mapBase.replace(GameCounterState.class, new GameCounterState(order + 1));
        }

        return order;
    }

    public GameRoot[] changeRoot(GameRoot[] root, int order) {

        if ((int) mapBase.get(DayCounterState.class).get() == 1) {

            if (root[order].getGame() == GameRoot.Games.DRAW_RUNS)
                root = getRelRootAtDrawRuns(root);

            else if (root[order].getGame() == GameRoot.Games.DRINKERS)
                root = getRelRootAtDrinkers(root);

        } else if ((int) mapBase.get(DayCounterState.class).get() == 2) {

            if (root[order].getGame() == GameRoot.Games.APPLE_THEFT)
                root = getRelRootAtSecDayFirGame(root);


            else if (root[order].getGame() == GameRoot.Games.DRAW_RUNS)
                root = getRelRootAtSecDayDrinkers(root);

            else if (root[order].getGame() == GameRoot.Games.DRINKERS)
                root = getRelRootAtDayConsequence(root);
        } else if ((Integer) mapBase.get(DayCounterState.class).get() == 3) {
            root = getRelRootAtThirdDay(root);
        }

        return root;
    }

    private GameRoot[] getRelRootAtSecDayFirGame(GameRoot[] root) {

        if ((Boolean) mapBase.get(IsDrunkState.class).get()) {
            GameRoot[] newGameRoot = (GameRoot[]) Utilities.getBean("secondDaySecondRoot").getObjects();
            mapBase.replace(CurrentRootState.class, new CurrentRootState(new ObjectsWrapper<>(newGameRoot)));
            root = newGameRoot;
        } else {
            GameRoot[] newGameRoot = (GameRoot[]) Utilities.getBean("secondDayFirstRoot").getObjects();
            mapBase.replace(CurrentRootState.class, new CurrentRootState(new ObjectsWrapper<>(newGameRoot)));
            root = newGameRoot;
        }

        return root;
    }

    private GameRoot[] getRelRootAtDrawRuns(GameRoot[] root) {

        if ((boolean) mapBase.get(HasMoneyState.class).get()) {
            GameRoot[] newGameRoot = (GameRoot[]) Utilities.getBean("firstDaySecondRoot").getObjects();
            mapBase.replace(CurrentRootState.class, new CurrentRootState(new ObjectsWrapper<>(newGameRoot)));
            root = newGameRoot;
        }

        return root;
    }

    private GameRoot[] getRelRootAtDrinkers(GameRoot[] root) {

        if (!(boolean) mapBase.get(HasMoneyState.class).get()) {
            GameRoot[] newGameRoot = (GameRoot[]) Utilities.getBean("firstDayThirdRoot").getObjects();
            mapBase.replace(CurrentRootState.class, new CurrentRootState(new ObjectsWrapper<>(newGameRoot)));
            mapBase.replace(IsDrunkState.class, new IsDrunkState(false));
            root = newGameRoot;
        }
        return root;
    }

    private GameRoot[] getRelRootAtSecDayDrinkers(GameRoot[] root) {

        if ((boolean) mapBase.get(HasMoneyState.class).get()) {
            GameRoot[] newGameRoot = (GameRoot[]) Utilities.getBean("secondDaySixthRoot").getObjects();
            mapBase.replace(CurrentRootState.class, new CurrentRootState(new ObjectsWrapper<>(newGameRoot)));
            root = newGameRoot;
        }
        return root;
    }

    private GameRoot[] getRelRootAtDayConsequence(GameRoot[] root) {
        if (!(boolean) mapBase.get(HasMoneyState.class).get()) {
            GameRoot[] newGameRoot = (GameRoot[]) Utilities.getBean("secondDayFifthRoot").getObjects();
            mapBase.replace(CurrentRootState.class, new CurrentRootState(new ObjectsWrapper<>(newGameRoot)));
            mapBase.replace(IsDrunkState.class, new IsDrunkState(false));
            root = newGameRoot;
        }
        return root;
    }

    private GameRoot[] getRelRootAtThirdDay(GameRoot[] root) {
        root = (GameRoot[]) Utilities.getBean("thirdDay").getObjects();
        mapBase.replace(CurrentRootState.class, new CurrentRootState(new ObjectsWrapper<>(root)));
        return root;
    }
}
