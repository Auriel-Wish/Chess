import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) {
        setPieceColor(c);
    }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.WHITE) {
            return "wn";
        }
        return "bn";
    }

    private class nMoves {
        int row;
        int col;
        nMoves(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<String> moves(Board b, String loc) {
        List<String> allMoves = new ArrayList<>();
        char col = loc.charAt(0);
        char row = loc.charAt(1);

        List<nMoves> moveCombos = new ArrayList<>();
        moveCombos.add(new nMoves(2, 1));
        moveCombos.add(new nMoves(2, -1));
        moveCombos.add(new nMoves(-2, 1));
        moveCombos.add(new nMoves(-2, -1));
        moveCombos.add(new nMoves(1, 2));
        moveCombos.add(new nMoves(-1, 2));
        moveCombos.add(new nMoves(1, -2));
        moveCombos.add(new nMoves(-1, -2));


        for (int i = 0; i < moveCombos.size(); i++) {
            String currLoc = String.valueOf((char) (col + moveCombos.get(i).col)) + String.valueOf((char) (row + moveCombos.get(i).row));
            if ((validCol((char) (col + moveCombos.get(i).col))) && (validRow((char) (row + moveCombos.get(i).row))) && (validPlacement(b, currLoc))) {
                allMoves.add(currLoc);
            }
        }

        allMoves.remove(loc);
        return allMoves;
    }

}