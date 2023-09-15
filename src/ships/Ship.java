package ships;

import field.Coordinates;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:16
 */
public abstract class Ship {
    private Coordinates position;
    private Orientation orientation;
    private int shipLivesTotal;
    private int shipLives;

    public Ship(Coordinates position, Orientation orientation, int shipLivesTotal) {
        this.position = position;
        this.orientation = orientation;
        this.shipLivesTotal = shipLivesTotal;
        shipLives = shipLivesTotal;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getShipLives() {
        return shipLives;
    }

    public void setShipLives(int shipLives) {
        this.shipLives = shipLives;
    }

    public void getHit(){
        if(shipLives > 0){
            System.out.println("Вы попали по кораблю!!!");
            shipLives--;
        }
        else{
            System.out.println("Вы промахнулись(");
        }
    }

    public String getState(){
        if(shipLives == shipLivesTotal)
            return "No hit";
        else if(shipLives < shipLivesTotal && shipLives > 0)
            return "Hit";
        else
            return "Destroyed";
    }

    @Override
    public String toString() {
        return "Ship{" +
                "position=" + position +
                ", orientation=" + orientation +
                ", shipLivesTotal=" + shipLivesTotal +
                ", shipLives=" + shipLives +
                '}';
    }
}
