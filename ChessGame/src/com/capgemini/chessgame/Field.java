package com.capgemini.chessgame;

import Shapes.Shape;

public class Field {

	private int posX;
	private int posY;
	private Shape chessman;
	
	public Field(int posX, int posY){
		setPosX(posX);
		setPosY(posY);
	}

	public void setChessman(Shape chess){
		this.chessman = chess;
	}
	
	public Shape getChessman(){
		return this.chessman;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
}
