package it.unibas.gol;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void validAliveCellShouldBeAlive() throws Exception {
		Cell cell = new Cell(0, 0, true);
		boolean alive = cell.isAlive();
		assertTrue(alive);
	}

	@Test(expected=CustomLifeException.class)
	public void testInvalidAliveCell() throws Exception {
		new Cell(-1, -1, true);
	}
	
	@Test(expected=CustomLifeException.class)
	public void testInvalidAliveCell2() throws Exception {
		new Cell(0, -1, true);
	}
	
	@Test
	public void cellShouldBeSet() throws Exception {
	Cell cell = new Cell(0, 0, true);
	cell.setAlive(false);
	boolean alive = cell.isAlive();
	assertFalse(alive);
	}

	@Test
	public void xCoordShouldBeGot() throws Exception {
	Cell cell = new Cell(10, 0, true);
	int x = cell.getX();
	assertEquals(10, x);
	}
	
	@Test
	public void yCoordShouldBeGot() throws Exception {
	Cell cell = new Cell(0, 10, true);
	int y = cell.getY();
	assertEquals(10, y);
	}
	
	@Test
	public void numberOfAliveNeighbordShouldBe4() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, true);
		cells[0][1] = new Cell(0,1, true);
		cells[1][0] = new Cell(1,0, true);
		cells[1][1] = new Cell(1,1, true);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		int number = cell.getNumberOfAliveNeighbords();
		
		assertEquals(3,number);
		}
	
	@Test
	public void aliveCellShouldSurvive() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, true);
		cells[0][1] = new Cell(0,1, true);
		cells[1][0] = new Cell(1,0, true);
		cells[1][1] = new Cell(1,1, true);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		assertTrue(cell.willSurvive());
		}
	
	@Test
	public void aliveCellShouldNotSurvive() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, false);
		cells[0][1] = new Cell(0,1, false);
		cells[1][0] = new Cell(1,0, false);
		cells[1][1] = new Cell(1,1, true);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		assertFalse(cell.willSurvive());
		}
	
	@Test
	public void deadCellShouldNotSurvive() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, false);
		cells[0][1] = new Cell(0,1, false);
		cells[1][0] = new Cell(1,0, false);
		cells[1][1] = new Cell(1,1, false);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		assertFalse(cell.willSurvive());
		}
	
	@Test
	public void aliveCellShouldDie() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, false);
		cells[0][1] = new Cell(0,1, false);
		cells[1][0] = new Cell(1,0, true);
		cells[1][1] = new Cell(1,1, true);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		assertTrue(cell.willDie());
		}
	
	@Test
	public void aliveCellShouldNotDie() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, false);
		cells[0][1] = new Cell(0,1, true);
		cells[1][0] = new Cell(1,0, true);
		cells[1][1] = new Cell(1,1, true);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		assertFalse(cell.willDie());
		}
	
	@Test
	public void deadCellShouldNotDie() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, false);
		cells[0][1] = new Cell(0,1, true);
		cells[1][0] = new Cell(1,0, true);
		cells[1][1] = new Cell(1,1, false);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		assertFalse(cell.willDie());
		}
	
	@Test
	public void deadCellShouldRevive() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, true);
		cells[0][1] = new Cell(0,1, true);
		cells[1][0] = new Cell(1,0, true);
		cells[1][1] = new Cell(1,1, false);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		assertTrue(cell.willRevive());
		}
	
	@Test
	public void aliveCellShouldNotRevive() throws Exception
	{
		
		Cell[][] cells = new Cell[2][2];
		cells[0][0] = new Cell(0, 0, true);
		cells[0][1] = new Cell(0,1, true);
		cells[1][0] = new Cell(1,0, true);
		cells[1][1] = new Cell(1,1, true);
		Cell cell = cells [1][1];
		cell.setNumberOfAliveNeighbors(cells);
		assertFalse(cell.willRevive());
		}
	
	@Test
	public void CellShouldNotBeNeighbors() throws Exception
	{
		Cell cell00 = new Cell(0,0,true);
		Cell cell24 = new Cell(2,4, true);
		boolean neighbor = cell00.isNeighboard(cell24);
		assertFalse(neighbor);

	}
}

