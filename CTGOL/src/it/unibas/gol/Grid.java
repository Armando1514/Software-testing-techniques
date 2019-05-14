package it.unibas.gol;


public class Grid {

	/***** API fields and constants *****/

	public static final Object DEAD = "-";
	public static final Object ALIVE = "*";

	private int width;
	private int height;
	private Cell[][] cells;
	
	/***** API method *****/

	public Grid(Cell[][] cells, int width, int height) throws CustomLifeException {
		if (height <= 0 || width <= 0) {
			throw new CustomLifeException("Invalid width or height");
		}
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Cell cell = cells[x][y];
				if (cell.getX() >= width || cell.getY() >= height) {
					throw new CustomLifeException("Cell out of bound");
				}
				if (cell.getX() != x || cell.getY() != y) {
					throw new CustomLifeException("Cell does not match the grid");
				}
			}
		}
		this.cells = cells;
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Grid tick() throws CustomLifeException {
		Grid newGrid = deepCopy();

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Cell cell = cells[x][y];
				cell.setNumberOfAliveNeighbors(cells);
				if (cell.willSurvive() || cell.willRevive()) {
					Cell newCell = newGrid.cellAt(x, y);
					newCell.setAlive(true);
				} else if (cell.willDie()) {
					Cell newCell = newGrid.cellAt(x, y);
					newCell.setAlive(false);
				}

			}
		}

		return newGrid;
	}
	
	
	public String getLife() {
		StringBuilder buffer = new StringBuilder();
		for (int y = height-1; y >= 0; y--) {
			for (int x = 0; x < width; x++) {
				if (cells[x][y].isAlive()) {
					buffer.append(ALIVE);
				} else {
					buffer.append(DEAD);
				}
				if (x == width - 1) {
					buffer.append("\n");
				}
			}
		}
		return buffer.toString().trim();
	}

	public Cell cellAt(int x, int y) {
		return cells[x][y];
	}

	public int numberOfAliveCells() {
		int count = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (cells[x][y].isAlive()) {
					count++;
				}
			}
		}
		return count;
	}

	public int numberOfDeadCells() {
		int count = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (!cells[x][y].isAlive()) {
					count++;
				}
			}
		}
		return count;
	}

	/***** Other Methods *****/
	
	private Grid deepCopy() throws CustomLifeException {
		Cell[][] cellsCopy = new Cell[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Cell cell = cells[x][y];
				cellsCopy[x][y] = new Cell(cell.getX(), cell.getY(), cell.isAlive());
			}
		}
		return new Grid(cellsCopy, width, height);
	}

}
