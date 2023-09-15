package Player;

import field.Field;
import ships.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:27
 */
public class Player {
    private int playerLives;
    private final Field field;

    public Player(){
        playerLives = 20;
        field = new Field();
        field.initialize();
    }

    public Field getField(){
        return field;
    }

    public void decrementLives(){
        playerLives--;
    }

    public boolean isAlive(){
        return playerLives > 0;
    }
}
