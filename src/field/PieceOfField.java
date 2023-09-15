package field;

import ships.State;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 13:39
 */
public interface PieceOfField {
    char getIcon();
    State shoot();
}
