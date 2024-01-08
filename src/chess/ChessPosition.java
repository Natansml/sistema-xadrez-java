package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error: Invalid position!");
        }

        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition formPosition(Position p) {
        return new ChessPosition((char) (p.getColumn() - 'a'), 8 - p.getRow());
    }

    @Override
    public String toString() {
        return "" + this.column + this.row;
    }
}
