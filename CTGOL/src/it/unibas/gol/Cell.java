package it.unibas.gol;

public class Cell {
	
	/***** API fields *****/
	private int x; 
	private int y; 
	private boolean alive;
	private int numberOfAliveNeighbords;
	
	/***** API method *****/
	
	public Cell(int x, int y, boolean b) throws CustomLifeException {
		if(x < 0 || y < 0){
			throw new CustomLifeException("Negative Coord");
		}
		this.x = x;
		this.y = y;
		this.alive = b;		
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setNumberOfAliveNeighbors(Cell[][] cells) {
		int counter = 0;		
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				Cell cell = cells[x][y];
				if(this.isNeighboard(cell) && cell.isAlive()){
					counter++;
				}
			}
		}
		numberOfAliveNeighbords = counter;
	}
	
	public int getNumberOfAliveNeighbords() {
		return numberOfAliveNeighbords;
	}
	
	public boolean willSurvive() {
		if(isAlive()){
			if ((Integer)getNumberOfAliveNeighbords() == 2 || (Integer)getNumberOfAliveNeighbords() == 3){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean willDie() {
		if(isAlive()){
			if ((Integer)getNumberOfAliveNeighbords() < 2 || (Integer)getNumberOfAliveNeighbords() > 3){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean willRevive() {
		if(!isAlive() && (Integer)getNumberOfAliveNeighbords()==3){
			return true;
		}		
		return false;
	}
	
	public boolean isNeighboard(final Cell cell){
		int xDiff = Math.abs(x - cell.getX());
		int yDiff = Math.abs(y - cell.getY());
		if(xDiff==0 && yDiff==0){ // Same cells
			return false;
		}
		if(xDiff<=1 && yDiff<=1){
			return true;
		}
		return false;
	}	
	
}

