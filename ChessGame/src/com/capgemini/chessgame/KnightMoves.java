package com.capgemini.chessgame;

public enum KnightMoves {
	UPLEFT(-2, -1), UPRIGHT(-2, 1), DOWNLEFT(2, -1), DOWNRIGHT(2, 1), LEFTUP(-1, -2), LEFTDOWN(1, -2), RIGHTUP(-1,
			2), RIGHTDOWN(1, 2);
	private int differenceX;
	private int differenceY;
	
	private KnightMoves(int x, int y){
		setDifferenceX(x);
		setDifferenceY(y);
	}

	public int getDifferenceX() {
		return differenceX;
	}

	public void setDifferenceX(int differenceX) {
		this.differenceX = differenceX;
	}

	public int getDifferenceY() {
		return differenceY;
	}

	public void setDifferenceY(int differenceY) {
		this.differenceY = differenceY;
	}
}
