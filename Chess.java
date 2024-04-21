import java.io.*;
import java.util.*;

public class Chess {
	public static void compareMoves(List<String> moves, List<String> realMoves) {
		Collections.sort(moves);
		Collections.sort(realMoves);

		System.out.println("moves: " + moves);
		System.out.println("realMoves: " + realMoves);
		for (String move : moves) {
			assert(realMoves.remove(move));
		}
		assert(realMoves.isEmpty());
	}
	public static void Bishop1() {
		System.out.println("\nBishop1");
		String testPieceLoc = "c3";
		Board.theBoard().addPiece(Piece.createPiece("wb"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("wn"), "b2");
		Board.theBoard().addPiece(Piece.createPiece("bq"), "g7");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("b4", "a5", "d2", "e1", "d4", "e5", "f6", "g7"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Bishop2() {
		System.out.println("\nBishop2");
		String testPieceLoc = "e7";
		Board.theBoard().addPiece(Piece.createPiece("bb"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("wp"), "f6");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "f8");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "d8");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "d6");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("f6"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void King1() {
		System.out.println("\nKing1");
		String testPieceLoc = "f5";

		List<String> moves = (Piece.createPiece("bk").moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("e6", "f6", "g6", "e5", "g5", "e4", "f4", "g4"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void King2() {
		System.out.println("\nKing1");
		String testPieceLoc = "f5";

		Board.theBoard().addPiece(Piece.createPiece("bk"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("wk"), "f6");
		Board.theBoard().addPiece(Piece.createPiece("br"), "c4");
		Board.theBoard().addPiece(Piece.createPiece("bn"), "e6");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("e4", "e5", "f4", "f6", "g4", "g5", "g6"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void King3() {
		System.out.println("\nKing2");
		String testPieceLoc = "h1";
		Board.theBoard().addPiece(Piece.createPiece("wk"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("wp"), "g2");
		Board.theBoard().addPiece(Piece.createPiece("wp"), "g1");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "h2");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("h2"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Knight1() {
		System.out.println("\nKnight1");
		String testPieceLoc = "e5";
		Board.theBoard().addPiece(Piece.createPiece("wn"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("f7", "d7", "c6", "c4", "d3", "f3", "g4", "g6"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Knight2() {
		System.out.println("\nKnight2");
		String testPieceLoc = "a6";
		Board.theBoard().addPiece(Piece.createPiece("wn"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("wp"), "a5");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "b5");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "b6");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "b7");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "a7");
		Board.theBoard().addPiece(Piece.createPiece("wb"), "b8");
		Board.theBoard().addPiece(Piece.createPiece("bk"), "c5");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("b4", "c5", "c7"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn1() {
		System.out.println("\nPawn1");
		String testPieceLoc = "d3";
		Board.theBoard().addPiece(Piece.createPiece("wp"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("d4"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn2() {
		System.out.println("\nPawn2");
		String testPieceLoc = "g4";
		Board.theBoard().addPiece(Piece.createPiece("bp"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("g3"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn3() {
		System.out.println("\nPawn3");
		String testPieceLoc = "e2";
		Board.theBoard().addPiece(Piece.createPiece("wp"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("e3", "e4"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn4() {
		System.out.println("\nPawn4");
		String testPieceLoc = "a7";
		Board.theBoard().addPiece(Piece.createPiece("bp"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("a6", "a5"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn5() {
		System.out.println("\nPawn5");
		String testPieceLoc = "f2";
		Board.theBoard().addPiece(Piece.createPiece("wp"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("bn"), "g3");
		Board.theBoard().addPiece(Piece.createPiece("wr"), "f3");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("g3"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn6() {
		System.out.println("\nPawn6");
		String testPieceLoc = "h2";
		Board.theBoard().addPiece(Piece.createPiece("wp"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("bk"), "h4");
		Board.theBoard().addPiece(Piece.createPiece("bb"), "g3");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("g3", "h3"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn7() {
		System.out.println("\nPawn7");
		String testPieceLoc = "h8";
		Board.theBoard().addPiece(Piece.createPiece("wp"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList());
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn8() {
		System.out.println("\nPawn8");
		String testPieceLoc = "a7";
		Board.theBoard().addPiece(Piece.createPiece("bp"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("wb"), "b6");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("b6", "a6", "a5"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn9() {
		System.out.println("\nPawn9");
		String testPieceLoc = "e7";
		Board.theBoard().addPiece(Piece.createPiece("bp"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("wr"), "d6");
		Board.theBoard().addPiece(Piece.createPiece("wr"), "e6");
		Board.theBoard().addPiece(Piece.createPiece("wr"), "f6");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("d6", "f6"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Pawn10() {
		System.out.println("\nPawn10");
		String testPieceLoc = "c1";
		Board.theBoard().addPiece(Piece.createPiece("bp"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList());
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Rook1() {
		System.out.println("\nRook1");
		String testPieceLoc = "e5";
		Board.theBoard().addPiece(Piece.createPiece("br"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("e6", "e7", "e8", "a5", "b5", "c5", "d5", "f5", "g5", "h5", "e1", "e2", "e3", "e4"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Rook2() {
		System.out.println("\nRook2");
		String testPieceLoc = "b7";
		Board.theBoard().addPiece(Piece.createPiece("wr"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("bq"), "b5");
		Board.theBoard().addPiece(Piece.createPiece("wk"), "d7");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("b8", "a7", "b6", "b5", "c7"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Queen1() {
		System.out.println("\nQueen1");
		String testPieceLoc = "e5";
		Board.theBoard().addPiece(Piece.createPiece("bq"), testPieceLoc);

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("e6", "e7", "e8", "a5", "b5", "c5", "d5", "f5", "g5", "h5", "e1", "e2", "e3", "e4", "b8", "c7", "d6", "f4", "g3", "h2", "f6", "g7", "h8", "d4", "c3", "b2", "a1"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

	public static void Queen2() {
		System.out.println("\nQueen2");
		String testPieceLoc = "c2";
		Board.theBoard().addPiece(Piece.createPiece("wq"), testPieceLoc);
		Board.theBoard().addPiece(Piece.createPiece("bn"), "c4");
		Board.theBoard().addPiece(Piece.createPiece("bp"), "f2");
		Board.theBoard().addPiece(Piece.createPiece("wr"), "e4");

		List<String> moves = (Board.theBoard().getPiece(testPieceLoc).moves(Board.theBoard(), testPieceLoc));
		List<String> realMoves = new ArrayList(Arrays.asList("a2", "b2", "b1", "c1", "c3", "c4", "d3", "d2", "e2", "f2", "b3", "a4", "d1"));
		compareMoves(moves, realMoves);

		Board.theBoard().clear();
	}

    public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Chess layout moves");
		}

		Piece.registerPiece(new KingFactory());
		Piece.registerPiece(new QueenFactory());
		Piece.registerPiece(new KnightFactory());
		Piece.registerPiece(new BishopFactory());
		Piece.registerPiece(new RookFactory());
		Piece.registerPiece(new PawnFactory());

		Bishop1();
		Bishop2();
		King1();
		King2();
		King3();
		Knight1();
		Knight2();
		Pawn1();
		Pawn2();
		Pawn3();
		Pawn4();
		Pawn5();
		Pawn6();
		Pawn7();
		Pawn8();
		Pawn9();
		Pawn10();
		Queen1();
		Queen2();
		Rook1();
		Rook2();

		LinkedList<String> layout = getLayout(args[0]);
		LinkedList<String> moves = getMoves(args[1]);

		for (String place : layout) {
			String piece = place.substring(place.length() - 2);
			String loc = place.substring(0, 2);
			Board.theBoard().addPiece(Piece.createPiece(piece), loc);
		}

		for (String move : moves) {
			String from = move.substring(0, 2);
			String to = move.substring(move.length() - 2);
			Board.theBoard().movePiece(from, to);
		}
//		Board.theBoard().registerListener(new Logger());
		// args[0] is the layout file name
		// args[1] is the moves file name
		// Put your code to read the layout file and moves files
		// here.

		// Leave the following code at the end of the simulation:
		System.out.println("Final board:");
		Board.theBoard().iterate(new BoardPrinter());
    }

	private static LinkedList<String> getLayout(String fName) {
		try {
			Scanner scanner = new Scanner(new File(fName));
			LinkedList<String> layout = new LinkedList<>();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.charAt(0) == '#') {
					continue;
				}
				if (!validLayoutLine(line)) {
					throw new RuntimeException("Invalid Layout Line");
				}
				layout.add(line);
			}

			System.out.println(layout);

			return layout;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Boolean validLayoutLine(String line) {
		if (line.length() != 5) return false;
		if (line.charAt(0) < 'a' || line.charAt(0) > 'h') return false;
		if (line.charAt(1) < '1' || line.charAt(1) > '8') return false;
		if (line.charAt(2) != '=') return false;
		if (line.charAt(3) != 'w' && line.charAt(3) != 'b') return false;
		char[] pieceAbr = {'k', 'q', 'n', 'b', 'r', 'p'};
		Boolean isPiece = false;
		for (char abrev : pieceAbr) {
			if (abrev == line.charAt(4)) {
				isPiece = true;
				break;
			}
		}

		return isPiece;
	}

	private static LinkedList<String> getMoves(String fName) {
		try {
			Scanner scanner = new Scanner(new File(fName));
			LinkedList<String> moves = new LinkedList<>();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.charAt(0) == '#') {
					continue;
				}
				if (!validMoveLine(line)) {
					throw new RuntimeException("Invalid Move Line");
				}
				moves.add(line);
			}

			System.out.println(moves);

			return moves;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Boolean validMoveLine(String line) {
		if (line.length() != 5) return false;
		if ((line.charAt(0) < 'a' || line.charAt(0) > 'h') || (line.charAt(3) < 'a' || line.charAt(3) > 'h')) {
			return false;
		}
		if ((line.charAt(1) < '1' || line.charAt(1) > '8') || (line.charAt(4) < '1' || line.charAt(4) > '8')) {
			return false;
		}
		if (line.charAt(2) != '-') return false;

		return true;
	}
}