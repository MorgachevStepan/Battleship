package field;

/**
 * @author Stepan Morgachev
 * @date 13.09.2023 14:30
 */
public class Field {
    private static final int FIELD_SIZE = 12;

    private final PieceOfField[][] field;

    public Field() {
        field = new PieceOfField[FIELD_SIZE][FIELD_SIZE];

        for(int i = 0; i < FIELD_SIZE; i++){
            for(int j = 0; j < FIELD_SIZE; j++){
                field[i][j] = new EmptyField();
            }
        }

        for(int i = 1; i < FIELD_SIZE - 1; i++){
            for(int j = 1; j < FIELD_SIZE - 1; j++){
                field[i][j] = new WaterField();
            }
        }
    }

    public PieceOfField[][] getField() {
        return field;
    }
}
