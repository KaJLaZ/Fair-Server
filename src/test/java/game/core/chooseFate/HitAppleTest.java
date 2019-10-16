package game.core.chooseFate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HitAppleTest {
    @Test
    public void isMethodIsHitedReturnResultOfShutCorrectly(){
        assertTrue(HitApple.isHited(550, 200));
        assertTrue(HitApple.isHited(595, 245));
        assertTrue(HitApple.isHited(520, 180));
        assertFalse(HitApple.isHited(0,0));
        assertFalse(HitApple.isHited(700,500));

    }

}
