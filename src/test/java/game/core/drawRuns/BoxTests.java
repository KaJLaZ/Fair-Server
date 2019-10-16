package game.core.drawRuns;

import game.core.ObjectsWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoxTests {
    Box defaultBox;

    Symbol defaultSymbol;
    ObjectsWrapper defaultSymbols;

    @BeforeEach
    public void defaultBox(){
        defaultSymbol = Mockito.mock(Symbol.class);
        defaultSymbols = new ObjectsWrapper(defaultSymbol);

        defaultBox = new Box("elephant", defaultSymbols);
    }

    @Test
    public void createBox(){
        String nameSymbol = "Rabbit";

        Box box = new Box(nameSymbol, defaultSymbols);

        Assertions.assertEquals(box.getNameGoods(), nameSymbol);
        Assertions.assertEquals(box.getCorrectSymbols(), defaultSymbols);
    }

    @Test
    public void notSetEmptyCorrectSymbols(){
        ObjectsWrapper<Symbol> symbols = new ObjectsWrapper<>();

        System.out.println(symbols.getObjects().length);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Box box = new Box("rose", symbols);
        });
    }

    @Test
    public void setNull(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            Box box = new Box("rose", null);
        });
    }
        @Test
        public void getNameGoods() {
            String name = "desk";
            Box box = new Box(name, defaultSymbols);

            Assertions.assertEquals(name, box.getNameGoods());
        }

        @Test
        public void getCorrectSymbols() {
            Box box = new Box("honey", defaultSymbols);

            Assertions.assertEquals(defaultSymbols, box.getCorrectSymbols());
        }
}
