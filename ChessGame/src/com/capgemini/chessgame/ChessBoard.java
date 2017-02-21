package com.capgemini.chessgame;

import com.capgemini.chessgame.Colour;

import Shapes.Bishop;
import Shapes.King;
import Shapes.Knight;
import Shapes.Pawn;
import Shapes.Queen;
import Shapes.Rook;

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

	public void move(Field sourceField, Field targetField) {
		
		while(validateIfCheck()){
			
		}
		
		if (validateIfNoChessmanOnWay(sourceField, targetField)) {
				board[sourceField.getPosX()][sourceField.getPosY()].getChessman().move(targetField.getPosX(),
						targetField.getPosY());
				targetField.setChessman(sourceField.getChessman());
				sourceField.setChessman(null);
			}
	}

	public void initializeDefaultGameState() {
		for(int i = 0; i < 8; i++){
			board[1][i].setChessman(new Pawn(1, i, Colour.BLACK));
		}
		
		board[0][0].setChessman(new Rook(0, 0, Colour.BLACK));
		board[0][1].setChessman(new Knight(0, 1, Colour.BLACK));
		board[0][2].setChessman(new Bishop(0, 2, Colour.BLACK));
		board[0][3].setChessman(new Queen(0, 3, Colour.BLACK));
		board[0][4].setChessman(new King(0, 4, Colour.BLACK));
		board[0][5].setChessman(new Bishop(0, 5, Colour.BLACK));
		board[0][6].setChessman(new Knight(0, 6, Colour.BLACK));
		board[0][7].setChessman(new Rook(0, 7, Colour.BLACK));
				
		for(int i = 0; i < 8; i++){
			board[6][i].setChessman(new Pawn(6, i, Colour.WHITE));
		}
		

		board[7][0].setChessman(new Rook(7, 0, Colour.WHITE));
		board[7][1].setChessman(new Knight(7, 1, Colour.WHITE));
		board[7][2].setChessman(new Bishop(7, 2, Colour.WHITE));
		board[7][3].setChessman(new Queen(7, 3, Colour.WHITE));
		board[7][4].setChessman(new King(7, 4, Colour.WHITE));
		board[7][5].setChessman(new Bishop(7, 5, Colour.WHITE));
		board[7][6].setChessman(new Knight(7, 6, Colour.WHITE));
		board[7][7].setChessman(new Rook(7, 7, Colour.WHITE));
		
	}

	public void initializeOnePawn(int posX, int posY, Colour colour) {
		board[posX][posY].setChessman(new Pawn(posX, posY, colour));
	}

	public void initializeOneKnight(int posX, int posY, Colour colour) {
		board[posX][posY].setChessman(new Knight(posX, posY, colour));
	}

	public void initializeOneRook(int posX, int posY, Colour colour) {
		board[posX][posY].setChessman(new Rook(posX, posY, colour));
	}

	public void initializeOneKing(int posX, int posY, Colour colour) {
		board[posX][posY].setChessman(new King(posX, posY, colour));
	}

	public void initializeOneQueen(int posX, int posY, Colour colour) {
		board[posX][posY].setChessman(new Queen(posX, posY, colour));
	}

	public void initializeOneBishop(int posX, int posY, Colour colour) {
		board[posX][posY].setChessman(new Bishop(posX, posY, colour));
	}

	public Field[][] getBoard() {
		return this.board;
	}

	public int getSize() {
		return size;
	}

	private boolean validateIfNoChessmanOnWay(Field sourceField, Field targetField) {
		int posX = sourceField.getPosX();
		int posY = sourceField.getPosY();
		int toX = targetField.getPosX();
		int toY = targetField.getPosY();

		Direction direction = findMoveDirection(posX, posY, toX, toY);
		if (direction == Direction.CURRENTFIELD) {
			throw new IllegalStateException(
					"Trzeba wybrac inne docelowe pole pionka, a nie to na ktorym obecnie sie znajduje!");
		}

		if (targetField.getChessman() != null
				&& targetField.getChessman().getColour() == sourceField.getChessman().getColour()) {
			throw new IllegalStateException("Na docelowym miejscu stoi juz figura tego samego koloru");
		}
		
		if (sourceField.getChessman() instanceof Knight) {
			return true;
		}

		while (!(posX == toX && posY == toY)) {
			switch (direction) {
			case UP:

				posX--;
				if ((posX == toX && posY == toY)) {
					break;
				}
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case DOWN:

				posX++;
				if ((posX == toX && posY == toY)) {
					break;
				}
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case LEFT:

				posY--;
				if ((posX == toX && posY == toY)) {
					break;
				}
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case RIGHT:

				posY++;
				if ((posX == toX && posY == toY)) {
					break;
				}
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case UPLEFT:

				posX--;
				posY--;
				if ((posX == toX && posY == toY)) {
					break;
				}
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case UPRIGHT:

				posX--;
				posY++;
				if ((posX == toX && posY == toY)) {
					break;
				}
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case DOWNLEFT:

				posX++;
				posY--;
				if ((posX == toX && posY == toY)) {
					break;
				}
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case DOWNRIGHT:

				posX++;
				posY++;
				if ((posX == toX && posY == toY)) {
					break;
				}
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			default:
				throw new IllegalStateException("Ruch na to pole jest nieosiagalny przez ta figure");
			}
		}
		return true;
	}

	private boolean validateIfCheck(){
	
		return false;
	}
	
	private Direction findMoveDirection(int posX, int posY, int toX, int toY) {

		if (toX == posX && toY == posY) {
			return Direction.CURRENTFIELD;
		}

		if (toX < posX && toY == posY) {
			return Direction.UP;
		}

		if (toX > posX && toY == posY) {
			return Direction.DOWN;
		}

		if (toX == posX && toY > posY) {
			return Direction.RIGHT;
		}

		if (toX == posX && toY < posY) {
			return Direction.LEFT;
		}

		if ((posY - posX) == (toY - toX)) {
			if (toX > posX) {
				return Direction.DOWNRIGHT;
			} else {
				return Direction.UPLEFT;
			}
		}

		if ((posY - posX) + ((posY - toY) * -2) == (toY - toX)) {
			if (toX > posX) {
				return Direction.DOWNLEFT;
			} else {
				return Direction.UPRIGHT;
			}
		}
		return Direction.UNREACHABLE;
	}

}
