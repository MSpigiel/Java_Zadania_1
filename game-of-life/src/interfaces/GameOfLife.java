package interfaces;

public interface GameOfLife {

	/**
	 * Creates board, which represents our game table of tables
	 * @param size is height and width of frame (number of elements of table, and tables in each table cell)
	 */
	public void initializeBoard(int size);

	/**
	 * sets up alive cells
	 * @param aliveCellsNumber is amount of cells which we want to put in first iteration of game
	 */
	public void initializeGameStateRandomly(int aliveCellsNumber);

	/**
	 * sets up alive cells
	 * @param posY is place on board by axis Y, and PosX by axis X
	 */
	public void initializeGameStateManually(int posY, int posX);
	
	/**
	 * moves to next iteration of game
	 */
	public void moveOn();
	
	public int countAllAliveCells();
}

