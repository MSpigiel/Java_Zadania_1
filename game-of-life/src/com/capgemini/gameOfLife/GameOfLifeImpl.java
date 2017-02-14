package com.capgemini.gameOfLife;

import java.util.Random;

import interfaces.GameOfLife;

public class GameOfLifeImpl implements GameOfLife {

	private Cell[][] board;
	Random generator = new Random();

	@Override
	public void initializeBoard(int size) {
		if (size < 0) {
			throw new IllegalStateException("Podany rozmiar jest niedopuszczalny");
		}
		board = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new Cell();
				board[i][j].setAxisY(i);
				board[i][j].setAxisX(j);
			}
		}
	}

	@Override
	public void initializeGameStateRandomly(int aliveCellsNumber) {
		if (aliveCellsNumber > board.length * board.length) {
			throw new IllegalStateException("Ilosc zywych komorek nie moze przekraczac ilosci wolnych kratek");
		}

		int posY, posX, cellsToInitialize;
		cellsToInitialize = aliveCellsNumber;

		for (int i = 0; i < cellsToInitialize; i++) {
			posY = generator.nextInt(board.length);
			posX = generator.nextInt(board.length);
			if (board[posY][posX].isAlive()) {
				cellsToInitialize--;
			} else {
				board[posY][posX].setAlive(true);
				board[posY][posX].setAxisY(posY);
				board[posY][posX].setAxisX(posX);
			}
		}

	}

	@Override
	public void moveOn() {
		int size = board.length;
		Cell[][] temp = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp[i][j] = new Cell();
				temp[i][j].setAxisY(i);
				temp[i][j].setAxisX(j);
				if(board[i][j].isAlive()){
					if(countAliveNeighbors(i,j) == 2 || countAliveNeighbors(i,j) == 3){						
						temp[i][j].setAlive(true);
					} else {
						temp[i][j].setAlive(false);
					}
				} else {
					if(countAliveNeighbors(i,j) == 3){						
						temp[i][j].setAlive(true);
					} else {
						temp[i][j].setAlive(false);
					}
				}
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = temp[i][j];
			}
		}
		
	}

	public Cell[][] getBoard() {
		return board;
	}

	@Override
	public void initializeGameStateManually(int posY, int posX) {
		if (board[posY][posX].isAlive()) {
			throw new IllegalStateException("Dana komorka zostala juz ozywiona");
		} else {
			board[posY][posX].setAlive(true);
			board[posY][posX].setAxisY(posY);
			board[posY][posX].setAxisX(posX);
		}

	}

	public int countAliveNeighbors(int posY, int posX) {
		int aliveNeighbors = 0;
		int size = board.length;

		if (posY == 0 && posX == 0) {
			aliveNeighbors += (isRightAlive(posY, posX) + isLowerRightAlive(posY, posX) + isLowerAlive(posY, posX));
			return aliveNeighbors;
		} else if (posY == size - 1 && posX == 0) {
			aliveNeighbors += (isUpperAlive(posY, posX) + isRightAlive(posY, posX) + isUpperRightAlive(posY, posX));
			return aliveNeighbors;
		} else if (posY == 0 && posX == size - 1) {
			aliveNeighbors += (isLeftAlive(posY, posX) + isLowerAlive(posY, posX) + isLowerLeftAlive(posY, posX));
			return aliveNeighbors;
		} else if (posY == size - 1 && posX == size - 1) {
			aliveNeighbors += (isLeftAlive(posY, posX) + isUpperAlive(posY, posX) + isUpperLeftAlive(posY, posX));
			return aliveNeighbors;
		}

		if (posY == 0) {
			aliveNeighbors += (isRightAlive(posY, posX) + isLowerRightAlive(posY, posX) + isLowerAlive(posY, posX)
					+ isLeftAlive(posY, posX) + isLowerLeftAlive(posY, posX));
			return aliveNeighbors;
		} else if (posX == 0) {
			aliveNeighbors += (isRightAlive(posY, posX) + isLowerRightAlive(posY, posX) + isLowerAlive(posY, posX)
					+ isUpperAlive(posY, posX) + isUpperRightAlive(posY, posX));
			return aliveNeighbors;
		} else if (posY == size - 1) {
			aliveNeighbors += (isRightAlive(posY, posX) + isUpperLeftAlive(posY, posX) + isLeftAlive(posY, posX)
					+ isUpperAlive(posY, posX) + isUpperRightAlive(posY, posX));
			return aliveNeighbors;
		} else if (posX == size - 1) {
			aliveNeighbors += (isLeftAlive(posY, posX) + isLowerLeftAlive(posY, posX) + isLowerAlive(posY, posX)
					+ isUpperAlive(posY, posX) + isUpperLeftAlive(posY, posX));
			return aliveNeighbors;
		}

		aliveNeighbors += (isRightAlive(posY, posX) + isLeftAlive(posY, posX) + isUpperAlive(posY, posX)
				+ isLowerAlive(posY, posX) + isUpperRightAlive(posY, posX) + isUpperLeftAlive(posY, posX)
				+ isLowerLeftAlive(posY, posX) + isLowerRightAlive(posY, posX));

		return aliveNeighbors;
	}
	
	public int countAllAliveCells(){
		int cells = 0;
		int size = board.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(board[i][j].isAlive()){
					cells++;
				}
			}
		}
		return cells;
	}
	
	private int isRightAlive(int posY, int posX) {
		if (board[posY][posX + 1].isAlive()) {
			return 1;
		} else {
			return 0;
		}
	}

	private int isLeftAlive(int posY, int posX) {
		if (board[posY][posX - 1].isAlive()) {
			return 1;
		} else {
			return 0;
		}
	}

	private int isUpperAlive(int posY, int posX) {
		if (board[posY - 1][posX].isAlive()) {
			return 1;
		} else {
			return 0;
		}
	}

	private int isUpperLeftAlive(int posY, int posX) {
		if (board[posY - 1][posX - 1].isAlive()) {
			return 1;
		} else {
			return 0;
		}
	}

	private int isUpperRightAlive(int posY, int posX) {
		if (board[posY - 1][posX + 1].isAlive()) {
			return 1;
		} else {
			return 0;
		}
	}

	private int isLowerAlive(int posY, int posX) {
		if (board[posY + 1][posX].isAlive()) {
			return 1;
		} else {
			return 0;
		}
	}

	private int isLowerRightAlive(int posY, int posX) {
		if (board[posY + 1][posX + 1].isAlive()) {
			return 1;
		} else {
			return 0;
		}
	}

	private int isLowerLeftAlive(int posY, int posX) {
		if (board[posY + 1][posX - 1].isAlive()) {
			return 1;
		} else {
			return 0;
		}
	}

}
