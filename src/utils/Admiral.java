package utils;

import Player.Player;
import field.Coordinates;
import field.ShipField;
import ships.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 13:47
 */
public class Admiral {
    private final Coordinates DEFAULT_POSITION;
    private final Orientation DEFAULT_ORIENTATION;
    private final List<Ship> ships;
    private final ShipValidator shipValidator;
    private final FieldRender fieldRender;
    private final Player player;

    public Admiral(Player player){
        this.player = player;
        ships = new ArrayList<>();
        shipValidator = new ShipValidator(player.getField());
        fieldRender = new FieldRender(player);
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
            if(ship.getOrientation() == Orientation.HORIZONTAL)
                player.getField()[ship.getPosition().getyCord()][ship.getPosition().getxCord() + i] = new ShipField(ship);
            else
                player.getField()[ship.getPosition().getyCord() + i][ship.getPosition().getxCord()] = new ShipField(ship);
    }
}
