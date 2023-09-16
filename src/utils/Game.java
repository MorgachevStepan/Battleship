package utils;

import Player.Player;
import ships.Admiral;

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
        firstPlayer = new Player();
        secondPlayer = new Player();
        firstPlayerAdmiral = new Admiral(firstPlayer);
        secondPlayerAdmiral = new Admiral(secondPlayer);
        firstPlayerController = new Controller(firstPlayer, secondPlayer);
        secondPlayerController = new Controller(secondPlayer, firstPlayer);
        playerTurn = true;
        arrangeShips();
        playGame();
    }

    private void playGame() {
        while(firstPlayer.isAlive() && secondPlayer.isAlive()){
            if(playerTurn){
                System.out.println("Ход первого игрока");
                switch (firstPlayerController.fire()){
                    case NO_HIT -> {
                        playerTurn = false;
                        System.out.println("Вы промахнулись");
                    }
                    case DESTROYED -> {
                        System.out.println("Вы уничтожили корабль");
                    }
                    case HIT -> {
                        System.out.println("Вы попали по кораблю");
                    }
                }
            }
            else{
                System.out.println("Ход второго игрока");
                System.out.println("Здоровье первого игрока - " + firstPlayer.getPlayerLives() + "Здоровье второго игрока" + secondPlayer.getPlayerLives());
                switch (secondPlayerController.fire()){
                    case NO_HIT -> {
                        playerTurn = true;
                        System.out.println("Вы промахнулись");
                    }
                    case DESTROYED -> {
                        System.out.println("Вы уничтожили корабль");
                    }
                    case HIT -> {
                        System.out.println("Вы попали по кораблю");
                    }
                }
            }
        }
        if (firstPlayer.isAlive())
            System.out.println("Победил первый игрок");
        else{
            System.out.println("Победил второй игрок");
        }
    }

    private void arrangeShips(){
        System.out.println("Первый игрок расставляет корабли");
        firstPlayerAdmiral.arrangeShips();
        System.out.println("Второй игрок расставляет корабли");
        secondPlayerAdmiral.arrangeShips();
    }
}
