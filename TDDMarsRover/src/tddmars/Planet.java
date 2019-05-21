package tddmars;

public class Planet {
	
	
	/* 1.
	 * Implementation
	 * Requirement: Define a planet with x and y coordinates (where x=y). 
	 * Define obstacles on the planet using the same coordinate system.  
	 * Example: A planet has size 100x100. The cell at (45,67) is an obstacle. 
	 */
	private boolean[][] planet;
	
	public Planet(int x, int y) throws WrongPlanetException {
     
		if(x != y)
			throw new WrongPlanetException("x is different than y, exception.");
		planet = new boolean[x][y];
	
	}

	public boolean[][] getPlanet() {
		return planet;
	}

	public void setPlanetObstacle(int x, int y) throws WrongPlanetException {
		if(x < planet.length  && y < planet[1].length )
		planet[x][y] = true;
		else
		throw new WrongPlanetException("Is not possible set an obstacle in this position, data overflow in the array, exception.");
	
	}

	public boolean isThereAnObstacle(int x, int y) {
		if(x < planet.length && y < planet[1].length)
			return (planet[x][y] == true) ? true : false;
		else
			return false;
	}
/*
 * end 1.
 */
	
}
