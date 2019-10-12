package game.context;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Component
public class MapDb {
    private Map<Type, Map> base;

    public MapDb() {
        this.base = new HashMap<>();

        Map stringMap = getStringMap();
        Map booleanMap = getBooleanMap();
        Map integerMap = getIntegerMap();

        base.put(String.class, stringMap);
        base.put(Boolean.class, booleanMap);
        base.put(Integer.class, integerMap);
    }

    private Map<String, String> getStringMap(){
        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("consequence", "");

        return stringMap;
    }

    private Map<String, Boolean> getBooleanMap(){
        Map<String, Boolean> booleanMap = new HashMap<>();

        booleanMap.put("isHasMoney", false);

        return booleanMap;
    }

    private Map<String, Integer> getIntegerMap(){
        Map<String, Integer> integerMap = new HashMap<>();

        integerMap.put("gameCounter", 0);

        return integerMap;
    }

    public Object get(@NonNull Type valueType, @NonNull String key){
        Map map = base.get(valueType);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");

        Object value = map.get(key);

        if(value == null)
            throw new IllegalArgumentException("didn't find element");

        return value;
    }

    public void replace(@NonNull Type valueType, @NonNull String key, @NonNull String value){
        if(valueType != value.getClass())
            throw new IllegalArgumentException("incorrect type of value");

        Map map = base.get(valueType);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");

        Object exValue = map.replace(key, value);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");
    }

    public void replace(@NonNull Type valueType, @NonNull String key, @NonNull Boolean value){
        if(valueType != value.getClass())
            throw new IllegalArgumentException("incorrect type of value");

        Map map = base.get(valueType);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");

        Object exValue = map.replace(key, value);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");
    }

    public void replace(@NonNull Type valueType, @NonNull String key, @NonNull Integer value){
        if(valueType != value.getClass())
            throw new IllegalArgumentException("incorrect type of value");

        Map map = base.get(valueType);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");

        Object exValue = map.replace(key, value);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");
    }
}
