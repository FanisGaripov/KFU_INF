public class ChessDesk {
	private Figure[][] desk = new Figure[8][8];

	public ChessDesk() {
		// расстановка фигур
		createDesk();

	}

	// расстановка фигур
	public void createDesk() {
		// раставили белые пешки
		for (int i = 0; i < 8; ++i) {
			Pawn pawn = new Pawn(1, i, "White");
			desk[1][i] = pawn;
		}
		// раставили черные пешки
		for (int i = 0; i < 8; ++i) {
			Pawn pawn = new Pawn(6, i, "Black");
			desk[6][i] = pawn;
		}
		// ладья
		desk[0][0] = new Rook(0, 0, "White");
		desk[0][7] = new Rook(0, 7, "White");
		desk[7][0] = new Rook(7, 0, "Black");
		desk[7][7] = new Rook(7, 7, "Black");
		// конь
		desk[0][1] = new Knight(0, 1, "White");
		desk[0][7 - 1] = new Knight(0, 7 - 1, "White");
		desk[7][1] = new Knight(7, 1, "Black");
		desk[7][7 - 1] = new Knight(7, 7 - 1, "Black");
		// слон
		desk[0][2] = new Bishop(0, 2, "White");
		desk[0][7 - 2] = new Bishop(0, 7 - 2, "White");
		desk[7][2] = new Bishop(7, 2, "Black");
		desk[7][7 - 2] = new Bishop(7, 7 - 2, "Black");
		// ферзь и король
		desk[0][3] = new Queen(0, 3, "White");
		desk[0][4] = new King(0, 4, "White");
		desk[7][3] = new Queen(7, 3, "Black");
		desk[7][4] = new King(7, 4, "Black");
	}

	/**
	* column 'A' - 'H', 'a' - 'h' 
	* row 1 - 8	
	*/
	public int charToColumn(char column) {
		return switch (column) {
			case 'a', 'A' -> 0;
			case 'b', 'B' -> 1;
			case 'c', 'C' -> 2;
			case 'd', 'D' -> 3;
			case 'e', 'E' -> 4;
			case 'f', 'F' -> 5;
			case 'g', 'G' -> 6;
			case 'h', 'H' -> 7;
			default -> -1;
		};
	}


	public Figure getFigure(char column, int row) {
		int c = charToColumn(column);
		int r = row - 1;
		return desk[r][c];
	}

	public void showDesk() {
		for (int i = 7; i >= 0; --i) {
			for (int j = 0; j < 8; ++j) {
				String c = desk[i][j] == null ? "_" : desk[i][j].getPresent();
				System.out.print(c);
			}
			System.out.println();
		}
	}
	// поменяно, на boolean, чтобы понимать, получилось ли переместить
	public void setPosition(int oldColumn, int oldRow, int column, int row) {
		Figure figure = desk[oldRow][oldColumn];
		desk[oldRow][oldColumn] = null;
		desk[row][column] = figure;
	}
}