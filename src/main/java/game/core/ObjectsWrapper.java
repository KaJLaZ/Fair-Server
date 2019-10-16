package game.core;

import java.util.List;

public class ObjectsWrapper<T> {
    private T[] objects;

    public T[] getObjects() {
        return objects;
    }

    public ObjectsWrapper(T... objects) {
        this.objects = objects;
    }
}
