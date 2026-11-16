import java.util.Scanner;

public class GamePlay {
	public ChessDesk chessDesk;
	public int whoseMove;
	/*
	TODO:
	1. Добавить проверку, есть ли уже в этой клетке другая фигура
	2. Очерёдность ходов(после белой обязательно ходит черная) +++
	3. Проверка границ поля (нет смысла делать - просто проверка ввода
	от 1 до 8 и от A до H)
	*/

	public GamePlay() {
		chessDesk = new ChessDesk();
		chessDesk.showDesk();
		Scanner sc = new Scanner(System.in);
		whoseMove = 1; // 0 - ход белых, 1 - ход черных
		while (true) {
			System.out.println("Какую фигуру выбираем?");
			System.out.println("Введите букву: (A-H) ");
			char fromColumn = sc.next().charAt(0);
			System.out.println("Введите число: (1-8)");
			int fromRow = sc.nextInt();
			Figure figure = chessDesk.getFigure(fromColumn, fromRow);
			if (!(figure.getColor() == whoseMove)) {
				if (whoseMove == 1) {
					System.out.println("Сейчас ход чёрных!");
				} else {
					System.out.println("Сейчас ход белых!");
				}
				continue;
			}
			System.out.println("Куда ходим?");
			System.out.println("Введите букву: (A-H)");
			int toColumn = chessDesk.charToColumn(sc.next().charAt(0));
			// char toLetter = sc.next().charAt(0);
			System.out.println("Введите число: (1-8)");
			// int toNumber = sc.nextInt();
			int toRow = sc.nextInt() - 1;
			if (figure.setPosition(toColumn, toRow)) {
				chessDesk.setPosition(chessDesk.charToColumn(fromColumn), fromRow - 1, toColumn, toRow);
				whoseMove = whoseMove == 1 ? 0 : 1;
			} else {
				System.out.println("Неправильный ход!");
			}
			chessDesk.showDesk();
		}

	}

}