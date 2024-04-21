import java.util.*;

abstract public class Piece {
    private Color pieceColor;

    private static final HashMap<Character, PieceFactory> pieceTypes = new HashMap<>();
    public static void registerPiece(PieceFactory pf) {
        pieceTypes.put(pf.symbol(), pf);
    }

    public static Piece createPiece(String name) {
        char color = name.charAt(0);
        Color c;
        if (color == 'b') {
            c = Color.BLACK;
        } else if (color == 'w') {
            c = Color.WHITE;
        }
        else {
            throw new RuntimeException();
        }
        char type = name.charAt(1);

        if (!pieceTypes.containsKey(type)) {
            throw new RuntimeException();
        }

        return (pieceTypes.get(type)).create(c);
    }

    public Color color() {
	    return pieceColor;
    }

    public void setPieceColor(Color c) {
        pieceColor = c;
    }

    public static Boolean validCol(char col) {
        return (col >= 'a' && col <= 'h');
    }

    public static Boolean validRow(char row) {
        return (row >= '1' && row <= '8');
    }

    public Boolean validPlacement(Board b, String currLoc) {
        Piece currPiece = b.getPiece(currLoc);
        return (currPiece == null || currPiece.color() != this.color());
    }

    public Boolean checkPieceContinue(Piece currPiece, List<String> allMoves, String currLoc) {
        if (currPiece == null) {
            allMoves.add(currLoc);
            return true;
        } else if (!(currPiece.color() == this.color())) {
            allMoves.add(currLoc);
            return false;
        }
        else {
            return false;
        }
    }

    public void rookCheck(List<String> allMoves, char col, char row, Board b) {
        for (char i = (char) (col + 1); i <= 'h'; i++) {
            String currLoc = String.valueOf(i) + String.valueOf(row);
            Piece currPiece = b.getPiece(currLoc);

            if(!checkPieceContinue(currPiece, allMoves, currLoc)) {
                break;
            }
        }
        for (char i = (char) (col - 1); i >= 'a'; i--) {
            String currLoc = String.valueOf(i) + String.valueOf(row);
            Piece currPiece = b.getPiece(currLoc);

            if(!checkPieceContinue(currPiece, allMoves, currLoc)) {
                break;
            }
        }
        for (char j = (char) (row + 1); j <= '8'; j++) {
            String currLoc = String.valueOf(col) + String.valueOf(j);
            Piece currPiece = b.getPiece(currLoc);

            if(!checkPieceContinue(currPiece, allMoves, currLoc)) {
                break;
            }
        }
        for (char j = (char) (row - 1); j >= '1'; j--) {
            String currLoc = String.valueOf(col) + String.valueOf(j);
            Piece currPiece = b.getPiece(currLoc);

            if(!checkPieceContinue(currPiece, allMoves, currLoc)) {
                break;
            }
        }
    }

    public void bishopCheck(List<String> allMoves, char col, char row, Board b) {
        char currRow = (char) (row + 1);
        char currCol = (char) (col + 1);
        while (validRow(currRow) && validCol(currCol)) {
            String currLoc = String.valueOf(currCol) + String.valueOf(currRow);
            Piece currPiece = b.getPiece(currLoc);

            if(!checkPieceContinue(currPiece, allMoves, currLoc)) {
                break;
            }

            currRow = (char) (currRow + 1);
            currCol = (char) (currCol + 1);
        }
        currRow = (char) (row + 1);
        currCol = (char) (col - 1);
        while (validRow(currRow) && validCol(currCol)) {
            String currLoc = String.valueOf(currCol) + String.valueOf(currRow);
            Piece currPiece = b.getPiece(currLoc);

            if(!checkPieceContinue(currPiece, allMoves, currLoc)) {
                break;
            }

            currRow = (char) (currRow + 1);
            currCol = (char) (currCol - 1);
        }
        currRow = (char) (row - 1);
        currCol = (char) (col + 1);
        while (validRow(currRow) && validCol(currCol)) {
            String currLoc = String.valueOf(currCol) + String.valueOf(currRow);
            Piece currPiece = b.getPiece(currLoc);

            if(!checkPieceContinue(currPiece, allMoves, currLoc)) {
                break;
            }

            currRow = (char) (currRow - 1);
            currCol = (char) (currCol + 1);
        }
        currRow = (char) (row - 1);
        currCol = (char) (col - 1);
        while (validRow(currRow) && validCol(currCol)) {
            String currLoc = String.valueOf(currCol) + String.valueOf(currRow);
            Piece currPiece = b.getPiece(currLoc);

            if(!checkPieceContinue(currPiece, allMoves, currLoc)) {
                break;
            }

            currRow = (char) (currRow - 1);
            currCol = (char) (currCol - 1);
        }
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}