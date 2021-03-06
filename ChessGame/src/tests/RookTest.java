package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.chessgame.ChessBoard;
import com.capgemini.chessgame.Colour;

public class RookTest {

	ChessBoard board;

	@Before
	public void setUp() {
		board = new ChessBoard();

	}

	@Test
	public void shouldMoveRookSevenFieldsRight() {
		// given
		board.initializeOneRook(0,0,Colour.BLACK);
		// when
		board.getBoard()[0][0].getChessman().move(0,7);
		int x = board.getBoard()[0][0].getChessman().getPosX();
		int y = board.getBoard()[0][0].getChessman().getPosY();
		// then
		Assert.assertEquals(0, x);
		Assert.assertEquals(7, y);
		
	}
	
	@Test
	public void shouldMoveRookSevenFieldsLeft() {
		// given
		board.initializeOneRook(7,7,Colour.BLACK);
		// when
		board.getBoard()[7][7].getChessman().move(7,0);
		int x = board.getBoard()[7][7].getChessman().getPosX();
		int y = board.getBoard()[7][7].getChessman().getPosY();
		// then
		Assert.assertEquals(7, x);
		Assert.assertEquals(0, y);
		
	}
	
	@Test
	public void shouldMoveRookSevenFieldsDown() {
		// given
		board.initializeOneRook(0,3,Colour.BLACK);
		// when
		board.getBoard()[0][3].getChessman().move(7,3);
		int x = board.getBoard()[0][3].getChessman().getPosX();
		int y = board.getBoard()[0][3].getChessman().getPosY();
		// then
		Assert.assertEquals(7, x);
		Assert.assertEquals(3, y);
		
	}
	
	@Test
	public void shouldMoveRookSevenFieldsUp() {
		// given
		board.initializeOneRook(7,3,Colour.BLACK);
		// when
		board.getBoard()[7][3].getChessman().move(0,3);
		int x = board.getBoard()[7][3].getChessman().getPosX();
		int y = board.getBoard()[7][3].getChessman().getPosY();
		// then
		Assert.assertEquals(0, x);
		Assert.assertEquals(3, y);
		
	}
	
	@Test
	public void shouldNotMoveRookOneFieldDownAndOneFieldRight() {
		// given
		board.initializeOneRook(3,3,Colour.BLACK);
		// when
		board.getBoard()[3][3].getChessman().move(4,4);
		int x = board.getBoard()[3][3].getChessman().getPosX();
		int y = board.getBoard()[3][3].getChessman().getPosY();
		// then
		Assert.assertNotEquals(4, x);
		Assert.assertNotEquals(4, y);
		
	}
	
	@Test
	public void shouldThrowExceptionWhenTryToMoveRookOutOfBoardEdge() {
		// given
		board.initializeOneRook(3,3,Colour.BLACK);
		// when
		try{
			board.getBoard()[3][3].getChessman().move(3,8);
			board.getBoard()[3][3].getChessman().getPosX();
			board.getBoard()[3][3].getChessman().getPosY();
		} catch (IllegalStateException e){
			System.out.println(e.getMessage());
		}
		
		// then
		
	}
	

}
