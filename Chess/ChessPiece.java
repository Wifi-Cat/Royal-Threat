package Chess;

public class ChessPiece {
	String ID;
	int row;
	int col;
	Board b;

	public ChessPiece(String ID, int row, int col, Board b) {
		this.ID = ID;
		this.row = row;
		this.col = col;
		this.b = b;
	}

	public boolean threatens(ChessPiece a) throws Exception {
		boolean bishopmove = false;
		bishopmove = Math.abs(a.row - row) == Math.abs(a.col - col);
		if (a == this)
			return false;
		if (ID.equals("B")) {
			if (!bishopmove)
				return false;
			return !isblock(a);
		}
		if (ID.equals("Q")) {
			if (bishopmove)
				return !isblock(a);
			if ((a.row - row != 0) && (a.col - col != 0))
				return false;
			return !isblock(a);
		}
		if (ID.equals("G")) {
			if (bishopmove) {
				if (Math.abs(a.row - row) > 1)
					return false;
				return true;
			}
			if (Math.abs(a.row - row) > 1 || Math.abs(a.col - col) > 1)
				return false;
			return true;
		}
		if (ID.equals("R")) {
			if ((a.row - row != 0) && (a.col - col != 0))
				return false;
			return !isblock(a);
		}
		if (ID.equals("K")) {
			if (col != a.col && a.row != row
					&& Math.abs(col - a.col) + Math.abs(row - a.row) == 3)
				return true;
			return false;
		} else
			throw new Exception("WTF");
	}

	public boolean isblock(ChessPiece a) {
		// boolean ascendingrow = false;
		// int rowmove = row - a.row;
		// if (rowmove > 0)
		// ascendingrow = true;
		// boolean ascendingcol = false;
		// int colmove = col - a.col;
		// if (colmove > 0)
		// ascendingcol = true;
		// int ro = row;
		// int co = col;
		// boolean foundblock = false;
		// while (ro != a.row && co != a.col) {
		// if (ascendingrow) {
		// if (ro < a.row)
		// ro++;
		// } else if (ro > a.row)
		// ro--;
		//
		// if (ascendingcol) {
		// if (co < a.col)
		// co++;
		// } else if (co > a.col)
		// co--;
		//
		// if (b.board[ro][co] != null && b.board[ro][co] != a) {
		// foundblock = true;
		// break;
		// }
		// }
		// return foundblock;

		int dx = a.row - row;
		int dy = a.col - col;

		int pathLength = Math.max(dx, dy);

		int xIncrement = (dx == 0) ? 0 : dx / Math.abs(dx);
		int yIncrement = (dy == 0) ? 0 : dy / Math.abs(dy);

		for (int i = 0; i < pathLength; i++) {
			if (b.board[row + xIncrement][col + yIncrement] != null) {
				return false;
			}
		}
		return true;
	}
}
