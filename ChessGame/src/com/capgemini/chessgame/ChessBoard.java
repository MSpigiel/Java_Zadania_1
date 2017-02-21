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

	private int posX;
	private int posY;
	private int toX;
	private int toY;

	public ChessBoard() {
		board = new Field[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new Field(i, j);
			}
		}
	}

	public void move(Field sourceField, Field targetField) {
		if (validateIfNoChessmanOnWay(sourceField, targetField)) {
			if (targetField.getChessman() != null
					&& sourceField.getChessman().getColour() != targetField.getChessman().getColour()) {
				// bicie 
			} else {
				board[sourceField.getPosX()][sourceField.getPosY()].getChessman().move(targetField.getPosX(),
						targetField.getPosY());
				targetField.setChessman(sourceField.getChessman());
				sourceField.setChessman(null);
			}
		}
	}

	public void initializeDefaultGameState() {
		board[0][0].setChessman(new Pawn(0, 0, Colour.WHITE));
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
		assignMovePositions(sourceField, targetField);
		Direction direction = findMoveDirection(posX, posY, toX, toY);
		if(direction == Direction.CURRENTFIELD){
			throw new IllegalStateException("Trzeba wybrac inne docelowe pole pionka, niz to na ktorym sie znajduje!");
		}
		while (!(posX == toX && posY == toY)) {
			switch (direction) {
			case UP:

				posX--;
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case DOWN:

				posX++;
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case LEFT:

				posY--;
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case RIGHT:

				posY++;
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case UPLEFT:

				posX--;
				posY--;
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case UPRIGHT:

				posX--;
				posY++;
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case DOWNLEFT:

				posX++;
				posY--;
				if (board[posX][posY].getChessman() != null) {
					return false;
				}
				break;

			case DOWNRIGHT:

				posX++;
				posY++;
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

	private void assignMovePositions(Field sourceField, Field targetField) {
		posX = sourceField.getPosX();
		posY = sourceField.getPosY();
		toX = targetField.getPosX();
		toY = targetField.getPosY();
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
