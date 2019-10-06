package game.core.drawRuns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SymbolTests {

    static boolean[][] defaultAppearance = {{true, true, false, true},
                                            {true, true, true, false},
                                            {false, true, true, true},
                                            {false, true, false, false}
    };

    static Symbol defaultSymbol = new Symbol(defaultAppearance);

    @Test
    public void createSymbolWithSuccessfulAppearance(){
        Symbol symbol = new Symbol(defaultAppearance);
    }

    @Test
    public void createSymbolWithUnsuccessfulAppearance(){
        boolean[][] symbolAppearance = {{true, true, false},
                                        {true, true, true },
        };

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Symbol symbol = new Symbol(symbolAppearance);
        });
    }

    @Test
    public void setNull(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            Symbol symbol = new Symbol(null);
        });
    }

    @Nested
    class Equals {
        @Test
        public void twoSymbolsWithSameAppearance() {
            Symbol symbol1 = new Symbol(defaultAppearance);
            Symbol symbol2 = new Symbol(defaultAppearance);

            Assertions.assertTrue(symbol1.equals(symbol2));
        }

        @Test
        public void twoSymbolsWithNotSameAppearance() {
            boolean[][] symbolAppearance1 = {{true, true, false, true},
                                             {true, true, true, true},
                                             {false, true, true, false},
                                             {false, true, true, false}
            };
            boolean[][] symbolAppearance2 = {{true, true, false, false},
                                             {true, true, false, true},
                                             {false, true, true, true},
                                             {false, true, true, false}
            };

            Symbol symbol1 = new Symbol(symbolAppearance1);
            Symbol symbol2 = new Symbol(symbolAppearance2);

            Assertions.assertFalse(symbol1.equals(symbol2));
        }

        @Test public void SameReferences(){
            Assertions.assertTrue(defaultSymbol.equals(defaultSymbol));
        }

        @Nested
        class getAppearance{
            @Test
            public void compareDefaultApperances(){
                Assertions.assertEquals(defaultAppearance, defaultSymbol.getAppearance());
            }
        }
    }
}
