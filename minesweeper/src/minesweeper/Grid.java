package minesweeper;

public class Grid {
	private int length;
	
	public Grid(int length) {
		this.length = length;
	}
	
	public String generateTopGridLine() {
		String topLine = "┌";
		for (int i = 1; i < this.length; i++) {
			topLine += "───┬";
		}
		topLine += "───┐";
		return topLine;
	}
	
	public String generateBottomGridLine() {
		String bottomLine = "└";
		for (int i = 1; i < this.length; i++) {
			bottomLine += "───┴";
		}
		bottomLine += "───┘";
		return bottomLine;
	}
	
	public String generateCellGridLines() {
		String cellLines = "│";
		for (int i = 1; i <= this.length; i++) {
			cellLines += "   │";
		}
		return cellLines;
	}
	
	public String generateMiddleGridLine() {
		String middleLine = "├";
		for (int i = 1; i < this.length; i++) {
			middleLine += "───┼";
		}
		middleLine += "───┤";
		return middleLine;
	}
	
	public void printGrid() {
		System.out.println(String.format("   %s", this.generateTopGridLine()));
		for (int i = 1; i < this.length; i++) {
			System.out.print(String.format(" %d ", i));
			System.out.println(this.generateCellGridLines());
			System.out.println(String.format("   %s", this.generateMiddleGridLine()));
		}
		System.out.println(String.format("%d %s", this.length, this.generateCellGridLines()));
		System.out.println(String.format("   %s", this.generateBottomGridLine()));
	}
}
