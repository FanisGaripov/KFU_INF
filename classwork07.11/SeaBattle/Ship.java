public class Ship {
	private byte size;
	/*
		система координат: 0-9 (X), 0-9 (Y) 
	*/
	public byte xStart;
	public byte yStart;
	public byte xEnd;
	public byte yEnd;
	// 0 - целый, 1 - ранен, 2-подбит
	// public byte state;
	private byte[] statePart;

	public Ship(byte size, byte xStart, byte yStart, byte xEnd, byte yEnd) {
		this.size = size;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.statePart = new byte[size];
	}

	public byte getState() { //геттер
		int injured_cnt = 0; // кол-во раненных клеток
		for (int i = 0; i < statePart.length; ++i) {
			if (statePart[i] == 1) injured_cnt++;
			if (statePart[i] == 2) return 2;
		}
		if (injured_cnt == statePart.length) {
			for (int i = 0; i < statePart.length; ++i) {
				statePart[i] = 2;
			}
			return 2;
		} else if (injured_cnt > 0) {
			return 1;
		}
		return 0;
	}

	public byte setState(byte y, byte x) {
		int coord = 0;
		if (xStart == xEnd) {
			coord = y - yStart;
		} else {
			coord = x - xStart;
		}
		statePart[coord] = 1;
		return getState();
	}

	public boolean pointIncluded(byte y, byte x) { // проверяем, входит ли эта точка в корабль
		if (xStart == xEnd) {
			return yStart <= y && y <= yEnd; 
		} else if (yStart == yEnd) {
			return xStart <= x && x <= xEnd;
		}
		return false;
	}

	public byte[] getStatePart() {
		return statePart;
	}

	public byte getxStart() {
		return xStart;
	}

	public byte getSize() {
		return size;
	}
}