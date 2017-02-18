package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.chessGame.ChessBoard;

import Shapes.Colour;


public class ChessGameTest {

	ChessBoard board;

	@Before
	public void setUp() {
		board = new ChessBoard();

	}

	@Test
	public void shouldMoveWhitePawnOneFieldForward() {
		// given
		board.initializeOneChessman(0,0,Colour.WHITE);
		// when
		board.getBoard()[0][0].getChessman().move(1,0);
		int x = board.getBoard()[0][0].getChessman().getPosX();
		// then
		Assert.assertEquals(1, x);
		
	}
	
	@Test
	public void shouldMoveWhitePawnTwoFieldsForward() {
		// given
		board.initializeOneChessman(0,0,Colour.WHITE);
		// when
		board.getBoard()[0][0].getChessman().move(2,0);
		int x = board.getBoard()[0][0].getChessman().getPosX();
		// then
		Assert.assertEquals(2, x);
		
	}
	
	@Test
	public void shouldNotMoveWhitePawnThreeFieldsForward() {
		// given
		board.initializeOneChessman(0,0,Colour.WHITE);
		// when
		board.getBoard()[0][0].getChessman().move(3,0);
		int x = board.getBoard()[0][0].getChessman().getPosX();
		// then
		Assert.assertNotEquals(3, x);
		
	}
	
	@Test
	public void shouldNotMoveWhitePawnTwoFieldsForward() {
		// given
		board.initializeOneChessman(0,0,Colour.WHITE);
		// when
		board.getBoard()[0][0].getChessman().move(1,0);
		board.getBoard()[0][0].getChessman().move(3,0);
		int x = board.getBoard()[0][0].getChessman().getPosX();
		// then
		Assert.assertNotEquals(3, x);
		
	}
	
	@Test
	public void shouldMoveBlackPawnTwoFieldsForward() {
		// given
		board.initializeOneChessman(6,0,Colour.BLACK);
		// when
		board.getBoard()[6][0].getChessman().move(4,0);
		int x = board.getBoard()[6][0].getChessman().getPosX();
		// then
		Assert.assertEquals(4, x);		
	}
	
	@Test
	public void shouldNotMoveBlackPawnOneFieldBackward() {
		// given
		board.initializeOneChessman(6,0,Colour.BLACK);
		// when
		board.getBoard()[6][0].getChessman().move(7,0);
		int x = board.getBoard()[6][0].getChessman().getPosX();
		// then
		Assert.assertNotEquals(7, x);		
	}
	
	@Test
	public void shouldNotMoveBlackPawnOneFieldRight() {
		// given
		board.initializeOneChessman(6,0,Colour.BLACK);
		// when
		board.getBoard()[6][0].getChessman().move(6,1);
		int y = board.getBoard()[6][0].getChessman().getPosY();
		// then
		Assert.assertNotEquals(1, y);		
	}

	// @Test
	// public void shouldInitializeOnePawnOn00Field(){
	// //given
	// board.initializeDefaultGameState();
	// //when
	//
	// //then
	// Assert.assertFalse(isInitialized);
	// }
	//
	// @Test
	// public void shouldMovePawn(){
	// //given
	// board.initializeDefaultGameState();
	// //when
	//
	// //then
	// Assert.assertFalse(isInitialized);
	// }
}
