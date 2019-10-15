package game.core.chooseFate;

import java.util.List;

public class ObjectsWrapper<T> {
    private final List objects;

    public List<T> getObjects() {
        return objects;
    }

    public ObjectsWrapper(List<T> objects) {
        this.objects = objects;
    }
}
