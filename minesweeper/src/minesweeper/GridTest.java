package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridTest {

	@Test
	void generateTopGridLine_LengthIs10_ReturnsTopLineString() {
		Grid grid = new Grid(10);
		String generatedTopLine = grid.generateTopGridLine();
		assertEquals("┌─┬─┬─┬─┬─┬─┬─┬─┬─┬─┐", generatedTopLine);
	}
	
	@Test
	void generateTopGridLine_LengthIs5_ReturnsTopLineString() {
		Grid grid = new Grid(5);
		String generatedTopLine = grid.generateTopGridLine();
		assertEquals("┌─┬─┬─┬─┬─┐", generatedTopLine);
	}

	@Test
	void generateBottomGridLine_LengthIs10_ReturnsBottomLineString() {
		Grid grid = new Grid(10);
		String generatedBottomLine = grid.generateBottomGridLine();
		assertEquals("└─┴─┴─┴─┴─┴─┴─┴─┴─┴─┘", generatedBottomLine);
	}
	
	@Test
	void generateBottomGridLine_LengthIs4_ReturnsBottomLineString() {
		Grid grid = new Grid(4);
		String generatedBottomLine = grid.generateBottomGridLine();
		assertEquals("└─┴─┴─┴─┘", generatedBottomLine);
	}
	
	@Test
	void generateCellGridLines_LengthIs5_ReturnsCellGridLinesString() {
		Grid grid = new Grid(5);
		String generatedCellLines = grid.generateCellGridLines();
		assertEquals("│ │ │ │ │ │", generatedCellLines);
	}
	
	@Test
	void generateCellGridLines_LengthIs10_ReturnsCellGridLinesString() {
		Grid grid = new Grid(10);
		String generatedCellLines = grid.generateCellGridLines();
		assertEquals("│ │ │ │ │ │ │ │ │ │ │", generatedCellLines);
	}
	
	@Test 
	void generateMiddleGridLine_LengthIs10_ReturnsMiddleGridLineString() {
		Grid grid = new Grid(10);
		String generatedMiddleLine = grid.generateMiddleGridLine();
		assertEquals("├─┼─┼─┼─┼─┼─┼─┼─┼─┼─┤", generatedMiddleLine);
	}
}