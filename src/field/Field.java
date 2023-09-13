package field;

import Player.Player;
import utils.Constants;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 14:30
 */
public class Field {
    private char[][] field;
    private Player player;

    public Field(Player player) {
        field = new char[Constants.FIELD_SIZE_VERTICAL][Constants.FIELD_SIZE_HORIZONTAL];
        this.player = player;
    }

    public char[][] getField() {
        return field;
    }
}
