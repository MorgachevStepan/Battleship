package ships;

import field.Coordinates;
import utils.Constants;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:38
 */
public class Destroyer extends Ship {
    public Destroyer(Coordinates position, Orientation orientation) {
        super(position, orientation, ShipSize.DESTROYER_SIZE);
    }
}
