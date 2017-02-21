package Shapes;

import com.capgemini.chessgame.Colour;

public class Rook extends Shape {

	public Rook(int posX, int posY, Colour colour) {
		super(posX, posY, colour);
	}

	@Override
	public void move(int toX, int toY) {
		if (moveValidation(toX, toY)) {
			setNewPosition(toX, toY);
		} //TODO else throw exception
	}

	@Override
	protected boolean moveValidation(int toX, int toY) {

		if (posX == toX || posY == toY) {
			return true;
		}
		return false;
	}


}
