package com.capgemini.chessgame;

import Shapes.Shape;

public class Player {
	
	private Colour playerColour;
	private Shape king;
	
	public Player(Colour colour){
		this.setPlayerColour(colour);		
	}
	
	public void moveCheesman(){
		
	}

	public Shape getKing() {
		return king;
	}

	public void setKing(Shape king) {
		this.king = king;
	}

	public Colour getPlayerColour() {
		return playerColour;
	}

	public void setPlayerColour(Colour playerColour) {
		this.playerColour = playerColour;
	}
	
}
