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
	
	public void openCell(String coordinate) {
		int row = Integer.parseInt(String.valueOf(coordinate.charAt(1)));
		grid.get(row).get(coordinate).setHasBeenOpened(true);
		System.out.println(grid.get(row).get(coordinate));
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
	
	public void printGrid() {
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
				if (currentCell.getHasBomb()) {
					System.out.print("| x ");
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
}
