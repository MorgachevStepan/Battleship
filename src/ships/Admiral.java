package ships;

import field.Coordinates;
import field.PieceOfField;
import field.ShipField;
import utils.FieldRender;

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
    private FieldRender fieldRender;
    private PieceOfField[][] field;

    public Admiral(PieceOfField[][] field){
        this.field = field;
        ships = new ArrayList<>();
        shipValidator = new ShipValidator(field);
        fieldRender = new FieldRender(field);
        DEFAULT_POSITION = new Coordinates(-1, -1);
        DEFAULT_ORIENTATION = Orientation.HORIZONTAL;
        createFleet();
    }

    public void arrangeShips() {
        for(Ship ship: ships){
            Orientation orientation = shipValidator.askShipOrientation();
            Coordinates coordinates = shipValidator.askShipCoordinates(ship, orientation);
            arrangeShip(ship, coordinates, orientation);

        }
    }

    private void arrangeShip(Ship ship, Coordinates coordinates, Orientation orientation) {
        ship.setOrientation(orientation);
        ship.setPosition(coordinates);
        setShip(ship);
        fieldRender.render();
    }

    private void createFleet(){
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

    private void setShip(Ship ship){
        for (int i = 0; i < ship.getShipLives(); i++)
            if(ship.getOrientation().toString().equals("HORIZONTAL"))
                field[ship.getPosition().getyCord()][ship.getPosition().getxCord() + i] = new ShipField();
            else
                field[ship.getPosition().getyCord() + i][ship.getPosition().getxCord()] = new ShipField();
    }
}
