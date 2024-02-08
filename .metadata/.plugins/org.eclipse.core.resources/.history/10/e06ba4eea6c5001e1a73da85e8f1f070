package minesweeper;

import java.util.ArrayList;

public class Grid {
	private ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
	private int length = 10;
	
	public Grid() {
		for (int i = 0; i < this.length; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			
			for (int j = 0; j < this.length; j++) {
				row.add(-1);
			};
			
			grid.add(row);
		};
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
				if (this.grid.get(i).get(j) == -1) {
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
