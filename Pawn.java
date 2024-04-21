import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) {
        setPieceColor(c);
    }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.WHITE) {
            return "wp";
        }
        return "bp";
    }

    public List<String> moves(Board b, String loc) {
        List<String> allMoves = new ArrayList<>();
        char col = loc.charAt(0);
        char row = loc.charAt(1);

        if (this.color() == Color.WHITE) {
            if (row == 8) {
                return allMoves;
            }

            String currLoc = String.valueOf(col) + String.valueOf((char) (row + 1));
            if (validCol(col) && validRow((char) (row + 1)) && b.getPiece(currLoc) == null) {
                allMoves.add(currLoc);
                if (row == '2') {
                    currLoc = String.valueOf(col) + String.valueOf((char) (row + 2));
                    if (b.getPiece(currLoc) == null) {
                        allMoves.add(currLoc);
                    }
                }
            }
            currLoc = String.valueOf((char) (col + 1)) + String.valueOf((char) (row + 1));
            if (validCol((char) (col + 1)) && validRow((char) (row + 1)) && (b.getPiece(currLoc) != null) && (b.getPiece(currLoc).color() != this.color())) {
                allMoves.add(currLoc);
            }
            currLoc = String.valueOf((char) (col - 1)) + String.valueOf((char) (row + 1));
            if (validCol((char) (col - 1)) && validRow((char) (row + 1)) && (b.getPiece(currLoc) != null) && (b.getPiece(currLoc).color() != this.color())) {
                allMoves.add(currLoc);
            }
        }
        else {
            if (row == 1) {
                return allMoves;
            }

            String currLoc = String.valueOf(col) + String.valueOf((char) (row - 1));
            if (validCol(col) && validRow((char) (row - 1)) && b.getPiece(currLoc) == null) {
                allMoves.add(currLoc);
                if (row == '7') {
                    currLoc = String.valueOf(col) + String.valueOf((char) (row - 2));
                    if (b.getPiece(currLoc) == null) {
                        allMoves.add(currLoc);
                    }
                }
            }
            currLoc = String.valueOf((char) (col + 1)) + String.valueOf((char) (row - 1));
            if (validCol((char) (col + 1)) && validRow((char) (row - 1)) && (b.getPiece(currLoc) != null) && (b.getPiece(currLoc).color() != this.color())) {
                allMoves.add(currLoc);
            }
            currLoc = String.valueOf((char) (col - 1)) + String.valueOf((char) (row - 1));
            if (validCol((char) (col - 1)) && validRow((char) (row - 1)) && (b.getPiece(currLoc) != null) && (b.getPiece(currLoc).color() != this.color())) {
                allMoves.add(currLoc);
            }
        }

        allMoves.remove(loc);
        return allMoves;
    }
}