package minesweeper;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Grid grid = new Grid(3, 3);
		int maxTurns = (int) Math.pow(grid.getLength(), 2) - grid.getBombCount();
		int turnCount = 0;
		
		Scanner s = new Scanner(System.in);
		String userInput = "";
		
		while (userInput.toLowerCase() != "q" && turnCount < maxTurns) {
			System.out.println("Select a row: ");
			userInput = s.nextLine();
			int row = Integer.valueOf(userInput);
			System.out.println("Select a column: ");
			userInput = s.nextLine();
			int column = Integer.valueOf(userInput);
			grid.openCell(row, column);
			turnCount++;
			if (turnCount == maxTurns) {
				System.out.println("You have won!");
			}
		}
		
		s.close();
	}
	
}
