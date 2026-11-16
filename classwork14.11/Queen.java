public class Queen extends Figure {
	public Queen(int column, int row, String color) {
		super(column, row, color);
	}

	@Override // контроль сигнатуры
	public boolean checkPosition(int column, int row) {
		if (Math.abs(column - this.column) == Math.abs(row - this.row)) {
			return true;
		}
		if (this.column == column || this.row == row) {
			return true;
		}
		return false;
	}

	@Override
	public String getPresent() {
		return this.color.equals("white") ? String.valueOf('\u2655') : String.valueOf('\u265B');
	}
}