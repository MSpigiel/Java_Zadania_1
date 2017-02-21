package Shapes;

import com.capgemini.chessgame.Colour;

public class Queen extends Shape {

	public Queen(int posX, int posY, Colour colour) {
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

		if (((posY - posX) == (toY - toX) || ((posY - posX) + ((posY - toY) * -2)) == (toY - toX))
				|| (posX == toX || posY == toY)) {
			return true;
		}
		return false;
	}

}
