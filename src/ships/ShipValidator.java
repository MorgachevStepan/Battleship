package ships;

import field.Coordinates;
import field.PieceOfField;

import java.util.Scanner;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 13:51
 */
public class ShipValidator {
    private Scanner scanner;
    private PieceOfField[][] field;

    public ShipValidator(PieceOfField[][] field){
        scanner = new Scanner(System.in);
        this.field = field;
    }
    public Orientation askShipOrientation() {
        String orientation;
        do{
            System.out.println("Как вы хотите разместить корабль горизонтально (HORIZONTAL) или вертикально (VERTICAL)");
            orientation = scanner.nextLine().trim();
        } while (!(Orientation.HORIZONTAL.toString().equals(orientation) || Orientation.VERTICAL.toString().equals(orientation)));
        return Orientation.valueOf(orientation);
    }

    public Coordinates askShipCoordinates(Ship ship, Orientation orientation) {
        Coordinates coordinates;
        do{
            System.out.println("Введите начальную позицию для корабля");
            int yCoord = scanner.nextInt();
            int xCoord = scanner.nextInt();
            coordinates = new Coordinates(xCoord, yCoord);
        }while (!isValidCoordinates(coordinates, ship.getShipLives(), ship.getOrientation()));
        return coordinates;
    }

    private boolean isValidCoordinates(Coordinates coordinates, int shipLives, Orientation orientation) {
        int xCoord = coordinates.getxCord();
        int yCoord = coordinates.getyCord();
        if(Orientation.HORIZONTAL.equals(orientation)){
            for(int i = 0; i < shipLives; i++){
                if(!(checkPositionHorizontal(yCoord, xCoord + i) && isInside(xCoord, yCoord)))
                    return false;
            }
        }
        else{
            for(int i = 0; i < shipLives; i++){
                if(!(checkPositionVertical(yCoord + i, xCoord) && isInside(xCoord, yCoord)))
                    return false;
            }
        }

        return true;
    }

    private boolean checkPositionVertical(int yCoord, int xCoord) {
        return field[yCoord][xCoord].getIcon() != '@' && field[yCoord][xCoord + 1].getIcon() != '@'
                && field[yCoord + 1][xCoord].getIcon() != '@' && field[yCoord - 1][xCoord].getIcon() != '@'
                && field[yCoord - 1][xCoord - 1].getIcon() != '@' && field[yCoord - 1][xCoord + 1].getIcon() != '@'
                && field[yCoord + 1][xCoord - 1].getIcon() != '@' && field[yCoord + 1][xCoord + 1].getIcon() != '@'
                && yCoord <= 10;
    }

    private boolean checkPositionHorizontal(int yCoord, int xCoord) {
        return field[yCoord][xCoord].getIcon() != '@' && field[yCoord][xCoord + 1].getIcon() != '@'
                && field[yCoord + 1][xCoord].getIcon() != '@' && field[yCoord - 1][xCoord].getIcon() != '@'
                && field[yCoord - 1][xCoord - 1].getIcon() != '@' && field[yCoord - 1][xCoord + 1].getIcon() != '@'
                && field[yCoord + 1][xCoord - 1].getIcon() != '@' && field[yCoord + 1][xCoord + 1].getIcon() != '@'
                && xCoord <= 10;
    }

    private boolean isInside(int xPosition, int yPosition) {
        return xPosition <= 9 && xPosition >= 0 && yPosition <= 9 && yPosition >= 0;
    }
}
