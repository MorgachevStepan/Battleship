package field;

import ships.State;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 21:45
 */
public class EmptyField implements PieceOfField{
    @Override
    public char getIcon() {
        return ' ';
    }

    @Override
    public State shoot() {
        return null;
    }
}
