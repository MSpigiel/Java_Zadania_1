package Shapes;

import com.capgemini.chessgame.Colour;

public class King extends Shape {

	public King(int posX, int posY, Colour colour) {
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

		if ((posX == toX && (posY == toY-1 || posY== toY+1)) ||
				((toX == posX + 1 || toX == posX - 1) && (toY == posY - 1 || toY == posY + 1)) ||
				(posX == toX && (posY == toY-1 || posY== toY+1))){
			return true;
		}
		return false;
	}
// alternatywny algorytm ruchu króla	
//	if ( (posX == toX && (posY == toY - 1 || posY == toY + 1))
//			|| ((posX == toX-1) && (posY == toY-1))
//			|| ((posX == toX+1) && (posY == toY+1))
//			|| ((posX == toX+1) && (posY == toY-1))
//			|| ((posX == toX-1) && (posY == toY+1))
//			|| (posY == toY && (posX == toX - 1 || posX == toX + 1)) ) {
//		return true;
//	}
//	return false;

}
