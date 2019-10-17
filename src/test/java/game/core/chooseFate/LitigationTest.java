package game.core.chooseFate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LitigationTest {
    String personDescription = "personDescription";
    String defFaultDesc = "defFaultDesc";
    String defDescPosChoice = "defDescPosChoice";
    String defDescNegChoice = "defDescNegChoice";
    Litigation litigation;

    @BeforeEach
    public void initializeLitigation() {
        litigation = new Litigation(personDescription, defFaultDesc, defDescPosChoice, defDescNegChoice);
    }

    @Test
    public void createLitigation() {
        Litigation litigation = new Litigation("asd", "asd",
                "asd", "asd");
    }

    @Test
    public void getInizializedDefFaultDesc() {
        Assertions.assertEquals(defFaultDesc, litigation.getFaultDesc());
    }

    @Test
    public void getInizializedDefDescPosChoice() {
        Assertions.assertEquals(defDescPosChoice, litigation.getDescPosChoice());
    }

    @Test
    public void getInizializedDefDescNegChoice() {
        Assertions.assertEquals(defDescNegChoice, litigation.getDescNegChoice());
    }

    @Test
    public void createLitigationWithNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Litigation litigation = new Litigation(null, null, defDescPosChoice, defDescNegChoice);
        });
    }
}
