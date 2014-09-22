package Chess;

public enum PieceType {
	R("R"), G("G"), B("B"), K("K"), Q("Q");

	private PieceType(String s) {
		this.s = s;
	}

	private final String s;

	public static PieceType getEnumFromString(String s) throws Exception {
		for (PieceType p : PieceType.values()) {
			if (p.s.equals(s)) {
				return p;
			}
		}
		throw new Exception("no enum");
	}

	@Override
	public String toString() {
		return this.s;
	}
}
