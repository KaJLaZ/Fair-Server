package game.core.chooseFate;

public class HitApple {
    private static final double CENTER_OF_SQUARE_X = 550;
    private static final double CENTER_OF_SQUARE_Y = 200;
    private static final double LENGTH_OF_HALF_SIDE = 45;

    public static boolean isHited(double x, double y) {
        boolean isBelongByX = x >= (CENTER_OF_SQUARE_X - LENGTH_OF_HALF_SIDE)
                && (x <= CENTER_OF_SQUARE_X + LENGTH_OF_HALF_SIDE);
        boolean isBelongByY = (y >= (CENTER_OF_SQUARE_Y - LENGTH_OF_HALF_SIDE)
                && y <= CENTER_OF_SQUARE_Y + LENGTH_OF_HALF_SIDE);
        return (isBelongByX && isBelongByY);

    }
}
