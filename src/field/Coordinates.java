package field;

import java.util.Objects;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 15:15
 */
public class Coordinates {
    private int xCord;
    private int yCord;

    public Coordinates(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }
}
