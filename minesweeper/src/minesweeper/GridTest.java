package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GridTest {

	@Test
	void generateTopGridLine_LengthIs10_ReturnsTopLineString() {
		Grid grid = new Grid(10);
		String generatedTopLine = grid.generateTopGridLine();
		assertEquals("┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐", generatedTopLine);
	}
	
	@Test
	void generateTopGridLine_LengthIs5_ReturnsTopLineString() {
		Grid grid = new Grid(5);
		String generatedTopLine = grid.generateTopGridLine();
		assertEquals("┌───┬───┬───┬───┬───┐", generatedTopLine);
	}

	@Test
	void generateBottomGridLine_LengthIs10_ReturnsBottomLineString() {
		Grid grid = new Grid(10);
		String generatedBottomLine = grid.generateBottomGridLine();
		assertEquals("└───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘", generatedBottomLine);
	}
	
	@Test
	void generateBottomGridLine_LengthIs4_ReturnsBottomLineString() {
		Grid grid = new Grid(4);
		String generatedBottomLine = grid.generateBottomGridLine();
		assertEquals("└───┴───┴───┴───┘", generatedBottomLine);
	}
	
//	@Test
//	void generateCellGridLines_LengthIs5_ReturnsCellGridLinesString() {
//		Grid grid = new Grid(5);
//		String generatedCellLines = grid.generateCellGridLines();
//		assertEquals("│   │   │   │   │   │", generatedCellLines);
//	}
//	
//	@Test
//	void generateCellGridLines_LengthIs10_ReturnsCellGridLinesString() {
//		Grid grid = new Grid(10);
//		String generatedCellLines = grid.generateCellGridLines();
//		assertEquals("│   │   │   │   │   │   │   │   │   │   │", generatedCellLines);
//	}
	
	@Test 
	void generateMiddleGridLine_LengthIs10_ReturnsMiddleGridLineString() {
		Grid grid = new Grid(10);
		String generatedMiddleLine = grid.generateMiddleGridLine();
		assertEquals("├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤", generatedMiddleLine);
	}
	
	@Test
	void generateColumnGridLabels_LengthIs7_ReturnsColumnGridLabelsString() {
		Grid grid = new Grid(7);
		String columnLabels = grid.generateColumnGridLabels();
		assertEquals("     1   2   3   4   5   6   7", columnLabels);
	}
	
	@Test
	void generateRowGridLabel_RowIs1_ReturnsRowGridLabelString() {
		Grid grid = new Grid(10);
		String generatedRowLabel = grid.generateRowGridLabel(1);
		assertEquals(" 1 ", generatedRowLabel);
	}
	
	@Test
	void generateRowGridLabel_RowIs10_ReturnsRowGridLabelString() {
		Grid grid = new Grid(10);
		String generatedRowLabel = grid.generateRowGridLabel(10);
		assertEquals("10 ", generatedRowLabel);
	}
	
	@Test
	void generateRowCoordinatesList_RowIs1_ReturnsRowCoordinatesList() {
		Grid grid = new Grid(5);
		String[] coordinates = {"r1c1", "r1c2", "r1c3", "r1c4", "r1c5"};
		ArrayList<String> expected = new ArrayList<>(List.of(coordinates));
		ArrayList<String> actual = grid.generateRowCoordinatesList(1);
		assertEquals(expected, actual);
	}
}