/*
package utils;

import Player.Player;
import field.Field;
import ships.Orientation;

import java.util.Scanner;

*/
/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:44
 *//*

public class GameHelper {
    private Field firstPlayerField;
    private Field secondPlayerField;
    private Scanner scanner;

    public GameHelper(){
        scanner = new Scanner(System.in);
        firstPlayerField = new Field(new Player());
        secondPlayerField = new Field(new Player());
        PrepareToGame(firstPlayerField);
        PrepareToGame(secondPlayerField);
    }

    public void PrepareToGame(Field field){
        for(int i = 4; i > 0; i--){  //TODO чтобы не хардкодить
            for(int j = i; j <= 5 - i; j++){
                System.out.println("Расставляем " + i + " палубный корабль");
                boolean validator = true;
                while(validator){
                    System.out.println("Введите x координату корабля:");
                    int xCord = scanner.nextInt();
                    System.out.println("Введите y координату корабля:");
                    int yCord = scanner.nextInt();
                    System.out.println("Введите ориентацию корабля( 1 - горизонтальная, 2 - вертикальная)");
                    Orientation orientation = null;
                    if(scanner.nextInt() == 1) {
                        orientation = Orientation.HORIZONTAL;
                    }
                    else if (scanner.nextInt() == 2) {
                        orientation = Orientation.VERTICAL;
                    }
                    validator = validateLocation(field, xCord, yCord, orientation, i);
                }
            }
        }
    }

    private boolean validateLocation(Field field, int xCord, int yCord, Orientation orientation, int shipLength) {
        if(orientation == Orientation.HORIZONTAL){
            for(int i = 0; i < shipLength - 1; i++){
                if('X' == field.getField()[yCord][xCord + i]
                || 'X' == field.getField()[yCord - 1][xCord + i]
                || 'X' == field.getField()[yCord + 1][xCord + i]
                || 'X' == field.getField()[yCord][xCord + i + 1]
                || 'X' == field.getField()[yCord][xCord + i - 1]
                || xCord + shipLength > Constants.FIELD_SIZE_HORIZONTAL - 1)
                    return true;
            }
        }
        if(orientation == Orientation.VERTICAL){
            for(int i = 0; i < shipLength - 1; i++){
                if('X' == field.getField()[yCord][xCord + i]
                        || 'X' == field.getField()[yCord - 1][xCord + i]
                        || 'X' == field.getField()[yCord + 1][xCord + i]
                        || 'X' == field.getField()[yCord][xCord + i + 1]
                        || 'X' == field.getField()[yCord][xCord + i - 1]
                        || yCord + shipLength > Constants.FIELD_SIZE_VERTICAL - 1)
                    return true;
            }
        }
        return false;
    }


}
*/
