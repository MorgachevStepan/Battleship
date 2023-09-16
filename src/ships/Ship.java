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

    public void getHit(){
        shipLives--;
    }

    public State getState(){
        if(shipLives == shipLivesTotal)
            return State.NO_HIT;
        else if(shipLives < shipLivesTotal && shipLives > 0)
            return State.HIT;
        else
            return State.DESTROYED;
    }
}
