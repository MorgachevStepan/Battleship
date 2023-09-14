package ships;

import field.Coordinates;
import utils.Constants;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 14:01
 */
public class SpeedBoat extends Ship{
    public SpeedBoat(Coordinates position, Orientation orientation) {
        super(position, orientation, Constants.SPEEDBOAT_SIZE);
    }
}
