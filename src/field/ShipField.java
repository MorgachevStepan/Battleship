package field;

import ships.Ship;

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
        String state = ship.getState();
        char icon = ' ';
        switch (state){
            case "No hit": icon =  '@';
                break;
            case "Hit" :
            case "Destroyed":
                icon =  '*';
                break;
        }
        return icon;
    }

    @Override
    public String shoot() {
        ship.getHit();
        return ship.getState();
    }
}
