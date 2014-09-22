package Chess;

public class Board {
	ChessPiece[][] board;

	public Board() {
		board = new ChessPiece[8][8];
	}

	public void placePiece(ChessPiece p) {
		board[p.row][p.col] = p;
	}

	public boolean threatens(ChessPiece a, ChessPiece b) throws Exception {
		if (a == b) {
			return false;
		}
		boolean diag = false;
		diag = Math.abs(a.row - b.row) == Math.abs(a.col - b.col);
		switch (a.ID) {
		case B:
			if (!diag) {
				return false;
			} else {
				return !isBlocked(a, b);
			}
		case G:
			if (Math.abs(a.row - b.row) > 1) {
				return false;
			} else if (Math.abs(a.col - b.col) > 1) {
				return false;
			} else {
				return true;
			}
		case K:
			if (b.col != a.col && a.row != b.row
					&& Math.abs(a.col - b.col) + Math.abs(a.row - b.row) == 3) {
				return true;
			}
			return false;
		case Q:
			if (diag || a.row == b.row || a.col == b.col) {
				return !isBlocked(a, b);
			} else {
				return false;
			}
		case R:
			if (a.row == b.row || a.col == b.col) {
				return !isBlocked(a, b);
			} else {
				return false;
			}
		default:
			throw new Exception("Unsupported piece type");
		}
	}

	public boolean isBlocked(ChessPiece a, ChessPiece b) {
		int dx = a.row - b.row;
		int dy = a.col - b.col;

		int pathLength = Math.max(Math.abs(dx), Math.abs(dy));

		int xIncrement = (dx == 0) ? 0 : dx / Math.abs(dx);
		int yIncrement = (dy == 0) ? 0 : dy / Math.abs(dy);

		for (int i = 1; i < pathLength; i++) {
			if (board[b.row + xIncrement * i][b.col + yIncrement * i] != null) {
				return true;
			}
		}
		return false;
	}
}
