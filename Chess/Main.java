package Chess;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner goo = new Scanner(System.in);

		int confignum = goo.nextInt();
		int numpiece;
		int row;
		int col;
		String ID;
		for (int i = 0; i < confignum; i++) {
			numpiece = goo.nextInt();
			Board bo = new Board();
			ChessPiece[] pieces = new ChessPiece[numpiece];
			for (int j = 0; j < numpiece; j++) {
				ID = goo.next();
				row = goo.nextInt();
				col = goo.nextInt();
				ChessPiece curr = new ChessPiece(ID, row, col, bo);
				bo.PlacePiece(curr);
				pieces[j] = curr;
			}// now board populated
			int numthreat = 0;
			for (int k = 0; k < pieces.length; k++) {
				for (int z = 0; z < pieces.length; z++) {
					if (pieces[k].threatens(pieces[z]))
						numthreat++;
				}
			}
			System.out.println("Configuration " + (i + 1) + ": " + numthreat
					+ " PIECES THREATENED");
		}
		System.out.println("END OF OUTPUT");

	}

}
