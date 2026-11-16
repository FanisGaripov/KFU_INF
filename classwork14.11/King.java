public class King extends Figure {
	public King(int column, int row, String color) {
		super(column, row, color);
	}

	@Override // контроль сигнатуры
	public boolean checkPosition(int column, int row) {
		// влево
		if (this.column == column && this.row - row == 1) {
			return true;
		}
		// вправо
		if (this.column == column && row - this.row == 1) {
			return true;
		}
		// вверх
		if (this.row == row && column - this.column == 1) {
			return true;
		}
		// вниз
		if (this.row == row && this.column - column == 1) {
			return true;
		}
		// вправо вверх
		if (column - this.column == 1 && row - this.row == 1) {
			return true;
		}
		// влево вверх
		if (column - this.column == 1 && this.row - row == 1) {
			return true;
		}
		// вправо вниз
		if (this.column - column == 1 && row - this.row == 1) {
			return true;
		}
		// влево вниз
		if (this.column - column == 1 && this.row - row == 1) {
			return true;
		}

		return false;
	}

	@Override
	public String getPresent() {
		return this.color.equals("white") ? String.valueOf('\u2654') : String.valueOf('\u265A');
	}
}