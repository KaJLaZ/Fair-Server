package game.core;

import game.core.drawRuns.Box;
import game.core.drawRuns.Symbol;
import lombok.NonNull;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MapDb {
    private static MapDb mapDb;

    private Map<Type, Map> base;

    private MapDb() {
        base = new HashMap<>();

        Map stringMap = getStringMap();
        Map booleanMap = getBooleanMap();
        Map integerMap = getIntegerMap();
        Map boxMap = getBoxMap();

        base.put(String.class, stringMap);
        base.put(Boolean.class, booleanMap);
        base.put(Integer.class, integerMap);
        base.put(Box.class, boxMap);
    }

    public static MapDb getMapDB(){
        if(mapDb == null)
            mapDb = new MapDb();

        return mapDb;
    }

    private Map<String, String> getStringMap(){
        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("consequence", "");

        return stringMap;
    }

    private Map<String, Boolean> getBooleanMap(){
        Map<String, Boolean> booleanMap = new HashMap<>();

        booleanMap.put("isHasMoney", false);
        booleanMap.put("isStolenApples", false);

        return booleanMap;
    }

    private Map<String, Integer> getIntegerMap(){
        Map<String, Integer> integerMap = new HashMap<>();

        integerMap.put("gameCounter", 0);
        integerMap.put("sentBoxCounter", 0);
        integerMap.put("correctDrawSymbols", 0);
        return integerMap;
    }

    private Map<String, Box> getBoxMap(){
        Map<String, Box> boxMap = new HashMap<>();

        boxMap.put("sentBox", new Box("", new Symbol[]{Symbol.defaultSymbol}));

        return boxMap;
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

        if(!map.containsKey(key))
            throw new IllegalArgumentException("didn't find element");

        map.replace(key, value);
    }

    public void replace(@NonNull Type valueType, @NonNull String key, @NonNull Boolean value){
        if(valueType != value.getClass())
            throw new IllegalArgumentException("incorrect type of value");

        Map map = base.get(valueType);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");

        if(!map.containsKey(key))
            throw new IllegalArgumentException("didn't find element");

        map.replace(key, value);
    }

    public void replace(@NonNull Type valueType, @NonNull String key, @NonNull Integer value){
        if(valueType != value.getClass())
            throw new IllegalArgumentException("incorrect type of value");

        Map map = base.get(valueType);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");

        if(!map.containsKey(key))
            throw new IllegalArgumentException("didn't find element");

        map.replace(key, value);
    }

    public void replace(@NonNull Type valueType, @NonNull String key, @NonNull Box value){
        if(valueType != value.getClass())
            throw new IllegalArgumentException("incorrect type of value");

        Map map = base.get(valueType);

        if(map == null)
            throw new IllegalArgumentException("didn't find element");

        if(!map.containsKey(key))
            throw new IllegalArgumentException("didn't find element");

        map.replace(key, value);
    }
}
