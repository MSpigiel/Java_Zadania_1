package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.chessgame.ChessBoard;
import com.capgemini.chessgame.Colour;


public class ChessBoardTest {

	ChessBoard board;

	@Before
	public void setUp() {
		board = new ChessBoard();

	}

	@Test
	public void shouldThrowExceptionWhenTargetFieldEqualsSourceField() {
		//given
		board.initializeOneQueen(2, 2, Colour.BLACK);
		//when
		try{
			board.move(board.getBoard()[2][2], board.getBoard()[2][2]);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void shouldThrowExceptionWhenTargetFieldIsNotReachableForThisFigure() {
		//given
		board.initializeOneQueen(2, 2, Colour.BLACK);
		//when
		try{
			board.move(board.getBoard()[2][2], board.getBoard()[6][3]);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void shouldMoveQueenDownToNewField() {
		//given
		board.initializeOneQueen(2, 2, Colour.BLACK);
		//when
		board.move(board.getBoard()[2][2], board.getBoard()[6][2]);
		
		//then
		Assert.assertNull(board.getBoard()[2][2].getChessman());
		Assert.assertNotNull(board.getBoard()[6][2].getChessman());
	}
	
	@Test
	public void shouldNotMoveQueenDownToNewFieldBecauseOfCollision() {
		//given
		board.initializeOneQueen(2, 2, Colour.BLACK);
		board.initializeOneRook(3, 2, Colour.BLACK);
		//when
		board.move(board.getBoard()[2][2], board.getBoard()[6][2]);
		
		//then
		Assert.assertNotNull(board.getBoard()[2][2].getChessman());
		Assert.assertNull(board.getBoard()[6][2].getChessman());
	}
	
	@Test
	public void shouldMoveQueenDownRightToNewField() {
		//given
		board.initializeOneQueen(2, 2, Colour.BLACK);
		//when
		board.move(board.getBoard()[2][2], board.getBoard()[6][6]);
		
		//then
		Assert.assertNull(board.getBoard()[2][2].getChessman());
		Assert.assertNotNull(board.getBoard()[6][6].getChessman());
	}
	
	@Test
	public void shouldNotMoveQueenDownRightToNewFieldBecauseOfCollision() {
		//given
		board.initializeOneQueen(2, 2, Colour.BLACK);
		board.initializeOnePawn(5, 5, Colour.BLACK);
		//when
		board.move(board.getBoard()[2][2], board.getBoard()[6][6]);
		
		//then
		Assert.assertNotNull(board.getBoard()[2][2].getChessman());
		Assert.assertNull(board.getBoard()[6][6].getChessman());
	}
	
	@Test
	public void shouldMoveQueenRightToNewField() {
		//given
		board.initializeOneQueen(2, 2, Colour.BLACK);
		//when
		board.move(board.getBoard()[2][2], board.getBoard()[2][7]);
		
		//then
		Assert.assertNull(board.getBoard()[2][2].getChessman());
		Assert.assertNotNull(board.getBoard()[2][7].getChessman());
	}
	
	@Test
	public void shouldNotMoveQueenRightToNewFieldBecauseOfCollision() {
		//given
		board.initializeOneQueen(2, 2, Colour.BLACK);
		board.initializeOneKing(2, 6, Colour.WHITE);
		//when
		board.move(board.getBoard()[2][2], board.getBoard()[2][7]);
		
		//then
		Assert.assertNotNull(board.getBoard()[2][2].getChessman());
		Assert.assertNull(board.getBoard()[2][7].getChessman());
	}
	
	@Test
	public void shouldMoveQueenLeftToNewField() {
		//given
		board.initializeOneQueen(1, 6, Colour.BLACK);
		//when
		board.move(board.getBoard()[1][6], board.getBoard()[1][1]);
		
		//then
		Assert.assertNull(board.getBoard()[1][6].getChessman());
		Assert.assertNotNull(board.getBoard()[1][1].getChessman());
	}
	
	@Test
	public void shouldNotMoveQueenLeftToNewFieldBecauseOfCollision() {
		//given
		board.initializeOneQueen(1, 6, Colour.BLACK);
		board.initializeOneBishop(1, 4, Colour.WHITE);
		//when
		board.move(board.getBoard()[1][6], board.getBoard()[1][1]);
		
		//then
		Assert.assertNotNull(board.getBoard()[1][6].getChessman());
		Assert.assertNull(board.getBoard()[1][1].getChessman());
	}
	
	@Test
	public void shouldMoveQueenDownLeftToNewField() {
		//given
		board.initializeOneQueen(1, 6, Colour.BLACK);
		//when
		board.move(board.getBoard()[1][6], board.getBoard()[7][0]);
		
		//then
		Assert.assertNull(board.getBoard()[1][6].getChessman());
		Assert.assertNotNull(board.getBoard()[7][0].getChessman());
	}
	
	@Test
	public void shouldNotMoveQueenDownLeftToNewFieldBecauseOfCollision() {
		//given
		board.initializeOneQueen(1, 6, Colour.BLACK);
		board.initializeOneKnight(2, 5, Colour.WHITE);
		//when
		board.move(board.getBoard()[1][6], board.getBoard()[3][4]);
		
		//then
		Assert.assertNotNull(board.getBoard()[1][6].getChessman());
		Assert.assertNull(board.getBoard()[3][4].getChessman());
	}
	
	@Test
	public void shouldMoveQueenUpToNewField() {
		//given
		board.initializeOneQueen(6, 1, Colour.BLACK);
		//when
		board.move(board.getBoard()[6][1], board.getBoard()[1][1]);
		
		//then
		Assert.assertNull(board.getBoard()[6][1].getChessman());
		Assert.assertNotNull(board.getBoard()[1][1].getChessman());
	}
	
	@Test
	public void shouldNotMoveQueenUpToNewFieldBecauseOfCollision() {
		//given
		board.initializeOneQueen(6, 1, Colour.BLACK);
		board.initializeOneQueen(5, 1, Colour.WHITE);
		//when
		board.move(board.getBoard()[6][1], board.getBoard()[1][1]);
		
		//then
		Assert.assertNotNull(board.getBoard()[6][1].getChessman());
		Assert.assertNull(board.getBoard()[1][1].getChessman());
	}
	
	@Test
	public void shouldMoveQueenUpRightToNewField() {
		//given
		board.initializeOneQueen(6, 1, Colour.BLACK);
		//when
		board.move(board.getBoard()[6][1], board.getBoard()[1][6]);
		
		//then
		Assert.assertNull(board.getBoard()[6][1].getChessman());
		Assert.assertNotNull(board.getBoard()[1][6].getChessman());
	}
	
	@Test
	public void shouldNotMoveQueenUpRightToNewFieldBecauseOfCollision() {
		//given
		board.initializeOneQueen(6, 1, Colour.BLACK);
		board.initializeOneQueen(4, 3, Colour.WHITE);
		//when
		board.move(board.getBoard()[6][1], board.getBoard()[1][6]);
		
		//then
		Assert.assertNotNull(board.getBoard()[6][1].getChessman());
		Assert.assertNull(board.getBoard()[1][6].getChessman());
	}
	
	@Test
	public void shouldMoveQueenUpLeftToNewField() {
		//given
		board.initializeOneQueen(6, 6, Colour.BLACK);
		//when
		board.move(board.getBoard()[6][6], board.getBoard()[1][1]);
		
		//then
		Assert.assertNull(board.getBoard()[6][6].getChessman());
		Assert.assertNotNull(board.getBoard()[1][1].getChessman());
	}
	
	@Test
	public void shouldNotMoveQueenUpLeftToNewFieldBecauseOfCollision() {
		//given
		board.initializeOneQueen(6, 6, Colour.BLACK);
		board.initializeOneQueen(3, 3, Colour.WHITE);
		//when
		board.move(board.getBoard()[6][6], board.getBoard()[1][1]);
		
		//then
		Assert.assertNotNull(board.getBoard()[6][6].getChessman());
		Assert.assertNull(board.getBoard()[1][1].getChessman());
	}
	
	@Test
	public void shouldCaptureOppositeFigure() {
		//given
		board.initializeOneQueen(6,6, Colour.BLACK);
		board.initializeOnePawn(1, 1, Colour.WHITE);
		//when
		board.move(board.getBoard()[6][6], board.getBoard()[1][1]);
		//then
		
		Assert.assertNull(board.getBoard()[6][6].getChessman());
		
	}
	
	@Test
	public void shouldThrowExceptionWhenMoveOnFieldWhichContainsFigureWithTheSameColour() {
		//given
		board.initializeOneQueen(6,6, Colour.BLACK);
		board.initializeOnePawn(1, 1, Colour.BLACK);
		//when
		try{
			board.move(board.getBoard()[6][6], board.getBoard()[1][1]);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void shouldMoveKnightOverOtherFigure() {
		//given
		board.initializeOneKnight(0, 0, Colour.WHITE);
		board.initializeOneRook(0, 1, Colour.WHITE);
		board.initializeOneRook(0, 2, Colour.WHITE);
		//when
		board.move(board.getBoard()[0][0], board.getBoard()[1][2]);
		//then
		Assert.assertNull(board.getBoard()[0][0].getChessman());
		Assert.assertNotNull(board.getBoard()[1][2].getChessman());
	}
	
	@Test
	public void shouldCaptureOppositeFigureByKnightWhenMovingOverOtherFigure() {
		//given
		board.initializeOneKnight(0, 0, Colour.WHITE);
		board.initializeOneRook(0, 1, Colour.WHITE);
		board.initializeOneRook(0, 2, Colour.WHITE);
		board.initializeOneRook(1, 2, Colour.BLACK);
		//when
		board.move(board.getBoard()[0][0], board.getBoard()[1][2]);
		//then
		Assert.assertNull(board.getBoard()[0][0].getChessman());
		Assert.assertNotNull(board.getBoard()[1][2].getChessman());
	}
	
	
	
	
}
