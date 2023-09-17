package utils;

import field.Coordinates;
import field.PieceOfField;
import ships.Orientation;
import ships.Ship;

import java.util.Scanner;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 13:51
 */
public class ShipValidator {
    private final Scanner scanner;
    private final PieceOfField[][] field;

    public ShipValidator(PieceOfField[][] field){
        scanner = new Scanner(System.in);
        this.field = field;
    }
    public Orientation askShipOrientation() {
        int orientation;
        do{
            System.out.println("Как вы хотите разместить корабль горизонтально (0) или вертикально (1)");
            orientation = scanner.nextInt();
        } while (!(Orientation.HORIZONTAL.ordinal() == orientation || Orientation.VERTICAL.ordinal() == orientation));
        if(orientation == 0)
            return Orientation.HORIZONTAL;
        else
            return Orientation.VERTICAL;
    }

    public Coordinates askShipCoordinates(Ship ship, Orientation orientation) {
        Coordinates coordinates;
        do{
            System.out.println("Введите начальную позицию для корабля");
            int yCoord = scanner.nextInt() + 1;
            int xCoord = scanner.nextInt() + 1;
            coordinates = new Coordinates(xCoord, yCoord);
        }while (!isValidCoordinates(coordinates, ship.getShipLives(), orientation));
        return coordinates;
    }

    private boolean isValidCoordinates(Coordinates coordinates, int shipLives, Orientation orientation) {
        int xCoord = coordinates.getxCord();
        int yCoord = coordinates.getyCord();
        if(Orientation.HORIZONTAL.equals(orientation)){
            for(int i = 0; i < shipLives; i++){
                if(!(isInside(xCoord + i, yCoord) && checkPositionHorizontal(yCoord, xCoord + i)))
                    return false;
            }
        }
        else{
            for(int i = 0; i < shipLives; i++){
                if(!(isInside(xCoord, yCoord + i) && checkPositionVertical(yCoord + i, xCoord)))
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
        return xPosition <= 10 && xPosition >= 1 && yPosition <= 10 && yPosition >= 1;
    }
}
