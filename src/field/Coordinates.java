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

    public int getyCord() {
        return yCord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return xCord == that.xCord && yCord == that.yCord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCord, yCord);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "xCord=" + xCord +
                ", yCord=" + yCord +
                '}';
    }
}
