import java.util.LinkedList;
import java.util.List;

public class Board {

    private Piece[][] pieces = new Piece[8][8];
    private final List<BoardListener> listeners = new LinkedList<>();

    private static Board theBoard;

    private Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }    
        }
    }
    
    public static Board theBoard() {
        if (theBoard == null) {
            theBoard = new Board();
        }
        return theBoard;
    }

    public int getArrayCol(String loc) {
        char col = loc.charAt(0);
        return (int) (col - 'a');
    }

    public int getArrayRow(String loc) {
        return (int) (loc.charAt(1) - '1');
    }


    public Piece getPiece(String loc) {
        if (isValidLoc(loc)) {
            return pieces[getArrayRow(loc)][getArrayCol(loc)];
        }
        else {
            throw new UnsupportedOperationException();
        }
    }

    private boolean isValidLoc(String loc) {
        return ((loc.charAt(0) >= 'a' && loc.charAt(0) <= 'h') && (loc.charAt(1) >= '1' && loc.charAt(1) <= '8'));
    }

    public void addPiece(Piece p, String loc) {
        if (isValidLoc(loc) && (getPiece(loc) == null)) {
            pieces[getArrayRow(loc)][getArrayCol(loc)] = p;
        }
        else {
            throw new UnsupportedOperationException();
        }
    }

    public void movePiece(String from, String to) {
        List<String> validMoves = pieces[getArrayRow(from)][getArrayCol(from)].moves(theBoard, from);
        if (isValidLoc(from) && isValidLoc(to) && (getPiece(from) != null) && (validMoves.contains(to))) {
            for (BoardListener listener : listeners) {
                listener.onMove(from, to, pieces[getArrayRow(from)][getArrayCol(from)]);
                if (pieces[getArrayRow(to)][getArrayCol(to)] != null) {
                    listener.onCapture(pieces[getArrayRow(from)][getArrayCol(from)], pieces[getArrayRow(to)][getArrayCol(to)]);
                }
            }

            pieces[getArrayRow(to)][getArrayCol(to)] = pieces[getArrayRow(from)][getArrayCol(from)];
            pieces[getArrayRow(from)][getArrayCol(from)] = null;
        }
        else {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }    
        }
    }

    public void registerListener(BoardListener bl) {
        listeners.add(bl);
    }

    public void removeListener(BoardListener bl) {
	    listeners.remove(bl);
    }

    public void removeAllListeners() {
	    listeners.clear();
    }

    public void iterate(BoardInternalIterator bi) {
        for (char j = '1'; j <= '8'; j++) {
            for (char i = 'a'; i <= 'h'; i++) {
                bi.visit(String.valueOf(i) + String.valueOf(j), getPiece(String.valueOf(i) + String.valueOf(j)));
            }
        }
    }
}