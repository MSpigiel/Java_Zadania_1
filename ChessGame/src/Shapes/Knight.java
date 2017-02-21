package Shapes;

import com.capgemini.chessgame.Colour;

public class Knight extends Shape {

	public Knight(int posX, int posY, Colour colour) {
		super(posX, posY, colour);
	}

	@Override
	public void move(int toX, int toY) {
		if (moveValidation(toX, toY)) {
			setNewPosition(toX, toY);
		}
	}

	@Override
	protected boolean moveValidation(int toX, int toY) {

		if (((toX == posX + 2 || toX == posX - 2) && (toY == posY - 1 || toY == posY + 1))
				|| ((toY == posY + 2 || toY == posY - 2) && (toX == posX - 1 || toX == posX + 1))) {
			return true;
		}
		return false;
	}

}
