package Shapes;

public class Queen extends Shape {

	public Queen(int posX, int posY, Colour colour) {
		super(posX, posY, colour);
	}

	@Override
	public void move(int toX, int toY) {
		
	}

	@Override
	protected boolean moveValidation(int toX, int toY) {
		return false;
	}

}
