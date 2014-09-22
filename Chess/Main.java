package Chess;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int configNum = sc.nextInt();
		int numPieces;
		int row;
		int col;
		String ID;
		for (int i = 0; i < configNum; i++) {
			Board board = new Board();
			numPieces = sc.nextInt();
			ChessPiece[] pieces = new ChessPiece[numPieces];
			for (int j = 0; j < numPieces; j++) {
				ID = sc.next();
				PieceType EnumID = PieceType.getEnumFromString(ID);
				row = sc.nextInt();
				col = sc.nextInt();
				ChessPiece p = new ChessPiece(EnumID, row - 1, col - 1);
				board.placePiece(p);
				pieces[j] = p;
			}
			// now board populated
			int numthreat = 0;
			for (int k = 0; k < pieces.length; k++) {
				for (int z = 0; z < pieces.length; z++) {
					if (board.threatens(pieces[k], pieces[z]))
						numthreat++;
				}
			}
			System.out.println("Configuration " + (i + 1) + ": " + numthreat
					+ " PIECES THREATENED");
		}
		System.out.println("END OF OUTPUT");
		sc.close();
	}

}
