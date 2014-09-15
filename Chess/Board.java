package Chess;

public class Board {
	ChessPiece[][] board = new ChessPiece[8][8];

	public Board() {

	}

	public void PlacePiece(ChessPiece p) {
		board[p.row][p.col] = p;
	}
}
