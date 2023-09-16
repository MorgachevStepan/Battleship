package utils;

import Player.Player;
import field.Coordinates;
import ships.State;

import java.util.Scanner;

/**
 * @author Stepan Morgachev
 * @date 15.09.2023 14:50
 */
public class Controller {
    private Player shooter;
    private Player defender;
    private FieldRender fieldRender;
    private Scanner scanner;

    public Controller(Player shooter, Player defender){
        this.shooter = shooter;
        this.defender = defender;
        fieldRender = new FieldRender(shooter);
        scanner = new Scanner(System.in);
    }

    public State fire(){
        System.out.println("Введите координаты для выстрела");
        Coordinates coordinates;
        do{
            int yCoord = scanner.nextInt() + 1;
            int xCoord = scanner.nextInt() + 1;
            coordinates = new Coordinates(xCoord, yCoord);
        }while (!validPosition(coordinates));

        State state = defender.getPieceOfField(coordinates.getxCord(), coordinates.getyCord()).shoot();
        State resultState = null;

        shooter.getPlayerTurns().put(coordinates, state);

        switch (state){
            case NO_HIT -> resultState = State.NO_HIT;
            case HIT -> {
                resultState = State.HIT;
                defender.decrementLives();
            }
            case DESTROYED -> {
                resultState = State.DESTROYED;
                defender.decrementLives();
            }
        }

        fieldRender.render();

        return resultState;
    }

    private boolean validPosition(Coordinates coordinates) {
        int xCoord = coordinates.getxCord();
        int yCoord = coordinates.getyCord();
        return xCoord <= 10 && xCoord >= 1 && yCoord <= 10 && yCoord >= 1
                && defender.getPieceOfField(xCoord, yCoord).getIcon() != '*'
                && defender.getPieceOfField(xCoord, yCoord).getIcon() != 'M';
    }

    public void render(){
        fieldRender.render();
    }
}
