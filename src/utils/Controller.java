package utils;

import Player.Player;
import field.Coordinates;
import field.Field;
import field.PieceOfField;
import ships.State;

import java.util.Scanner;

/**
 * @author Stepan Morgachev
 * @date 15.09.2023 14:50
 */
public class Controller {
    private Player player;
    private FieldRender fieldRender;
    private Scanner scanner;

    public Controller(Player player){
        this.player = player;
        fieldRender = new FieldRender(player.getField().getField());
        scanner = new Scanner(System.in);
    }

    public void fire(){
        System.out.println("Введите координаты для выстрела");
        Coordinates coordinates;
        do{
            int yCoord = scanner.nextInt() + 1;
            int xCoord = scanner.nextInt() + 1;
            coordinates = new Coordinates(xCoord, yCoord);
        }while (!validPosition(coordinates));

        State state = player.getField().getPieceOfField(coordinates.getxCord(), coordinates.getyCord()).shoot();

        switch (state){
            case NO_HIT -> System.out.println("Вы промахнулись");
            case HIT -> {
                System.out.println("Попали по кораблю");
                player.decrementLives();
            }
            case DESTROYED -> {
                System.out.println("Вы уничтожили корабль");
                player.decrementLives();
            }
        }

        fieldRender.render();
    }

    private boolean validPosition(Coordinates coordinates) {
        int xCoord = coordinates.getxCord();
        int yCoord = coordinates.getyCord();
        if(xCoord > 10 || xCoord < 1 || yCoord > 10 || yCoord < 1
                || player.getField().getPieceOfField(xCoord, yCoord).getIcon() == '*'
                || player.getField().getPieceOfField(xCoord, yCoord).getIcon() == 'M')
            return false;
        else {
            return true;
        }
    }
}
