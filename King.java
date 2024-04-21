import java.util.*;

public class King extends Piece {
    public King(Color c) {
        setPieceColor(c);
    }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.WHITE) {
            return "wk";
        }
        return "bk";
    }

    public List<String> moves(Board b, String loc) {
        List<String> allMoves = new ArrayList<>();
        char col = loc.charAt(0);
        char row = loc.charAt(1);

        for (char i = (char) (col - 1); i <= col + 1; i++) {
            if (!validCol(i)) {
                continue;
            }
            for (char j = (char) (row - 1); j <= row + 1; j++) {
                if (!validRow(j)) {
                    continue;
                }
                String currLoc = String.valueOf(i) + String.valueOf(j);

                if (validPlacement(b, currLoc)) {
                    allMoves.add(currLoc);
                }
            }
        }

        allMoves.remove(loc);
        return allMoves;
    }

}