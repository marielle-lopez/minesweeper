package minesweeper;

public class Cell {
	private int row;
	private int column;
	private boolean hasBomb = false;
	private int surroundingBombsCount;
	private boolean isOpen = false;
	
	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public boolean getHasBomb() {
		return hasBomb;
	}
	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	public int getSurroundingBombsCount() {
		return surroundingBombsCount;
	}
	public void setSurroundingBombsCount(int surroundingBombsCount) {
		this.surroundingBombsCount = surroundingBombsCount;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setIsOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public static String getBombSymbol() {
		return "x";
	}
	
	public static String getUnopenedSymbol() {
		return " ";
	}
	
	public static String getOpenedAndEmptySymbol() {
		return "-";
	}
}
