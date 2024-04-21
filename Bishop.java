import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) {
        setPieceColor(c);
    }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.WHITE) {
            return "wb";
        }
        return "bb";
    }

    public List<String> moves(Board b, String loc) {
        List<String> allMoves = new ArrayList<>();
        char col = loc.charAt(0);
        char row = loc.charAt(1);

        bishopCheck(allMoves, col, row, b);
        allMoves.remove(loc);

        return allMoves;
    }

}