package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.chessgame.ChessGame;
import com.capgemini.chessgame.Colour;

public class ChessGameTest {

	ChessGame game;

	@Before
	public void setUp() {
		game = new ChessGame();

	}

	@Test
	public void shouldReturnTrueWhenKingIsCheckedByQueenDiagonallyFromDownRight() {
		// given

		game.getBoard().initializeOneKing(0, 0, Colour.WHITE);
		game.getBoard().initializeOneQueen(7, 7, Colour.BLACK);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(0, 0));
		// then
		Assert.assertTrue(isChecked);
	}
	
	@Test
	public void shouldNotCheckKingWhenAnyShapeOnOppositesQueenWayDiagonallyFromDownRight(){

		game.getBoard().initializeOneKing(0, 0, Colour.WHITE);
		game.getBoard().initializeOneQueen(7, 7, Colour.BLACK);
		game.getBoard().initializeOneQueen(7, 7, Colour.WHITE);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(0, 0));
		// then
		Assert.assertFalse(isChecked);
	}
	
	@Test
	public void shouldReturnTrueWhenKingIsCheckedByBishopDiagonallyFromUpLeft() {
		// given

		game.getBoard().initializeOneKing(7, 7, Colour.WHITE);
		game.getBoard().initializeOneBishop(0, 0, Colour.BLACK);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(7, 7));
		// then
		Assert.assertTrue(isChecked);
	}

	@Test
	public void shouldNotCheckKingWhenAnyShapeOnOppositesBishopWayDiagonallyFromUpLeft(){

		game.getBoard().initializeOneKing(7, 7, Colour.WHITE);
		game.getBoard().initializeOneBishop(0, 0, Colour.BLACK);
		game.getBoard().initializeOneKnight(3, 3, Colour.BLACK);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(7, 7));
		// then
		Assert.assertFalse(isChecked);
	}
	
	@Test
	public void shouldReturnTrueWhenKingIsCheckedByBishopDiagonallyFromUpRight() {
		// given

		game.getBoard().initializeOneKing(5, 1, Colour.WHITE);
		game.getBoard().initializeOneBishop(1, 5, Colour.BLACK);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(5, 1));
		// then
		Assert.assertTrue(isChecked);
	}

	@Test
	public void shouldNotCheckKingWhenAnyShapeOnOppositesBishopWayDiagonallyFromUpRight(){

		game.getBoard().initializeOneKing(4, 5, Colour.WHITE);
		game.getBoard().initializeOneBishop(2, 7, Colour.BLACK);
		game.getBoard().initializeOneRook(3, 6, Colour.BLACK);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(4, 5));
		// then
		Assert.assertFalse(isChecked);
	}
	
	@Test
	public void shouldCheckWhiteKingByBlackPawn() {
		// given

		game.getBoard().initializeOneKing(4, 1, Colour.WHITE);
		game.getBoard().initializeOnePawn(3, 0, Colour.BLACK);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(4, 1));
		// then
		Assert.assertTrue(isChecked);
	}
	
	@Test
	public void shouldCheckBlackKingByWhitePawn() {
		// given

		game.getBoard().initializeOneKing(0, 0, Colour.BLACK);
		game.getBoard().initializeOnePawn(1, 1, Colour.WHITE);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(0, 0));
		// then
		Assert.assertTrue(isChecked);
	}
	
	@Test
	public void shouldCheckWhiteKingByBlackKnight() {
		// given

		game.getBoard().initializeOneKing(7,7, Colour.WHITE);
		game.getBoard().initializeOneKnight(5, 6, Colour.BLACK);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(7, 7));
		// then
		Assert.assertTrue(isChecked);
	}
	
	@Test
	public void shouldCheckBlackKingByWhiteKnight() {
		// given

		game.getBoard().initializeOneKing(0, 0, Colour.BLACK);
		game.getBoard().initializeOneKnight(1, 2, Colour.WHITE);

		// when
		boolean isChecked = game.checkIfKingIsChecked(game.getBoard(),
				game.getBoard().getShapeOnCoordinates(0, 0));
		// then
		Assert.assertTrue(isChecked);
	}

	@Test
	public void shouldCheckKingAfterMoveToCollisionInQueensWay() {
		// given

		game.getBoard().initializeOneKing(0, 0, Colour.BLACK);
		game.getBoard().initializeOneQueen(7, 1, Colour.WHITE);

		// when
		boolean isChecked = game.checkIfKingIsCheckedAfterMove(0, 0, 0, 1, game.getBoard().getShapeOnCoordinates(0, 0));
		
		// then
		Assert.assertTrue(isChecked);
	}
	
	@Test
	public void shouldCheckKingAfterMoveShapeFromCollisionInRookWay() {
		// given

		game.getBoard().initializeOneKing(5, 6, Colour.WHITE);
		game.getBoard().initializeOneRook(5, 0, Colour.BLACK);
		game.getBoard().initializeOneRook(5, 2, Colour.WHITE);

		// when
		boolean isChecked = game.checkIfKingIsCheckedAfterMove(5, 2, 3, 2, game.getBoard().getShapeOnCoordinates(5, 6));
		
		// then
		Assert.assertTrue(isChecked);
	}
	
	
	

}
