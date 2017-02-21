package Shapes;

import com.capgemini.chessgame.Colour;

public class Bishop extends Shape {

	public Bishop(int posX, int posY, Colour colour) {
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

		if ((posY - posX) == (toY - toX) || ((posY - posX) + ((posY - toY) * -2)) == (toY - toX)) {
			return true;
		}
		return false;
	}

}
