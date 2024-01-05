import chess.ChessMatch;

public class App {
    public static void main(String[] args) throws Exception {
        ChessMatch m = new ChessMatch();

        UI.printBoard(m.getPieces());
    }
}
