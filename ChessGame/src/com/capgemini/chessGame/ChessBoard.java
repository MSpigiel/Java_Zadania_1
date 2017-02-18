package com.capgemini.chessGame;

import Shapes.Colour;
import Shapes.Pawn;

public class ChessBoard {

	private final int size = 8;
	private Field[][] board;
	
	public ChessBoard() {
		board = new Field[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new Field(i, j);
			}
		}
	}
	
	public void initializeDefaultGameState(){
		board[0][0].setCheesman(new Pawn(0, 0, Colour.WHITE));
	}
	
	public void initializeOneChessman(int posX, int posY, Colour colour){
		board[posX][posY].setCheesman(new Pawn(posX, posY, colour));
	}
	
	public Field[][] getBoard(){
		return this.board;
	}
	
	public int getSize(){
		return size;
	}
}
