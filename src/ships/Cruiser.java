package ships;

import field.Coordinates;
import utils.Constants;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:37
 */
public class Cruiser extends Ship {
    public Cruiser(Coordinates position, Orientation orientation) {
        super(position, orientation, Constants.CRUISER_SIZE);
    }
}
