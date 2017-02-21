package com.capgemini.chessgame;

public class ChessGame {
	
	Player playerWhite;
	Player playerBlack;
	ChessBoard board;
	boolean gameOver;
	Colour currentTurn;
	
	public ChessGame(){
		
		gameOver = false;
		currentTurn = Colour.WHITE;
		playerWhite = new Player(Colour.WHITE);
		playerBlack = new Player(Colour.BLACK);
		board = new ChessBoard();
		board.initializeDefaultGameState();
		playerWhite.setKing(board.getBoard()[7][4].getChessman());
		playerBlack.setKing(board.getBoard()[0][4].getChessman());
		
	}
	
	public void play(){
		while(!gameOver){
			if(currentTurn == Colour.WHITE){
				System.out.println("Podaj ruch");
			} else { 
				
			}
		}
	}
	
	private void checkIfKingIsChecked(Colour color){
		
	}
	public void moveCheesman(Field currentField, Field targetField){
		//Cheesman is this move valid?
		
		//targetField.contains cheesman? if yes - remove
		
		//
	}
	
	
}
