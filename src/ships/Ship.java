package ships;

import field.Coordinates;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:16
 */
public abstract class Ship {
    private Coordinates position;
    private Orientation orientation;
    private int shipLives;

    public Ship(Coordinates position, Orientation orientation, int shipLives) {
        this.position = position;
        this.orientation = orientation;
        this.shipLives = shipLives;
    }
}
