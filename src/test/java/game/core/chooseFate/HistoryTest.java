package game.core.chooseFate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HistoryTest {
    String defPosSequence = "defPosSequence";
    String defNeqSequence = "defNeqSequence";
    Litigation defLitigation;

    History defHistory;

    @BeforeEach
    public void initializeHistory() {
        defLitigation = Mockito.mock(Litigation.class);
        defHistory = new History(defLitigation, defPosSequence, defNeqSequence);
    }

    @Test
    public void createHistory() {
        History history = new History(defLitigation, "posSeq", "negSeq");
    }

    @Test
    public void getInitializedDefPosSequence() {
        Assertions.assertEquals(defPosSequence, defHistory.getPosSequence());
    }

    @Test
    public void getInitializedDefNegSequence() {
        Assertions.assertEquals(defNeqSequence, defHistory.getNegSequence());
    }

    @Test
    public void getInitializedDefLitigation() {
        Assertions.assertEquals(defLitigation, defHistory.getLitigation());
    }

    @Test
    public void createHistoryWithNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            History history = new History(null, defPosSequence, defNeqSequence);
        });
    }

}
