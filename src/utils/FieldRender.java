package utils;

import field.PieceOfField;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 19:59
 */
public class FieldRender {
    private final char[] FIELD_LETTERS = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж' , 'З', 'И', 'К'};
    private PieceOfField[][] field;

    public FieldRender(PieceOfField[][] field){
        this.field = field;
    }


    public void render() {
        System.out.print("  |");
        for (Character character: FIELD_LETTERS)
            System.out.print(character.toString() + " |");
        System.out.println();
        System.out.println("---------------------------------");
        for(int i = 1; i < 11; i++){
            System.out.print(i - 1 + " |");
            for(int j = 1; j < 11; j++)
                System.out.print(field[i][j].getIcon() + " |");
            System.out.println();
            System.out.println("---------------------------------");
        }
    }
}
