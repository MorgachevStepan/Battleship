package field;

import ships.Ship;
import ships.State;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 20:13
 */
public class ShipField implements PieceOfField{
    private final Ship ship;

    public ShipField(Ship ship) {
        this.ship = ship;
    }

    @Override
    public char getIcon() {
        System.out.println(ship.getShipLives());
        State state = ship.getState();
        char icon = ' ';
        switch (state){
            case NO_HIT: icon =  '@';
                break;
            case HIT:
            case DESTROYED:
                icon =  '*';
                break;
        }
        return icon;
    }

    @Override
    public State shoot() {
        ship.getHit();
        return ship.getState();
    }
}
