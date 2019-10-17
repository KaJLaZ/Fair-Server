package game.core.appleTheft;

import lombok.Data;

import java.util.Random;

@Data
public class Garden {
    private static final int EMPTY = 0;
    private static final int HERO = 1;
    private static final int WALL = 2;
    private static final int DOG = 3;
    private static final int TREE = 4;
    private static final int EXIT = 5;

    public static Random random = new Random();

    private int[][] map;
    private int playerX;
    private int playerY;
    private int dogX;
    private int dogY;
    private boolean dogAsleep;
    private boolean gameEnded;
    private boolean won;

    public Garden() {
        map = new int[10][15];
        wallBuild();
        int exitPlace = 1 + random.nextInt(map[0].length - 2);
        map[map.length - 1][exitPlace] = EXIT;
        map[map.length - 2][exitPlace] = EMPTY;
        setInRandomPlace(TREE);
        setInRandomPlace(HERO);
        setInRandomPlace(DOG);
        dogAsleep = true;
        won = false;
        gameEnded = false;


    }

    public void left() {
        heroMove(playerX, playerY - 1);
    }

    public void right() {
        heroMove(playerX, playerY + 1);
    }

    public void up() {
        heroMove(playerX - 1, playerY);
    }

    public void down() {
        heroMove(playerX + 1, playerY);
    }

    public String gameStatus() {
        String message = new String();
        if (gameEnded) {
            if (won) {
                return "You won\n";
            } else {
                return "You lost\n";
            }
        }
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                message = message + " " + map[i][j];
            }
            message = message + "\n";
        }
        return message;
    }

    private void wallBuild() {
        for (int i = 0; i < map.length; ++i) { //walls around the garden
            map[i][0] = WALL;
            map[i][map[i].length - 1] = WALL;
        }
        for (int i = 0; i < map[0].length; ++i) {
            map[0][i] = WALL;
            map[map.length - 1][i] = WALL;
        }
        for (int i = random.nextInt(5); i < 7; ++i) { //random walls inside
            int wallX = 1 + random.nextInt(map.length - 2);
            int wallY = 1 + random.nextInt(map[wallX].length - 2);
            boolean horizontal = random.nextBoolean();
            for (int j = random.nextInt(5); j < 5; ++j) {
                if (map[wallX][wallY] == EMPTY) {
                    map[wallX][wallY] = WALL;
                }
                if (horizontal && wallY < map[0].length - 1) {
                    wallY++;
                } else if (wallX < map.length - 2) {
                    wallX++;
                }
            }
        }
    }

    protected void heroMove(int x, int y) {
        int scenario = WALL;
        try {
            scenario = map[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        switch (scenario) {
            case EMPTY:
                map[playerX][playerY] = EMPTY;
                playerX = x;
                playerY = y;
                map[playerX][playerY] = HERO;
                dogMove();
                break;
            case DOG:
                gameEnded = true;
                break;
            case TREE:
                dogAsleep = false;
                break;
            case EXIT:
                if (!dogAsleep) {
                    gameEnded = true;
                    won = true;

                }

            default:
                break;
        }
    }

    private void setInRandomPlace(int value) {
        int x;
        int y;

        do {
            x = 1 + random.nextInt(map.length - 2);
            y = 1 + random.nextInt(map[x].length - 2);
        }
        while (map[x][y] != 0);

        map[x][y] = value;
        switch (value) {
            case HERO:
                playerX = x;
                playerY = y;
                break;
            case DOG:
                dogX = x;
                dogY = y;
                break;
        }
    }

    private void dogMove() {
        if (!dogAsleep) {
            if (playerX - dogX > 0 && map[dogX + 1][dogY] == EMPTY) {
                map[dogX][dogY] = EMPTY;
                dogX++;
                map[dogX][dogY] = DOG;
            } else if (playerX - dogX < 0 && map[dogX - 1][dogY] == EMPTY) {
                map[dogX][dogY] = EMPTY;
                dogX--;
                map[dogX][dogY] = DOG;
            }
            if (playerY - dogY > 0 && map[dogX][dogY + 1] == EMPTY) {
                map[dogX][dogY] = EMPTY;
                dogY++;
                map[dogX][dogY] = DOG;
            } else if (playerY - dogY < 0 && map[dogX][dogY - 1] == EMPTY) {
                map[dogX][dogY] = EMPTY;
                dogY--;
                map[dogX][dogY] = DOG;
            }
        }
        if (dogX == playerX && dogY == playerY) {
            gameEnded = true;
        }
    }
}
