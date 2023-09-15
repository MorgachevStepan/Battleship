package field;

import ships.Ship;
import ships.State;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 20:13
 */
public class ShipField implements PieceOfField{
    private final Ship ship;
    private boolean isHitten;

    public ShipField(Ship ship) {
        this.ship = ship;
        isHitten = false;
    }

    @Override
    public char getIcon() {
        return isHitten ? '*' : '@';
    }

    @Override
    public State shoot() {
        ship.getHit();
        isHitten = true;
        return ship.getState();
    }
}
