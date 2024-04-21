import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) {
        setPieceColor(c);
    }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.WHITE) {
            return "wq";
        }
        return "bq";
    }

    public List<String> moves(Board b, String loc) {
        List<String> allMoves = new ArrayList<>();
        char col = loc.charAt(0);
        char row = loc.charAt(1);

        rookCheck(allMoves, col, row, b);
        bishopCheck(allMoves, col, row, b);

        allMoves.remove(loc);
        return allMoves;
    }

}