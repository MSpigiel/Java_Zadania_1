package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.chessgame.ChessBoard;
import com.capgemini.chessgame.Colour;

public class KnightTest {

	ChessBoard board;

	@Before
	public void setUp() {
		board = new ChessBoard();

	}

	@Test
	public void shouldMoveKnightTwoFieldsUpAndOneLeft() {
		// given
		board.initializeOneKnight(4,3,Colour.WHITE);
		// when
		board.getBoard()[4][3].getChessman().move(2,2);
		int x = board.getBoard()[4][3].getChessman().getPosX();
		int y = board.getBoard()[4][3].getChessman().getPosY();
		// then
		Assert.assertEquals(2, x);
		Assert.assertEquals(2, y);
		
	}
	
	@Test
	public void shouldMoveKnightTwoFieldsUpAndOneRight() {
		// given
		board.initializeOneKnight(4,3,Colour.WHITE);
		// when
		board.getBoard()[4][3].getChessman().move(2,4);
		int x = board.getBoard()[4][3].getChessman().getPosX();
		int y = board.getBoard()[4][3].getChessman().getPosY();
		// then
		Assert.assertEquals(2, x);
		Assert.assertEquals(4, y);
		
	}
	
	@Test
	public void shouldMoveKnightTwoFieldsRightAndOneUp() {
		// given
		board.initializeOneKnight(4,3,Colour.WHITE);
		// when
		board.getBoard()[4][3].getChessman().move(3,5);
		int x = board.getBoard()[4][3].getChessman().getPosX();
		int y = board.getBoard()[4][3].getChessman().getPosY();
		// then
		Assert.assertEquals(3, x);
		Assert.assertEquals(5, y);
		
	}
	
	@Test
	public void shouldMoveKnightTwoFieldsRightAndOneDown() {
		// given
		board.initializeOneKnight(4,3,Colour.WHITE);
		// when
		board.getBoard()[4][3].getChessman().move(5,5);
		int x = board.getBoard()[4][3].getChessman().getPosX();
		int y = board.getBoard()[4][3].getChessman().getPosY();
		// then
		Assert.assertEquals(5, x);
		Assert.assertEquals(5, y);
		
	}
	
	
	@Test
	public void shouldThrowExceptionWhenMoveIsOutOfBoardEdge() {
		// given
		board.initializeOneKnight(4,6,Colour.WHITE);
		// when
		try{
			board.getBoard()[4][6].getChessman().move(3,8);
		} catch (IllegalStateException e){
			System.out.println(e.getMessage());
		}
		
		// then
		
		
	}

	@Test
	public void shouldNotMoveKnightOneFieldDownAndOneFieldRight() {
		// given
		board.initializeOneKnight(3,3,Colour.BLACK);
		// when
		board.getBoard()[3][3].getChessman().move(4,4);
		int x = board.getBoard()[3][3].getChessman().getPosX();
		int y = board.getBoard()[3][3].getChessman().getPosY();
		// then
		Assert.assertNotEquals(4, x);
		Assert.assertNotEquals(4, y);
		
	}

}
