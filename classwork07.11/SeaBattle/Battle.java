import java.util.Scanner;


public class Battle {
	public SeaBattleField seaBattleField;

	public Battle() {
		System.out.println("Battle");
		seaBattleField = new SeaBattleField(); // создали поле с кораблями
		Scanner sc = new Scanner(System.in);
		seaBattleField.showField();

		// System.out.println(seaBattleField.ships);
		// план:
		// 1.Бесконечный цикл
		// 2. Считываем ввод пользователя (x, y) - точка, в которую стреляем
		// 3. Проверяем состояние этой точки, если пустая(0), меняем на промах - 4
		// если уже били по этой точке, т.е состояние != 0 или 3, то просим другие координаты
		// если корабль(3), меняем на ранен, если все клетки ранен, то меняем все на подбит(2)
		// 4. Проверяем, есть ли еще 3 (т.е целые части кораблей; 20 подбитых клеток - 10 подбитых кораблей) и прерываем игру
		while (true) {
			System.out.println("Введите координату x, куда стреляем: ");
			byte x = (byte) sc.nextInt();
			System.out.println("Введите координату y, куда стреляем: ");
			byte y = (byte) sc.nextInt();
			if (seaBattleField.battleField[y - 1][x - 1] == 0) {
				seaBattleField.battleField[y - 1][x - 1] = 4; // промахнулись
				System.out.println("Промах! Повезёт в следующий раз!");
				seaBattleField.showField();
			} else if (seaBattleField.battleField[y - 1][x - 1] == 3) {
				seaBattleField.battleField[y - 1][x - 1] = 1;
				for (int i = 0; i < 10; ++i) {
					if (seaBattleField.ships[i].pointIncluded((byte) (y - 1),(byte) (x - 1))) {
						// здесь нужен сеттер для состояния корабля
						byte state = seaBattleField.ships[i].setState((byte)(y - 1), (byte)(x - 1));
						if (state == 2) {
							for (int yy = seaBattleField.ships[i].yStart; yy <= seaBattleField.ships[i].yEnd; ++yy) {
								for (int xx = seaBattleField.ships[i].xStart; xx <= seaBattleField.ships[i].xEnd; ++xx) {
									seaBattleField.battleField[yy][xx] = 2;
								}
							}
							System.out.println("Потопили корабль!");
						} else {
							seaBattleField.battleField[y - 1][x - 1] = state;
						}
						break; // нашли наш корабль, смысла проверять дальше нет
					}
				}
				seaBattleField.showField();
				if (seaBattleField.isWin()) { // победа при подбитии всех кораблей
					System.out.println("Победа! Подбиты все корабли!");
					break;
				}
			} else {
				System.out.println("Сюда уже стреляли! Выберите другую точку:");
				seaBattleField.showField();
				continue;
			}
		}
	}
}