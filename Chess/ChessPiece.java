package Chess;

public class ChessPiece {
	PieceType ID;
	boolean threatened;
	int row;
	int col;

	public ChessPiece(PieceType ID, int row, int col) {
		this.ID = ID;
		this.row = row;
		this.col = col;
		this.threatened = false;
	}

	public boolean prevThreatened() {
		return threatened;
	}

	public void nowThreatened() {
		this.threatened = true;
	}

	@Override
	public String toString() {
		return ID.toString();
	}
}
