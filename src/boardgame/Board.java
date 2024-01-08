package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1) {
            throw new BoardException("Error when creating Board: It needs at least 1 row and 1 column.");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column)) {
            throw new BoardException("Error: Position does not exists!");
        }
        return pieces[row][column];
    }

    public Piece piece(Position p) {
        if(!positionExists(p)) {
            throw new BoardException("Error: Position does not exist!");
        }
        return pieces[p.getRow()][p.getColumn()];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void placePiece(Piece piece, Position p) {
        if(thereIsAPiece(p)) {
            throw new BoardException("Error: Position" + p + " already has a Piece");
        }
        pieces[p.getRow()][p.getColumn()] = piece;
        piece.position = p;
    }

    public boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position p) {
        return positionExists(p.getRow(), p.getColumn());
    }

    public boolean thereIsAPiece(Position p) {
        if(!positionExists(p)) {
            throw new BoardException("Error: Position does not exists!");
        }
        return piece(p) != null;
    }
}
