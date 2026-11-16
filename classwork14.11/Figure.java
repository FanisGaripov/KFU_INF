public abstract class Figure { // нельзя будет создавать объект класса figure
	/* 0-7 */
	protected int row; // строка
	protected int column; // столбец

	protected String color; // black | white

	public Figure(int row, int column, String color) {
		this.column = column;
		this.row = row;
		this.color = color.toLowerCase();
	}

	public String getPosition() {
		return (char)('A' + column) + String.valueOf(row + 1);
	}

	public abstract boolean checkPosition(int column, int row); // заставляем переопределить метод

	// поменяно, на boolean, чтобы понимать, получилось ли переместить
	public boolean setPosition(int column, int row) {
		if (checkPosition(column, row)) {
			this.column = column;
			this.row = row;
			return true;
		}
		return false;
	}

	public abstract String getPresent();

	public int getColor() {
		return this.color == "black" ? 1 : 0; // 1 - черный, 0 - белый
	}

}