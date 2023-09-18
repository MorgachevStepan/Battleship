package utils;

import Player.Player;
import field.Coordinates;

import static ships.State.*;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 19:59
 */
public class FieldRender {
    private final char[] FIELD_LETTERS = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж' , 'З', 'И', 'К'};
    private final Player player;


    public FieldRender(Player player){
        this.player = player;
    }


    public void render() {
        printLetters();
        System.out.println();
        System.out.println("---------------------------------     ---------------------------------");
        for(int i = 1; i < 11; i++){
            System.out.print(i - 1 + " |");
            for(int j = 1; j < 11; j++)
                System.out.print(player.getField()[i][j].getIcon() + " |");
            System.out.print("     ");
            System.out.print(i - 1 + " |");
            for (int j = 1; j < 11; j++)
                if(!player.isPieceOfFieldIsEmpty(new Coordinates(j, i))) {
                    switch (player.getState(new Coordinates(j, i))) {
                        case DESTROYED, HIT -> System.out.print("* |");
                        case NO_HIT -> System.out.print("M |");
                    }
                }
                else
                    System.out.print("~ |");
            System.out.println();
            System.out.println("---------------------------------     ---------------------------------");
        }
    }

    private void printLetters(){
        for(int i = 0; i < 2; i++) {
            System.out.print("  |");
            for (Character character : FIELD_LETTERS)
                System.out.print(character.toString() + " |");
            System.out.print("     ");
        }
    }

}
