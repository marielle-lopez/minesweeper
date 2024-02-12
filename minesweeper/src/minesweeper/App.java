package minesweeper;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Grid grid = new Grid();
		grid.printGrid();
		boolean isGameOver = false;
		String input = "";		
		Scanner s = new Scanner(System.in);
		
		while (isGameOver == false && !input.equalsIgnoreCase("q")) {
			String coordinate = "";

			System.out.println("Select a row (1 to 10): ");
			input = s.nextLine();
			coordinate += String.format("r%d", Integer.parseInt(input) - 1);
			
			System.out.println("Select a column (1 to 10): ");
			input = s.nextLine();
			coordinate += String.format("c%d", Integer.parseInt(input) - 1);
			
			isGameOver = grid.openCell(coordinate);
			grid.printGrid();
		}
		
		System.out.println("End of game.");
		s.close();
	}
	
}
