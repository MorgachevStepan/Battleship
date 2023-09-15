package field;

import ships.State;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 13:41
 */
public class WaterField implements PieceOfField{
    private boolean isHitten;

    public WaterField(){
        isHitten = false;
    }

    @Override
    public char getIcon() {
        return isHitten ? '*' : '~';
    }

    @Override
    public State shoot() {
        isHitten = true;
        return State.NO_HIT;
    }
}
