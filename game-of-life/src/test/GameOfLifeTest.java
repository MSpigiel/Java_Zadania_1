package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.gameOfLife.Cell;
import com.capgemini.gameOfLife.GameOfLifeImpl;

import interfaces.GameOfLife;

public class GameOfLifeTest {

	GameOfLifeImpl game;

	@Before
	public void setUp() {
		game = new GameOfLifeImpl();
	}

	@Test
	public void shouldCreateBoard8x8() {
		// given
		game.initializeBoard(8);
		// when
		int boardLength = game.getBoard().length;
		// then
		Assert.assertEquals(8, boardLength);
	}

	@Test
	public void shouldReturnFalseForCellDefaultState() {
		// given
		game.initializeBoard(8);
		// when
		boolean isFalse = game.getBoard()[0][0].isAlive();
		// then
		Assert.assertFalse(isFalse);
	}

	@Test
	public void shouldInitialize4RandomCellsWithAliveState() {
		// given
		int aliveCells = 0;
		game.initializeBoard(8);
		game.initializeGameStateRandomly(4);
		Cell[][] board = game.getBoard();
		// when
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].isAlive()){
					aliveCells++;
				}
			}
		}
		// then
		Assert.assertEquals(4, aliveCells);
	}
	
	@Test
	public void shouldManuallyInitializeCellWithAliveState() {
		// given		
		game.initializeBoard(8);
		game.initializeGameStateManually(0,1);
		Cell[][] board = game.getBoard();
		// when
		boolean isAlive = board[0][1].isAlive();
		// then
		Assert.assertTrue(isAlive);
	}
	
	@Test
	public void shouldReturn3AliveNeighbours() {
		// given		
		game.initializeBoard(8);
		game.initializeGameStateManually(0,1);
		game.initializeGameStateManually(1,1);
		game.initializeGameStateManually(1,0);
		// when
		int aliveNeighbors = game.countAliveNeighbors(0,0);
		// then
		Assert.assertEquals(3, aliveNeighbors);
	}
	
	@Test
	public void shouldReturn8AliveNeighbours() {
		// given		
		game.initializeBoard(8);
		game.initializeGameStateManually(1,0);
		game.initializeGameStateManually(1,1);
		game.initializeGameStateManually(1,2);
		game.initializeGameStateManually(2,0);
		game.initializeGameStateManually(3,0);
		game.initializeGameStateManually(3,1);
		game.initializeGameStateManually(3,2);
		game.initializeGameStateManually(2,2);
		// when
		int aliveNeighbors = game.countAliveNeighbors(2,1);
		// then
		Assert.assertEquals(8, aliveNeighbors);
	}
	
	@Test
	public void shouldReturn5AliveNeighbours() {
		// given		
		game.initializeBoard(8);
		game.initializeGameStateManually(1,6);
		game.initializeGameStateManually(1,7);
		game.initializeGameStateManually(2,6);
		game.initializeGameStateManually(3,6);
		game.initializeGameStateManually(3,7);
		// when
		int aliveNeighbors = game.countAliveNeighbors(2,7);
		// then
		Assert.assertEquals(5, aliveNeighbors);
	}
	
	@Test
	public void shouldReturn1AliveNeighbour() {
		// given		
		game.initializeBoard(8);
		game.initializeGameStateManually(7,7);
		
		// when
		int aliveNeighbors = game.countAliveNeighbors(6,6);
		// then
		Assert.assertEquals(1, aliveNeighbors);
	}
	
	@Test
	public void shouldKillAllCells() {
		// given		
		game.initializeBoard(8);
		game.initializeGameStateManually(0,0);
		game.initializeGameStateManually(2,2);
		game.initializeGameStateManually(4,4);
		game.initializeGameStateManually(6,6);
		game.moveOn();
		// when
		int aliveCells = game.countAllAliveCells();
		// then
		Assert.assertEquals(0, aliveCells);
	}
	
	@Test
	public void shouldMoveOnCorrectly() {
		// given		
		game.initializeBoard(5);
		game.initializeGameStateManually(1,2);
		game.initializeGameStateManually(1,3);
		game.initializeGameStateManually(2,0);
		game.initializeGameStateManually(2,1);
		game.initializeGameStateManually(2,2);
		game.initializeGameStateManually(3,3);
		game.moveOn();
		// when
		int aliveCells = game.countAllAliveCells();
		// then
		Assert.assertEquals(5, aliveCells);
	}
	
	@Test
	public void shouldThrowIllegalStateException() {
				
		try{
			game.initializeBoard(5);
			game.initializeGameStateRandomly(50);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void shouldThrowIllegalStateException2() {
				
		try{
			game.initializeBoard(-5);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
