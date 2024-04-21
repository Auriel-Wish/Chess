import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) {
        setPieceColor(c);
    }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.WHITE) {
            return "wr";
        }
        return "br";
    }

    public List<String> moves(Board b, String loc) {
        List<String> allMoves = new ArrayList<>();
        char col = loc.charAt(0);
        char row = loc.charAt(1);

        rookCheck(allMoves, col, row, b);

        allMoves.remove(loc);
        return allMoves;
    }

}