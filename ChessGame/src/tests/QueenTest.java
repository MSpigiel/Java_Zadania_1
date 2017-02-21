package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.chessgame.ChessBoard;
import com.capgemini.chessgame.Colour;

public class QueenTest {

	ChessBoard board;

	@Before
	public void setUp() {
		board = new ChessBoard();

	}
	
	@Test
	public void shouldMoveQueenThreeFieldsDiagonallyDownRight() {
		// given
		board.initializeOneQueen(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(7,7);
		// then
		Assert.assertEquals(7, board.getBoard()[4][4].getChessman().getPosX());
		Assert.assertEquals(7, board.getBoard()[4][4].getChessman().getPosY());
	}
	
	@Test
	public void shouldMoveQueenThreeFieldsDiagonallyUpRight() {
		// given
		board.initializeOneQueen(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(1,7);
		// then
		Assert.assertEquals(1, board.getBoard()[4][4].getChessman().getPosX());
		Assert.assertEquals(7, board.getBoard()[4][4].getChessman().getPosY());
	}

	
	@Test
	public void shouldMoveQueenThreeFieldsDiagonallyUpLeft() {
		// given
		board.initializeOneQueen(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(1,1);
		// then
		Assert.assertEquals(1, board.getBoard()[4][4].getChessman().getPosX());
		Assert.assertEquals(1, board.getBoard()[4][4].getChessman().getPosY());
	}
	
	@Test
	public void shouldMoveQueenThreeFieldsDiagonallyDownLeft() {
		// given
		board.initializeOneQueen(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(7,1);
		// then
		Assert.assertEquals(7, board.getBoard()[4][4].getChessman().getPosX());
		Assert.assertEquals(1, board.getBoard()[4][4].getChessman().getPosY());
	}
	
	@Test
	public void shouldMoveQueenThreeFieldsDown() {
		// given
		board.initializeOneQueen(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(7,4);
		// then
		Assert.assertEquals(7, board.getBoard()[4][4].getChessman().getPosX());
		Assert.assertEquals(4, board.getBoard()[4][4].getChessman().getPosY());
	}
	
	@Test
	public void shouldMoveQueenThreeFieldsUp() {
		// given
		board.initializeOneQueen(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(1,4);
		// then
		Assert.assertEquals(1, board.getBoard()[4][4].getChessman().getPosX());
		Assert.assertEquals(4, board.getBoard()[4][4].getChessman().getPosY());
	}
	
	@Test
	public void shouldMoveQueenThreeFieldsRight() {
		// given
		board.initializeOneQueen(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(4,7);
		// then
		Assert.assertEquals(4, board.getBoard()[4][4].getChessman().getPosX());
		Assert.assertEquals(7, board.getBoard()[4][4].getChessman().getPosY());
	}
	
	@Test
	public void shouldMoveQueenThreeFieldsLeft() {
		// given
		board.initializeOneQueen(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(4,1);
		// then
		Assert.assertEquals(4, board.getBoard()[4][4].getChessman().getPosX());
		Assert.assertEquals(1, board.getBoard()[4][4].getChessman().getPosY());
	}
}
