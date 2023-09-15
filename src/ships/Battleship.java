package ships;

import field.Coordinates;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:33
 */
public class Battleship extends Ship {
    public Battleship(Coordinates position, Orientation orientation) {
        super(position, orientation, ShipSize.BATTLESHIP_SIZE);
    }
}
