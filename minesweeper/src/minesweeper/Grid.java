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
	
	public String generateColumnGridLabels() {
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
	
	public String generateRowGridLabel(int rowNumber) {
		String rowLabel;
		if (rowNumber < 10) {
			rowLabel = String.format(" %d ", rowNumber);
		} else {
			rowLabel = String.format("%d ", rowNumber);
		}
		return rowLabel;
	}
	
	public void printGrid() {
		System.out.println(this.generateColumnGridLabels());
		System.out.println(String.format("   %s", this.generateTopGridLine()));
		for (int i = 1; i < this.length; i++) {
			System.out.print(this.generateRowGridLabel(i));
			System.out.println(this.generateCellGridLines());
			System.out.println(String.format("   %s", this.generateMiddleGridLine()));
		}
		System.out.print(this.generateRowGridLabel(this.length));
		System.out.println(this.generateCellGridLines());
		System.out.println(String.format("   %s", this.generateBottomGridLine()));
	}
}
