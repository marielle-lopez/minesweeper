package minesweeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Grid {
	private int length;
	private HashMap<String, Cell> grid = new HashMap<>();
	private ArrayList<String> bombCoordinates = new ArrayList<>();
	private int bombCount = 10;
	
	public Grid(int length) {
		this.length = length;
		this.generateCells();
		this.generateRandomBombCoordinates();
		this.printGrid();
	}
	
	public Grid(int length, int bombCount) {
		this.length = length;
		this.bombCount = bombCount;
		this.generateCells();
		this.generateRandomBombCoordinates();
		this.printGrid();
	}
	
	public int getLength() {
		return this.length;
	}
	
	public int getBombCount() {
		return this.bombCount;
	}
	
	private void generateCells() {
		for (int i = 1; i <= this.length; i++) {
			for (int j = 1; j <= this.length; j++) {
				String coordinate = String.format("r%dc%d", i, j);
				Cell cell = new Cell(i, j);
				this.grid.put(coordinate, cell);
			}
		}
	}
	
	private void generateRandomBombCoordinates() {
		int generatedBombLocationsCount = 0;
		Random random = new Random();
		while (generatedBombLocationsCount < this.bombCount) {			
			int randomRow = random.nextInt(this.length) + 1;
			int randomColumn = random.nextInt(this.length) + 1;
			String randomCoordinate = String.format("r%dc%d", randomRow, randomColumn);
			if (!this.bombCoordinates.contains(randomCoordinate)) {
				this.bombCoordinates.add(randomCoordinate);
				this.grid.get(randomCoordinate).setHasBomb(true);
				generatedBombLocationsCount++;
			}
		}
	}
	
	protected String generateTopGridLine() {
		String topLine = "┌";
		for (int i = 1; i < this.length; i++) {
			topLine += "───┬";
		}
		topLine += "───┐";
		return topLine;
	}
	
	protected String generateBottomGridLine() {
		String bottomLine = "└";
		for (int i = 1; i < this.length; i++) {
			bottomLine += "───┴";
		}
		bottomLine += "───┘";
		return bottomLine;
	}
	
	private String generateCellGridLines(ArrayList<String> rowCoordinates) {
		String cellLines = "";
		for (String cellCoordinate: rowCoordinates) {
			Cell currentCell = this.grid.get(cellCoordinate);
			String symbolToDisplay = "";
			if (currentCell.getHasBomb()) {
				symbolToDisplay = Cell.getBombSymbol();
			} else if (currentCell.isOpen()) {
				symbolToDisplay = Integer.toString(currentCell.getSurroundingBombsCount());
			} else {
				symbolToDisplay = Cell.getUnopenedSymbol();
			}
			cellLines += String.format("│ %s ", symbolToDisplay);
		}
		cellLines += "│";
		return cellLines;
	}
	
	protected String generateMiddleGridLine() {
		String middleLine = "├";
		for (int i = 1; i < this.length; i++) {
			middleLine += "───┼";
		}
		middleLine += "───┤";
		return middleLine;
	}
	
	protected String generateColumnGridLabels() {
		String columnLabels = "  ";
		for (int i = 1; i <= this.length; i++) {
			if (i < 10) {				
				columnLabels += String.format("   %s", i);
			} else {
				columnLabels += String.format("  %s", i);
			}
		}
		return columnLabels;
	}
	
	protected String generateRowGridLabel(int rowNumber) {
		String rowLabel;
		if (rowNumber < 10) {
			rowLabel = String.format(" %d ", rowNumber);
		} else {
			rowLabel = String.format("%d ", rowNumber);
		}
		return rowLabel;
	}
	
	protected ArrayList<String> generateRowCoordinatesList(int rowNumber) {
		ArrayList<String> rowCoordinates = new ArrayList<>();
		for (int i = 1; i <= this.length; i++) {
			String coordinate = String.format("r%dc%d", rowNumber, i);
			rowCoordinates.add(coordinate);
		}
		return rowCoordinates;
	}
	
	private void printGrid() {
		System.out.println(this.generateColumnGridLabels());
		System.out.println(String.format("   %s", this.generateTopGridLine()));
		for (int i = 1; i < this.length; i++) {
			ArrayList<String> rowCoordinates = this.generateRowCoordinatesList(i);
			System.out.print(this.generateRowGridLabel(i));
			System.out.println(this.generateCellGridLines(rowCoordinates));
			System.out.println(String.format("   %s", this.generateMiddleGridLine()));
		}
		System.out.print(this.generateRowGridLabel(this.length));
		ArrayList<String> rowCoordinates = this.generateRowCoordinatesList(this.length);
		System.out.println(this.generateCellGridLines(rowCoordinates));
		System.out.println(String.format("   %s", this.generateBottomGridLine()));
	}
	
	public boolean openCell(int row, int column) {
		String selectedCoordinate = String.format("r%dc%d", row, column);
		Cell selectedCell = this.grid.get(selectedCoordinate);
		selectedCell.setIsOpen(true);
		if (selectedCell.getHasBomb()) {
			this.printGrid();
			System.out.println("End of game.");
			return true;
		}
		int surroundingBombsCount = this.checkSurroundingCells(row, column);
		selectedCell.setSurroundingBombsCount(surroundingBombsCount);
		this.printGrid();
		return false;
	}
	
	private int checkSurroundingCells(int row, int column) {
		String selectedCoordinate = String.format("r%dc%d", row, column);
		int surroundingBombsCount = 0;
		int startingRow = row - 1;
		int startingColumn = column - 1;
		int endingRow = startingRow + 3;
		int endingColumn = startingColumn + 3;
		for (int i = startingRow; (i < endingRow) && (i <= this.length); i++) {
			if (i < 1) {
				i = 1;
			}
			for (int j = startingColumn; (j < endingColumn) && (j <= this.length); j++) {
				if (j < 1) {
					j = 1;
				}
				String currentCoordinate = String.format("r%dc%d", i, j);
				if (!currentCoordinate.equals(selectedCoordinate)) {
					if (this.grid.get(currentCoordinate).getHasBomb()) {
						surroundingBombsCount++;
					}					
				}
			}
		}
		return surroundingBombsCount;
	}
}
