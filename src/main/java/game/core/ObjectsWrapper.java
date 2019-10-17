package game.core;

public class ObjectsWrapper<T> {
    private T[] objects;

    public ObjectsWrapper(T... objects) {
        this.objects = objects;
    }

    public T[] getObjects() {
        return objects;
    }
}
