package com.capgemini.chessGame;

import Shapes.Shape;

public class Field {
	
	private int y;
	private int x;
	private Shape chessman;
	
	public Field(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void setCheesman(Shape chess){
		this.chessman = chess;
	}
	
	public Shape getChessman(){
		return this.chessman;
	}
}
