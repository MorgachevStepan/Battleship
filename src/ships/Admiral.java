package ships;

import field.Coordinates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 13:47
 */
public class Admiral {
    private final Coordinates DEFAULT_POSITION;
    private final Orientation DEFAULT_ORIENTATION;
    private List<Ship> ships;
    private ShipValidator shipValidator;

    public Admiral(){
        ships = new ArrayList<>();
        shipValidator = new ShipValidator();
        DEFAULT_POSITION = new Coordinates(-1, -1);
        DEFAULT_ORIENTATION = Orientation.HORIZONTAL;
        createFleet();
        arrangeShips();
    }

    private void arrangeShips() {
        for(Ship ship: ships){
            Orientation orientation = shipValidator.askShipOrientation();
            Coordinates coordinates = shipValidator.askShipCoordinates(ship, orientation);
            arrangeShip(ship, coordinates, orientation);
        }
    }

    private void arrangeShip(Ship ship, Coordinates coordinates, Orientation orientation) {
        ship.setOrientation(orientation);
        ship.setPosition(coordinates);
    }

    public void createFleet(){
        ships.add(new Battleship(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new Cruiser(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new Cruiser(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new Destroyer(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new Destroyer(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new Destroyer(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new SpeedBoat(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new SpeedBoat(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new SpeedBoat(DEFAULT_POSITION, DEFAULT_ORIENTATION));
        ships.add(new SpeedBoat(DEFAULT_POSITION, DEFAULT_ORIENTATION));
    }


}
