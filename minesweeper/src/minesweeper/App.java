package minesweeper;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Grid grid = new Grid();
		int maxTurns = (int) Math.pow(grid.getLength(), 2) - grid.getLength();
		int turnsCount = 0;
		grid.printGrid(false);
		
//		for (Map.Entry<String, Cell> set: grid.getBombsCoordinates().entrySet()) {
//			System.out.println(set);
//		}
		
		boolean isGameOver = false;
		
		String input = "";		
		Scanner s = new Scanner(System.in);
		
		while (isGameOver == false && !input.equalsIgnoreCase("q") && turnsCount < maxTurns) {
			String coordinate = "";

			System.out.println("Select a row (1 to 10): ");
			input = s.nextLine();
			coordinate += String.format("r%d", Integer.parseInt(input) - 1);
			
			System.out.println("Select a column (1 to 10): ");
			input = s.nextLine();
			coordinate += String.format("c%d", Integer.parseInt(input) - 1);
			
			isGameOver = grid.openCell(coordinate);
			grid.printGrid(isGameOver);
			
			turnsCount++;
			
			if (turnsCount == maxTurns) {
				System.out.println("You've won!");
			}
		}
		
		System.out.println("End of game.");
		s.close();
	}
	
}
