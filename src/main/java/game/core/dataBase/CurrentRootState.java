package game.core.dataBase;

import game.core.ObjectsWrapper;
import game.core.lobby.GameRoot;
import lombok.NonNull;

public class CurrentRootState implements GameState<ObjectsWrapper<GameRoot>> {
    private ObjectsWrapper<GameRoot> gameRoots;

    public CurrentRootState(@NonNull ObjectsWrapper<GameRoot> gameRoots) {
        this.gameRoots = gameRoots;
    }

    @Override
    public ObjectsWrapper<GameRoot> get() {
        return gameRoots;
    }
}
