package game.context;

import game.core.dataBase.ConsequenceState;
import game.core.dataBase.HasMoneyState;
import game.core.dataBase.MapDb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapDbTest {
    MapDb defaultBase;

    @BeforeEach
    public void initializeMapDb() {
        defaultBase = MapDb.getMapDb();
    }

    @Test
    public void createMapDb() {
        MapDb base = MapDb.getMapDb();
    }

    @Test
    public void MabDbMustBeFilled() {
        String expected = "";

        Assertions.assertEquals(expected, defaultBase.get(ConsequenceState.class).get());
    }

    @Test
    public void afterInitializedDbIsHasMoneyMustBeFalse() {
        Boolean expected = false;

        Assertions.assertEquals(expected, defaultBase.get(HasMoneyState.class).get());
    }

    @Test
    public void isGetSameObject() {
        String expected = "expected";
        String key = "consequence";
        defaultBase.replace(ConsequenceState.class, new ConsequenceState(expected));

        Assertions.assertEquals(expected, defaultBase.get(ConsequenceState.class).get());
    }

    @Test
    public void dontReplaceNull() {
        String value = null;
        String key = "consequence";

        Assertions.assertThrows(NullPointerException.class, () -> {
            defaultBase.replace(ConsequenceState.class, new ConsequenceState(value));
        });
    }

    @Test
    public void dontReplaceWithInappropriateKey() {
        String value = "consequence";
        String key = "";

        Assertions.assertThrows(NullPointerException.class, () -> {
            defaultBase.replace(Boolean.class, new ConsequenceState(value));
        });
    }

    @Test
    public void throwNullDueNullTypeValue() {
        String value = "consequence";
        String key = "";

        Assertions.assertThrows(NullPointerException.class, () -> {
            defaultBase.replace(null, new ConsequenceState(value));
        });
    }

    @Test
    public void throwNullDueNullKey() {
        String value = "consequence";
        String key = "";

        Assertions.assertThrows(NullPointerException.class, () -> {
            defaultBase.replace(Boolean.class, null);
        });
    }
}
