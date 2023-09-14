package ships;

import field.Coordinates;

import java.util.Scanner;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 13:51
 */
public class ShipValidator {
    private Scanner scanner;

    public ShipValidator(){
        scanner = new Scanner(System.in);
    }
    public Orientation askShipOrientation() {
        System.out.println("Как вы хотите разместить корабль горизонтально (HORIZONTAL) или вертикально (VERTICAL)");
        String orientation;
        do{
            orientation = scanner.nextLine().trim();
        } while (!(Orientation.HORIZONTAL.toString().equals(orientation) || Orientation.VERTICAL.toString().equals(orientation)));
        return Orientation.valueOf(orientation);
    }

    public Coordinates askShipCoordinates(Ship ship, Orientation orientation) {
        Coordinates coordinates;
        System.out.println("Введите начальную позицию для корабля");
        do{
            coordinates = new Coordinates(scanner.nextInt(), scanner.nextInt());
        }while (!isValidCoordinates(coordinates, ship.getShipLives(), ship.getOrientation()));
        return coordinates;
    }

    private boolean isValidCoordinates(Coordinates coordinates, int shipLives, Orientation orientation) {
        int xDifferential = 0;
        int yDifferential = 0;
        int xPosition = coordinates.getxCord();
        int yPosition = coordinates.getyCord();

        if(Orientation.HORIZONTAL.equals(orientation))
            xDifferential = 1;
        else yDifferential = 1;

        if(!isInside(xPosition, yPosition) || (!isInside(xPosition + shipLives, yPosition) && xDifferential == 1)
           || (!isInside(xPosition, yPosition + shipLives) && yDifferential == 1)) {
            return false;
        }

        for (int i = 0; i < shipLives; i++);

        return  false;
    }

    private boolean isInside(int xPosition, int yPosition) {
        return xPosition <= 9 && xPosition >= 0 && yPosition <= 9 && yPosition >= 0;
    }
}
