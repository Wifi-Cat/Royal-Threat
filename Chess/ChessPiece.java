package Chess;

public class ChessPiece {
	PieceType ID;
	int row;
	int col;

	public ChessPiece(PieceType ID, int row, int col) {
		this.ID = ID;
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return ID.toString();
	}
}
