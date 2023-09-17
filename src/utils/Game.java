package utils;

import Player.Player;

import java.util.Scanner;

/**
 * @author Stepan Morgachev
 * @date 16.09.2023 14:08
 */
public class Game {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final Admiral firstPlayerAdmiral;
    private final Admiral secondPlayerAdmiral;
    private final Controller firstPlayerController;
    private final Controller secondPlayerController;
    private boolean playerTurn; //true - ходит первый игрок, false - второй игрок

    public Game(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя первого игрока");
        firstPlayer = new Player(scanner.nextLine());
        System.out.println("Введите имя второго игрока");
        secondPlayer = new Player(scanner.nextLine());
        firstPlayerAdmiral = new Admiral(firstPlayer);
        secondPlayerAdmiral = new Admiral(secondPlayer);
        firstPlayerController = new Controller(firstPlayer, secondPlayer);
        secondPlayerController = new Controller(secondPlayer, firstPlayer);
        playerTurn = true;
        arrangeShips();
    }

    public void playGame() {
        while(firstPlayer.isAlive() && secondPlayer.isAlive()){
            if(playerTurn){
                System.out.printf("Ходит %s \n", firstPlayer.getPlayerName());
                switch (firstPlayerController.fire()){
                    case NO_HIT -> {
                        playerTurn = false;
                        secondPlayerController.render();
                        System.out.println("Вы промахнулись");
                    }
                    case DESTROYED -> System.out.println("Вы уничтожили корабль");
                    case HIT -> System.out.println("Вы попали по кораблю");
                }
            }
            else{
                System.out.printf("Ход %s \n", firstPlayer.getPlayerName());
                switch (secondPlayerController.fire()){
                    case NO_HIT -> {
                        playerTurn = true;
                        firstPlayerController.render();
                        System.out.println("Вы промахнулись");
                    }
                    case DESTROYED -> System.out.println("Вы уничтожили корабль");
                    case HIT -> System.out.println("Вы попали по кораблю");
                }
            }
        }
        if (firstPlayer.isAlive())
            System.out.printf("Победил %s \n", firstPlayer.getPlayerName());
        else{
            System.out.printf("Победил %s \n", secondPlayer.getPlayerName());
        }
    }

    private void arrangeShips(){
        firstPlayerController.render();
        System.out.printf("%s расставляет корабли \n", firstPlayer.getPlayerName());
        firstPlayerAdmiral.arrangeShips();
        secondPlayerController.render();
        System.out.printf("%s расставляет корабли \n", secondPlayer.getPlayerName());
        secondPlayerAdmiral.arrangeShips();
        firstPlayerController.render();
    }
}
