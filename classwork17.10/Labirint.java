import java.util.Scanner;

public class Labirint {
	static byte[][] map = {
		{1, 0, 1, 1, 1},
		{1, 0, 0, 1, 1},
		{1, 1, 0, 1, 1},
		{1, 0, 0, 0, 0},
		{1, 1, 1, 1, 1},
	};
	static int position_column = 1;
	static int position_row = 0;
	static int exit_column = 4;
	static int exit_row = 3;
	// row - строка, column - столбец
	static char[][] status = {
		{'-', '*', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
	};
	// # - мы тут были
	// * - мы теперь здесь
	// "-" - мы тут не были
	// X - нашли стену
	public static void main(String[] args) {
		// 1 - стена
		// 0 - проход
		// up, down, left, right
		showStatus();
		input();
		return;
	}

	public static void showStatus() {
		for (int i = 0; i < status.length; ++i) {
			for (int j = 0; j < status[i].length; ++j) {
				System.out.print(status[i][j]);
			}
			System.out.println();
		}
	}

	static String input() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Введите направление: U, D, L, R");
			String direction = sc.nextLine();
			if (!(direction.equals("U") || direction.equals("D") || direction.equals("L") || direction.equals("R"))) {
				System.out.println("Вы ввели неверный символ. Допустимые символы: U, D, L, R");
			} else {
				return direction;
			}
		}
	}

	static void moves() {
		String direction = input();
		if (direction.equals("U")) {
			if (!(position_row == 0)) {
				if (field[position_row - 1][position_column] == 0) {
					status[position_row][position_column] = '#';
					status[position_row - 1][position_column] = '*';
					position_row--;
				} else {
					status[position_row - 1][position_column] = 'X';
				}
			}
		} else if (direction.equals("D")) {
			if (!(position_row == field.length)) {
				if (field[position_row + 1][position_column] == 0) {
					status[position_row][position_column] = '#';
					status[position_row + 1][position_column] = '*';
					position_row++;
				} else {
					status[position_row + 1][position_column] = 'X';
				}
			}

		} else if (direction.equals("L")) {
			if (!(position_column == 0)) {
				if (field[position_row - 1][position_column] == 0) {
					status[position_row][position_column] = '#';
					status[position_row - 1][position_column] = '*';
					position_row--;
				} else {
					status[position_row - 1][position_column] = 'X';
				}
			}

		} else if (direction.equals("R")) {
			if (!(position_row == 0)) {
				if (field[position_row - 1][position_column] == 0) {
					status[position_row][position_column] = '#';
					status[position_row - 1][position_column] = '*';
					position_row--;
				} else {
					status[position_row - 1][position_column] = 'X';
				}
			}

		} else {
			return direction;
		}
	}
}
// hello 
// hello 
// hello 