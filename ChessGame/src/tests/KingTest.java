package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.chessgame.ChessBoard;
import com.capgemini.chessgame.Colour;

public class KingTest {

	ChessBoard board;

	@Before
	public void setUp() {
		board = new ChessBoard();

	}

	@Test
	public void shouldMoveKingOneFieldUpAndOneLeft() {
		// given
		board.initializeOneKing(4,4,Colour.WHITE);
		// when
		board.getBoard()[4][4].getChessman().move(3,5);
		int x = board.getBoard()[4][4].getChessman().getPosX();
		int y = board.getBoard()[4][4].getChessman().getPosY();
		// then
		Assert.assertEquals(3, x);
		Assert.assertEquals(5, y);
		
	}
	
	

}
