package Player;

import field.Coordinates;
import field.Field;
import field.PieceOfField;
import ships.Ship;
import ships.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:27
 */
public class Player {
    private int playerLives;
    private final Field field;
    private final String playerName;
    private Map<Coordinates, State> playerTurns;

    public Player(String playerName){
        this.playerName = playerName;
        playerLives = 4;
        playerTurns = new HashMap<>();
        field = new Field();
    }

    public PieceOfField[][] getField(){
        return field.getField();
    }

    public Map<Coordinates, State> getPlayerTurns() {
        return playerTurns;
    }

    public void decrementLives(){
        playerLives--;
    }

    public boolean isAlive(){
        return playerLives > 0;
    }

    public boolean isPieceOfFieldIsEmpty(Coordinates coordinates){
        return !playerTurns.containsKey(coordinates);
    }

    public State getState(Coordinates coordinates){
        return  playerTurns.get(coordinates);
    }

    public String getPlayerName() {
        return playerName;
    }

    public PieceOfField getPieceOfField(int x, int y){
        return field.getField()[y][x];
    }
}
