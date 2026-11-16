import java.lang.Math;


public class Bishop extends Figure {
	public Bishop(int column, int row, String color) {
		super(column, row, color);
	}

	@Override // контроль сигнатуры
	public boolean checkPosition(int column, int row) {
		if (Math.abs(column - this.column) == Math.abs(row - this.row)) {
			return true;
		}
		return false;
	}

	@Override
	public String getPresent() {
		return this.color.equals("white") ? String.valueOf('\u2657') : String.valueOf('\u265D');
	}
}