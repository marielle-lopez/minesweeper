package minesweeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Grid {
	private ArrayList<HashMap<String, Cell>> grid = new ArrayList<>();
	private int length = 10;
	private int bombCount = 10;
	private HashMap<String, Cell> bombsCoordinates = new HashMap<>();
	
	public Grid() {	
		for (int i = 0; i < this.length; i++) {
			HashMap<String, Cell> row = new HashMap<>();
			
			for (int j = 0; j < this.length; j++) {
				Cell cell = new Cell(i, j, false);
				row.put(String.format("r%dc%d", i, j), cell);
			};
			
			grid.add(row);
		};
		
		setBombsCoordinates();
	};
	
	public int getLength() {
		return this.length;
	}
	
	public boolean openCell(String coordinate) {
		int row = Integer.parseInt(String.valueOf(coordinate.charAt(1)));
		int column = Integer.parseInt(String.valueOf(coordinate.charAt(3)));
		
		if (grid.get(row).get(coordinate).getHasBomb() == true) {
			System.out.println("Bomb found!");
			return true;
		}
		
		grid.get(row).get(coordinate).setHasBeenOpened(true);
//		System.out.println(grid.get(row).get(coordinate));
		this.checkSurroundingCells(row, column);
		return false;
	}
	
	public HashMap<String, Cell> getBombsCoordinates() {
		return this.bombsCoordinates;
	}
	
	private void setBombsCoordinates() {
		Random random = new Random();
		
		int count = 0;
		while (count < this.bombCount) {
			int randomRow = random.nextInt(this.bombCount);
			int randomColumn = random.nextInt(this.bombCount);
			
			if (!this.bombsCoordinates.containsKey(String.format("r%dc%d", randomRow, randomColumn))) {
				this.grid.get(randomRow).get(String.format("r%dc%d", randomRow, randomColumn)).setHasBomb(true);
				this.bombsCoordinates.put(String.format("r%dc%d", randomRow, randomColumn), this.grid.get(randomRow).get(String.format("r%dc%d", randomRow, randomColumn)));
				count++;
			} else {
				System.out.println(String.format("Generated duplicate key: %s", String.format("r%dc%d", randomRow, randomColumn)));
			}
		}
		
		System.out.println("Bomb coordinates have been set.");
	};
	
	private String generateTableLine() {
		String line = "   ";
		
		for (int i = 0; i < this.length; i++) {
			line += "+---";
		};
		
		line += "+";
		
		return line;
	};
	
	public void printGrid(boolean displayBombs) {
		// output column headers
		for (int i = 0; i < this.length; i++) {
			if (i == 0) {
				System.out.print(String.format("     %d ", i + 1));
			} else {				
				System.out.print(String.format("  %d ", i + 1));
			}
		};
		
		// outputs newline to start printing grid below column headers
		System.out.println();
		
		// outputs the grid
		for (int i = 0; i < this.length; i++) {
			// outputs horizontal grid line
			System.out.println(generateTableLine());
			
			// looping through cells of row
			for (int j = 0; j < this.length; j++) {
				
				
				if (j == 0) {
					// output row header
					if (i < 9) {
						System.out.print(String.format(" %d ", i + 1));						
					} else {
						System.out.print(String.format("%d ", i + 1));	
					}
				};
				
				// output icon depending on cell's value
				Cell currentCell = this.grid.get(i).get(String.format("r%dc%d", i, j));
				
				if (currentCell.getHasBomb() && displayBombs == true) {
					System.out.print("| x ");
				} else if (currentCell.getHasBeenOpened()) {
					System.out.print(String.format("| %d ", currentCell.getSurroundingBombsCount()));
				} else {
					System.out.print("|   ");
				} 
			};	
			
			// output | at end of row
			System.out.println("|");
		};
		
		// output horizontal grid line at the end of the grid
		System.out.println(generateTableLine());
	};
	
	public void checkSurroundingCells(int row, int column) {
		int surroundingBombsCount = 0;
		int startingRow = row - 1;
		int startingColumn = column - 1;
		
		for (int i = startingRow; i < row + 2; i++) {
			if (i < 0) {
				i = 0;
			}
			
			if (i > this.length - 1) {
				break;
			}
			
			for (int j = startingColumn; j < column + 2; j++) {
				if (j < 0) {
					j = 0;
				}
				
				if (j > this.length - 1) {
					break;
				}
				
				if (i == row && j == column) {
					continue;
				}
				
				if (this.grid.get(i).get(String.format("r%dc%d", i, j)).getHasBomb()) {
					surroundingBombsCount++;
				}
				
				System.out.println(this.grid.get(i).get(String.format("r%dc%d", i, j)));
			}
		}
		
		this.grid.get(row).get(String.format("r%dc%d", row, column)).setSurroundingBombsCount(surroundingBombsCount);
		System.out.println(String.format("%d bombs!", surroundingBombsCount));
	}
}
