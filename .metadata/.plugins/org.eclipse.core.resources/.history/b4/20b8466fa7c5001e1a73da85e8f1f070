package minesweeper;

public class Cell {
	private int[] coordinates = {-1, -1};
	private boolean hasBomb;
	private boolean hasBeenOpened = false;
	private int surroundingBombsCount;
	
	public Cell(int row, int column, boolean hasBomb) {
		this.coordinates[0] = row;
		this.coordinates[1] = column;
		this.hasBomb = hasBomb;
	};
	
	public void setSurroundingBombsCount(int surroundingBombsCount) {
		this.surroundingBombsCount = surroundingBombsCount;
	};
	
	public void setHasBeenOpened(boolean hasBeenOpened) {
		this.hasBeenOpened = hasBeenOpened;
	};
}
