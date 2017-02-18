package Shapes;

public class King extends Shape {

	public King(int posX, int posY, Colour colour) {
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
