package ships;

import field.Coordinates;
import utils.Constants;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:33
 */
public class Battleship extends Ship {
    public Battleship(Coordinates position, Orientation orientation) {
        super(position, orientation, Constants.BATTLESHIP_SIZE);
    }
}
