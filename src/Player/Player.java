package Player;

import ships.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:27
 */
public class Player {
    private int playerLives;
    private List<Ship> ships;

    public Player(){
        ships = new ArrayList<>(); //TODO
    }
}
