package tddmars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestPlanet {
	
Planet  x ;
/* 1.
 * Test
 * Requirement: Define a planet with x and y coordinates (where x=y). 
 * Define obstacles on the planet using the same coordinate system.  
 * Example: A planet has size 100x100. The cell at (45,67) is an obstacle. 
 */
	/*Refactor phase */
	@Before
	public void SetUp() throws WrongPlanetException
	{
		 x = new Planet(100, 100);
	}
	/* end refactor phase */
	
	@Test
	public void createAPlanet() throws WrongPlanetException
	{
		
	   boolean[][] planet = x.getPlanet();
	   assertEquals(200, (planet.length + planet[1].length));
	}
	
	@Test (expected = WrongPlanetException.class)
	public void createAWrongPlanet() throws WrongPlanetException
	{
		
	   new Planet(100, 120);
	   
	}
	
	@Test
	public void createAnObstacle() throws WrongPlanetException
	{
		
	   x.setPlanetObstacle(45, 67);
       assertTrue(x.isThereAnObstacle(45, 67));
	}
	@Test
	public void createAnObstacle2() throws WrongPlanetException
	{
		
	   x.setPlanetObstacle(99, 99);
       assertTrue(x.isThereAnObstacle(99, 99));
	}
	@Test
	public void createAnObstacle3() throws WrongPlanetException
	{
		
	   x.setPlanetObstacle(0, 0);
       assertTrue(x.isThereAnObstacle(0, 0));
	}
	
	@Test (expected = WrongPlanetException.class)
	public void createAnObstacleInWrongPosition() throws WrongPlanetException
	{
		
	   x.setPlanetObstacle(100, 67);
	}
	@Test
	public void getNotAnObstacle() throws WrongPlanetException
	{
		
       assertFalse(x.isThereAnObstacle(5, 67));
	}
	@Test
	public void getNotAnObstacleWrongPosition() throws WrongPlanetException
	{
		
       assertFalse(x.isThereAnObstacle(100, 67));
	}
	/*
	 * end test 1.
	 */
	
	

	
}
