package Shapes;

import com.capgemini.chessgame.Colour;

public abstract class Shape {

	protected int posX, posY;
	protected Colour figureColour;

	public Shape(int posX, int posY, Colour colour) {
		setNewPosition(posX, posY);
		figureColour = colour;
	}

	public void setNewPosition(int toX, int toY) {
		if (isTargetPositionValid(toX, toY)) {
			posX = toX;
			posY = toY;
		} else {
			throw new IllegalStateException("Wybrana pozycja znajduje sie poza plansza!");
		}
	}

	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public Colour getColour(){
		return figureColour;
	}

	public abstract void move(int toX, int toY);

	protected abstract boolean moveValidation(int toX, int toY);

	private boolean isTargetPositionValid(int toX, int toY) {
		if (toX > 7 || toY > 7 || toX < 0 || toY < 0) {
			return false;
		} else {
			return true;
		}
	}

}
