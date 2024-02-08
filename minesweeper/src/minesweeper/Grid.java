package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Grid {
	private ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();
	private int length = 10;
	private int bombCount = 10;
	private ArrayList<int[]> bombsCoordinates = new ArrayList<int[]>();
	
	public Grid() {	
		setBombsCoordinates();
		
		for (int i = 0; i < this.length; i++) {
			ArrayList<Cell> row = new ArrayList<Cell>();
			
			for (int j = 0; j < this.length; j++) {
				Cell cell = new Cell(i, j, false);
				row.add(cell);
			};
			
			grid.add(row);
		};
	};
	
	// TODO: generate unique random bomb coordinates
	private void setBombsCoordinates() {
		for (int i = 0; i < this.length; i++) {
			int[] bombCoordinate = {0, i};
			bombsCoordinates.add(bombCoordinate);
		};
		
//		int bombsSetCount = 0;
//		
//		for (int i = 0; i < this.length; i++) {
//			int[] dummyArray = {-1, -1};
//			bombsCoordinates.add(dummyArray);
//		};
//		
//		while (bombsSetCount < this.bombCount) {
//			int randomRow = new Random().nextInt(10 - 1 + 1) + 1;
//			int randomColumn = new Random().nextInt(10 - 1 + 1) + 1;
//			int[] bombCoordinate = {randomRow, randomColumn};
//			int index = 0;
//			
//			for (int[] coordinate : bombsCoordinates) {
//				if (coordinate[0] != bombCoordinate[0] && coordinate[1] != bombCoordinate[1]) {
//					this.bombsCoordinates.add(bombCoordinate); // FIXME: shouldn't be adding to list we're iterating through
//					++bombsSetCount;
//					System.out.println(Arrays.toString(bombCoordinate));
//				} else {					
//					System.out.println(String.format("Duplicate coordinate generated: %s", Arrays.toString(bombCoordinate)));
//				};
//				index++;
//			};
//			
//		};
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
				if (this.grid.get(j).get(i).getHasBeenOpened() == false) {
					System.out.print("|   ");
				} else {
					System.out.print("| x ");
				}
			};	
			
			// output | at end of row
			System.out.println("|");
		};
		
		// output horizontal grid line at the end of the grid
		System.out.println(generateTableLine());
	};
}
