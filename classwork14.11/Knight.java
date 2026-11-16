import java.lang.Math;


public class Knight extends Figure {
	public Knight(int column, int row, String color) {
		super(column, row, color);
	}

	@Override // контроль сигнатуры
	public boolean checkPosition(int column, int row) {
		if (Math.abs(column - this.column) == 2 && Math.abs(row - this.row) == 1) {
			return true;
		}
		if (Math.abs(column - this.column) == 1 && Math.abs(row - this.row) == 2) {
			return true;
		}
		return false;
	}

	@Override
	public String getPresent() {
		return this.color.equals("white") ? String.valueOf('\u2658') : String.valueOf('\u265E');
	}
}