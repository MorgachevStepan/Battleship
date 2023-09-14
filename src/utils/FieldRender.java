package utils;

import field.PieceOfField;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 19:59
 */
public class FieldRender {
    private PieceOfField[][] field;

    public FieldRender(PieceOfField[][] field){
        this.field = field;
    }


    public void render() {
        for(PieceOfField[] pieceOfFields: field){
            for (PieceOfField pieceOfField: pieceOfFields){
                System.out.print(pieceOfField.getIcon() + " |");
            }
            System.out.println("");
            System.out.println("----------------------------");
        }
    }
}
