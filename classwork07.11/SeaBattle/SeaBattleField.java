import java.util.Random;


public class SeaBattleField {
	public Ship[] ships;
	public byte[][] battleField; // 0-пустая ячейка, 1-ранен, 2-подбит, 3-корабль, 4-промах

	public SeaBattleField() {
		System.out.println("SeaBattleField");
		createField();
	}

	private void createField() {
		ships = new Ship[10];
		battleField = new byte[10][10];
		byte count = 0;

		Random random = new Random();
		// int i = random.nextInt(10);

		// System.out.println(i);
		// создать корбали, назначая их расположение (ориентация, координаты носа) 
		// случайным образом (главное не должно быть пересечений)
		// вывести игровое поле в консоль
		for (byte size = 1; size <= 4; ++size) {
			for (int i = 0; i <= 4 - size; ++i) {
				while (true) {
					byte xt = (byte) random.nextInt(10);
					byte yt = (byte) random.nextInt(10);
					byte orient = (byte) random.nextInt(2);
					if (checkField(size, xt, yt, orient)) {
						if (orient == 0) {
							ships[count++] = new Ship(size, xt, yt, xt, (byte) (yt + size - 1));
							// System.out.println(ships[count-1].getxStart());
							for (byte j = 0; j < size; ++j) {
								battleField[yt+j][xt] = 3;
							}
						} else {
							ships[count++] = new Ship(size, xt, yt, (byte) (xt + size - 1), yt);
							for (byte j = 0; j < size; ++j) {
								battleField[yt][xt + j] = 3;
							}
						}
						break;
					}
				}
			}
		}	
	}
	/* 0 вертикально
	   1 горизонтально
	*/
	private boolean checkField(int size, int x, int y, int orientation) {
		if (orientation == 0) {
			if (y + size > 10) return false;
			for (int i = 0; i < size; ++i) {
				if (battleField[y + i][x] == 3) return false;
			}
		}
		else {
			if (x + size > 10) return false;
			for (int i = 0; i < size; ++i) {
				if (battleField[y][x+i] == 3) return false;
			}
		}
		return true;
	}

	public void showField() {
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				System.out.print(battleField[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isWin() {
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				if (battleField[i][j] == 3) {
					return false;
				}
			}
		}
		return true;
	}
}