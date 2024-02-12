package minesweeper;

import java.util.Arrays;

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
	
	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	
	public boolean getHasBomb() {
		return this.hasBomb;
	}
	
	public void setSurroundingBombsCount(int surroundingBombsCount) {
		this.surroundingBombsCount = surroundingBombsCount;
	};
	
	public void setHasBeenOpened(boolean hasBeenOpened) {
		this.hasBeenOpened = hasBeenOpened;
	};
	
	public boolean getHasBeenOpened() {
		return this.hasBeenOpened;
	}

	@Override
	public String toString() {
		return "Cell [coordinates=" + Arrays.toString(coordinates) + ", hasBomb=" + hasBomb + ", hasBeenOpened="
				+ hasBeenOpened + ", surroundingBombsCount=" + surroundingBombsCount + "]";
	};
	
	
}
