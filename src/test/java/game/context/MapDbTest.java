package game.context;

import game.core.MapDb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapDbTest {
    MapDb defaultBase;
    @BeforeEach
    public void initializeMapDb(){
        defaultBase = new MapDb();
    }
    @Test
    public void createMapDb(){
        MapDb base = new MapDb();
    }
    @Test
    public void MabDbMustBeFilled(){
        String expected = "";

        Assertions.assertEquals(expected, defaultBase.get(String.class, "consequence"));
    }
    @Test
    public void afterInitializedDbIsHasMoneyMustBeFalse(){
        Boolean expected = false;

        Assertions.assertEquals(expected, defaultBase.get(Boolean.class, "isHasMoney"));
    }

    @Test
    public void isGetSameObject(){
        String expected = "expected";
        String key = "consequence";
        defaultBase.replace(String.class, key, expected);

        Assertions.assertEquals(expected, defaultBase.get(String.class, key));
    }
    @Test
    public void dontReplaceTypeInInappropriateMap(){
        String value = "expected";
        String key = "consequence";

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            defaultBase.replace(Boolean.class, key, value);
        });
    }
    @Test
    public void dontReplaceNull(){
        String value = null;
        String key = "consequence";

        Assertions.assertThrows(NullPointerException.class, ()->{
            defaultBase.replace(Boolean.class, key, value);
        });
    }
    @Test
    public void dontReplaceInAbsentMap(){
        String value = "";
        String key = "consequence";

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            defaultBase.replace(Integer.class, key, value);
        });
    }
    @Test
    public void dontReplaceWithInappropriateKey(){
        String value = "consequence";
        String key = "";

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            defaultBase.replace(Integer.class, key, value);
        });
    }
    @Test
    public void throwNullDueNullTypeValue(){
        String value = "consequence";
        String key = "";

        Assertions.assertThrows(NullPointerException.class, ()->{
            defaultBase.replace(null, key, value);
        });
    }
    @Test
    public void throwNullDueNullKey(){
        String value = "consequence";
        String key = "";

        Assertions.assertThrows(NullPointerException.class, ()->{
            defaultBase.replace(String.class, null, value);
        });
    }
}
