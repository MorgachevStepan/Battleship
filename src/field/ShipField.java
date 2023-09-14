package field;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 20:13
 */
public class ShipField implements PieceOfField{
    @Override
    public char getIcon() {
        return '@';
    }

    @Override
    public String shoot() {
        return null;
    }
}
