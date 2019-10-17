package game.core.appleTheft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GardenTest {

    @Test
    public void MoveTest() {
        Garden garden = new Garden();
        for (int i = 0; i < garden.getMap().length; ++i) {
            for (int j = 0; j < garden.getMap()[i].length; ++j) {
                garden.getMap()[i][j] = 0;
            }
        }
        garden.setPlayerY(3);
        garden.setPlayerX(3);

        garden.up();
        Assertions.assertEquals(2, garden.getPlayerX());
        garden.down();
        Assertions.assertTrue(garden.getPlayerX() == 3);
        garden.left();
        Assertions.assertTrue(garden.getPlayerY() == 2);
        garden.right();
        Assertions.assertTrue(garden.getPlayerY() == 3);
    }

    @Test
    public void CaughtByDog() {
        Garden garden = new Garden();
        garden.heroMove(garden.getDogX(), garden.getDogY());

        Assertions.assertTrue(garden.isGameEnded());
        Assertions.assertFalse(garden.isWon());
    }

    @Test
    public void RanAwayWithoutApples() {
        Garden garden = new Garden();
        garden.getMap()[1][1] = 5;

        garden.heroMove(1, 1);

        Assertions.assertFalse(garden.isGameEnded());
    }

    @Test
    public void RanAwayWithApples() {
        Garden garden = new Garden();
        garden.getMap()[1][1] = 5;
        garden.getMap()[1][2] = 4;

        garden.heroMove(1, 2);
        garden.heroMove(1, 1);

        Assertions.assertTrue(garden.isGameEnded());
        Assertions.assertTrue(garden.isWon());
    }
}
