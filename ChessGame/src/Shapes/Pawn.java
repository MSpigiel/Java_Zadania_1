package Shapes;


public class Pawn extends Shape {

	private boolean doubleMoveAvaliable = true;
	private boolean isEndOfBoardReached;

	public Pawn(int posX, int posY, Colour colour) {
		super(posX, posY, colour);
		setEndOfBoardReached(false);
	}

	public void move(int toX, int toY) {
		if (moveValidation(toX, toY)) {
			setPosX(toX);
			setPosY(toY);
			doubleMoveAvaliable = false;
		}		
		changeAtTheEnd();
	}

	protected boolean moveValidation(int toX, int toY) {
		if (figureColour == Colour.WHITE) {
			if (doubleMoveAvaliable) {
				if (toX == posX + 1 || toX == posX + 2) {
					return true;
				} else {
					return false;
				}
			} else {
				if (toX == posX + 1) {
					return true;
				} else {
					return false;
				}
			}

		} else if (figureColour == Colour.BLACK) {
			if (doubleMoveAvaliable) {
				if (toX == posX - 1 || toX == posX - 2) {
					return true;
				} else {
					return false;
				}
			} else {
				if (toX == posX - 1) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	public int getPosX() {
		return posX;
	}

	private void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	private void setPosY(int posY) {
		this.posY = posY;
	}

	public Colour getColour() {
		return figureColour;
	}


	public boolean isEndOfBoardReached() {
		return isEndOfBoardReached;
	}

	private void setEndOfBoardReached(boolean isEndOfBoardReached) {
		this.isEndOfBoardReached = isEndOfBoardReached;
	}
	
	private void changeAtTheEnd() {
		if (figureColour == Colour.WHITE) {
			if (posX == 7) {
				setEndOfBoardReached(true);
			}
		} else if (figureColour == Colour.BLACK) {
			if (posX == 0) {
				setEndOfBoardReached(true);
			}
		}
	}
}
