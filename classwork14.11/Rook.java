public class Rook extends Figure {
	public Rook(int column, int row, String color) {
		super(column, row, color);
	}

	@Override // контроль сигнатуры
	public boolean checkPosition(int column, int row) {
		if (this.column == column || this.row == row) {
			return true;
		}
		return false;
	}

	@Override
	public String getPresent() {
		return this.color.equals("white") ? String.valueOf('\u2656') : String.valueOf('\u265C');
	}
}