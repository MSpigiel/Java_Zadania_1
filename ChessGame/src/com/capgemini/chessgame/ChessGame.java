package com.capgemini.chessgame;

import java.util.Scanner;
import Shapes.Bishop;
import Shapes.Knight;
import Shapes.Pawn;
import Shapes.Queen;
import Shapes.Rook;
import Shapes.Shape;

public class ChessGame {

	private Player playerWhite;
	private Player playerBlack;
	private ChessBoard board;
	Scanner reader = new Scanner(System.in);

	public ChessGame() {

		playerWhite = new Player(Colour.WHITE);
		playerBlack = new Player(Colour.BLACK);
		board = new ChessBoard();

	}

	public void initializeDefaultGameState() {
		board.initializeDefaultGameState();
		playerWhite.setKing(board.getBoard()[7][4].getChessman());
		playerBlack.setKing(board.getBoard()[0][4].getChessman());
	}

	public ChessBoard getBoard() {
		return this.board;
	}

	public boolean checkIfKingIsChecked(ChessBoard board, Shape king) {

		int kingPosX = king.getPosX();
		int kingPosY = king.getPosY();
		Colour colour = king.getColour();

		if (isCheckedDiagonallyDownRight(kingPosX, kingPosY, board, colour)
				|| isCheckedDiagonallyDownLeft(kingPosX, kingPosY, board, colour)
				|| isCheckedDiagonallyUpRight(kingPosX, kingPosY, board, colour)
				|| isCheckedDiagonallyUpLeft(kingPosX, kingPosY, board, colour)
				|| isCheckedHorizontallyRight(kingPosX, kingPosY, board, colour)
				|| isCheckedHorizontallyLeft(kingPosX, kingPosY, board, colour)
				|| isCheckedVerticallyUp(kingPosX, kingPosY, board, colour)
				|| isCheckedVerticallyDown(kingPosX, kingPosY, board, colour)) {
			return true;
		}

		if (colour == Colour.WHITE) {
			if (isCheckedByBlackPawn(kingPosX, kingPosY, board, colour)) {
				return true;
			}
		}

		if (colour == Colour.BLACK) {
			if (isCheckedByWhitePawn(kingPosX, kingPosY, board, colour)) {
				return true;
			}
		}

		if (isCheckedByKnight(kingPosX, kingPosY, board, colour)) {
			return true;
		}

		return false;
	}

	public boolean checkIfKingIsCheckedAfterMove(int fromX, int fromY, int toX, int toY, Shape king) {
		
		ChessBoard testBoard = new ChessBoard(board);
		testBoard.move(testBoard.getBoard()[fromX][fromY], testBoard.getBoard()[toX][toY]);
		if(checkIfKingIsChecked(testBoard, king)){
			return true;
		}
		return false;
	}

	private boolean isCheckedByKnight(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {

		for (KnightMoves move : KnightRules.knightMoves) {
			if ((kingPosX + move.getDifferenceX() > 0 && kingPosX + move.getDifferenceX() < 8)
					&& kingPosY + move.getDifferenceY() > 0 && kingPosY + move.getDifferenceY() < 8) {
				int targetX = kingPosX + move.getDifferenceX();
				int targetY = kingPosY + move.getDifferenceY();
				if (board.getShapeOnCoordinates(targetX, targetY) != null
						&& board.getShapeOnCoordinates(targetX, targetY) instanceof Knight
						&& board.getShapeOnCoordinates(targetX, targetY).getColour() != colour) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isCheckedDiagonallyUpLeft(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		int iteratorX = kingPosX;
		int iteratorY = kingPosY;

		while (!(iteratorX == 0 || iteratorY == 0)) {
			iteratorX--;
			iteratorY--;
			if (board.getShapeOnCoordinates(iteratorX, iteratorY) != null) {
				if (board.getShapeOnCoordinates(iteratorX, iteratorY).getColour() == colour) {
					return false;
				} else if (board.getShapeOnCoordinates(iteratorX, iteratorY) instanceof Queen
						|| board.getShapeOnCoordinates(iteratorX, iteratorY) instanceof Bishop) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private boolean isCheckedByWhitePawn(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		if (kingPosX < 7) {
			if (kingPosY == 7) {
				if (board.getShapeOnCoordinates(kingPosX + 1, kingPosY - 1) != null
						&& board.getShapeOnCoordinates(kingPosX + 1, kingPosY - 1) instanceof Pawn
						&& board.getShapeOnCoordinates(kingPosX + 1, kingPosY - 1).getColour() != colour) {
					return true;
				}
			} else if (kingPosY == 0) {
				if (board.getShapeOnCoordinates(kingPosX + 1, kingPosY + 1) != null
						&& board.getShapeOnCoordinates(kingPosX + 1, kingPosY + 1) instanceof Pawn
						&& board.getShapeOnCoordinates(kingPosX + 1, kingPosY + 1).getColour() != colour) {
					return true;
				}
			} else if (board.getShapeOnCoordinates(kingPosX + 1, kingPosY - 1) != null) {
				if (board.getShapeOnCoordinates(kingPosX + 1, kingPosY - 1) instanceof Pawn
						&& board.getShapeOnCoordinates(kingPosX + 1, kingPosY - 1).getColour() != colour) {
					return true;
				}
			} else if (board.getShapeOnCoordinates(kingPosX + 1, kingPosY + 1) != null) {
				if (board.getShapeOnCoordinates(kingPosX + 1, kingPosY + 1) instanceof Pawn
						&& board.getShapeOnCoordinates(kingPosX + 1, kingPosY + 1).getColour() != colour) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCheckedByBlackPawn(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		if (kingPosX > 0) {
			if (kingPosY == 7) {
				if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY - 1) != null
						&& board.getShapeOnCoordinates(kingPosX - 1, kingPosY - 1) instanceof Pawn
						&& board.getShapeOnCoordinates(kingPosX - 1, kingPosY - 1).getColour() != colour) {
					return true;
				}
			} else if (kingPosY == 0) {
				if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY + 1) != null
						&& board.getShapeOnCoordinates(kingPosX - 1, kingPosY + 1) instanceof Pawn
						&& board.getShapeOnCoordinates(kingPosX - 1, kingPosY + 1).getColour() != colour) {
					return true;
				}
			} else if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY - 1) != null) {
				if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY - 1) instanceof Pawn
						&& board.getShapeOnCoordinates(kingPosX - 1, kingPosY - 1).getColour() != colour) {
					return true;
				}
			} else if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY + 1) != null) {
				if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY + 1) instanceof Pawn
						&& board.getShapeOnCoordinates(kingPosX - 1, kingPosY + 1).getColour() != colour) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCheckedDiagonallyUpRight(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		int iteratorX = kingPosX;
		int iteratorY = kingPosY;

		while (!(iteratorX == 0 || iteratorY == 7)) {
			iteratorX--;
			iteratorY++;
			if (board.getShapeOnCoordinates(iteratorX, iteratorY) != null) {
				if (board.getShapeOnCoordinates(iteratorX, iteratorY).getColour() == colour) {
					return false;
				} else if (board.getShapeOnCoordinates(iteratorX, iteratorY) instanceof Queen
						|| board.getShapeOnCoordinates(iteratorX, iteratorY) instanceof Bishop) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private boolean isCheckedDiagonallyDownLeft(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		int iteratorX = kingPosX;
		int iteratorY = kingPosY;

		while (!(iteratorX == 7 || iteratorY == 0)) {
			iteratorX++;
			iteratorY--;
			if (board.getShapeOnCoordinates(iteratorX, iteratorY) != null) {
				if (board.getShapeOnCoordinates(iteratorX, iteratorY).getColour() == colour) {
					return false;
				} else if (board.getShapeOnCoordinates(iteratorX, iteratorY) instanceof Queen
						|| board.getShapeOnCoordinates(iteratorX, iteratorY) instanceof Bishop) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private boolean isCheckedDiagonallyDownRight(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		int iteratorX = kingPosX;
		int iteratorY = kingPosY;

		while (!(iteratorX == 7 || iteratorY == 7)) {
			iteratorX++;
			iteratorY++;
			if (board.getShapeOnCoordinates(iteratorX, iteratorY) != null) {
				if (board.getShapeOnCoordinates(iteratorX, iteratorY).getColour() == colour) {
					return false;
				} else if (board.getShapeOnCoordinates(iteratorX, iteratorY) instanceof Queen
						|| board.getShapeOnCoordinates(iteratorX, iteratorY) instanceof Bishop) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private boolean isCheckedHorizontallyLeft(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		for (int i = 1; i < kingPosY+1; i++) {
			if (board.getShapeOnCoordinates(kingPosX, kingPosY - i) != null) {
				if (board.getShapeOnCoordinates(kingPosX, kingPosY - i).getColour() == colour) {
					return false;
				} else if (board.getShapeOnCoordinates(kingPosX, kingPosY - i) instanceof Queen
						|| board.getShapeOnCoordinates(kingPosX, kingPosY - i) instanceof Rook) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private boolean isCheckedHorizontallyRight(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		for (int i = 1; i < 8 - kingPosY; i++) {
			if (board.getShapeOnCoordinates(kingPosX, kingPosY + i) != null) {
				if (board.getShapeOnCoordinates(kingPosX, kingPosY + i).getColour() == colour) {
					return false;
				} else if (board.getShapeOnCoordinates(kingPosX, kingPosY + i) instanceof Queen
						|| board.getShapeOnCoordinates(kingPosX, kingPosY + i) instanceof Rook) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private boolean isCheckedVerticallyUp(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		for (int i = 1; i < kingPosX; i++) {
			if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY) != null) {
				if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY).getColour() == colour) {
					return false;
				} else if (board.getShapeOnCoordinates(kingPosX - 1, kingPosY) instanceof Queen
						|| board.getShapeOnCoordinates(kingPosX - 1, kingPosY) instanceof Rook) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private boolean isCheckedVerticallyDown(int kingPosX, int kingPosY, ChessBoard board, Colour colour) {
		for (int i = 1; i < 8 - kingPosX; i++) {
			if (board.getShapeOnCoordinates(kingPosX + i, kingPosY) != null) {
				if (board.getShapeOnCoordinates(kingPosX + i, kingPosY).getColour() == colour) {
					return false;
				} else if (board.getShapeOnCoordinates(kingPosX + i, kingPosY) instanceof Queen
						|| board.getShapeOnCoordinates(kingPosX + i, kingPosY) instanceof Rook) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	

}
