package tddmars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class TestRover {
	
private Rover x;
	/*refactor phase*/
	@Before
	public void SetUp() throws WrongPlanetException
	{
		x = new Rover(new Planet(4,4));
	}
	/* end refactor phase */
	
	/*
	 * 2. test
	 * Requirement: Define a planet as a square grid. 
	 * When the rover lands on the planet its status is (0,0) facing north.
	 * Example: An empty command (i.e., an empty string) to the rover results in returning his landing status, 
	 * i.e., the string “(0,0,N)
	 */
	@Test
	public void roverStartStatus() throws WrongPlanetException
	{
		
	   assertEquals("(0,0,N)",x.commandToRover());
	}
	
	@Test
	public void getPlanetExplored() throws WrongPlanetException
	{
		assertNotNull(x.getPlanetExplored());
	   
	}
	/*
	 * end 2.
	 */
	
	/*
	 *  3.
	 *  Test
	 *  Requirement: Compute the position of the rover after turning left l or right r.
	 *  Example: A rover in position (0,0,N) returns the string “(0,0,E)” --
	 *  i.e., its new position – after executing the command “r”.
	 *  On the other hand, a rover in position (0,0,N) returns the string “(0,0,W)” after executing the command “l”.
	 */
	@Test
	public void roverStatusAfterLeft() throws WrongPlanetException, RoverException
	{
		   assertEquals("(0,0,W)",x.commandToRover('l'));
	}
	
	@Test
	public void roverStatusAfterRight() throws WrongPlanetException, RoverException
	{
		
	   assertEquals("(0,0,E)",x.commandToRover('r'));
	}
	@Test
	public void roverStatusAfterRightTurningAround() throws WrongPlanetException, RoverException
	{
		x.commandToRover('r');
		x.commandToRover('r');
		x.commandToRover('r');
	   assertEquals("(0,0,N)",x.commandToRover('r'));
	}
	@Test
	public void roverStatusAfterLeftTurningAround() throws WrongPlanetException, RoverException
	{
		x.commandToRover('l');
		x.commandToRover('l');
		x.commandToRover('l');
	   assertEquals("(0,0,N)",x.commandToRover('l'));
	}
	
	@Test
	public void roverStatusAfterRightToLeft() throws WrongPlanetException, RoverException
	{
		x.commandToRover('r');
		x.commandToRover();
	    assertEquals("(0,0,W)", x.commandToRover('l'));
	}
	
	@Test
	public void roverStatusAfterLeftTToRight() throws WrongPlanetException, RoverException
	{
		x.commandToRover('l');
		x.commandToRover();
	    assertEquals("(0,0,E)", x.commandToRover('r'));
	}
	
	@Test (expected = RoverException.class)
	public void roverWrongCommandRight() throws WrongPlanetException, RoverException
	{
		x.commandToRover('a');
		x.commandToRover('r');
	}
	

	/*
	 * end 3.
	 */
	
	/* 4.
	 * Test
	 * Requirement: Compute the position of the rover after moving 
	 * forward of one cell forward on its direction on the grid. 
	 * Example: A rover in position (7,6,N) arrives at (7,7,N) -- 
	 * i.e., it returns the string “(7,7,N)” -- after executing an “f” command. 
	 */
	@Test
	public void roverMoveForward() throws RoverException 
	{
		assertEquals("(0,1,N)", x.commandToRover('f'));	
	}
	@Test
	public void roverMoveForwardLeft() throws RoverException 
	{
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('l');
		assertEquals("(3,2,W)", x.commandToRover('f'));	
	}
	
	@Test
	public void roverMoveForwardRight() throws RoverException 
	{
		x.commandToRover('r');

		assertEquals("(1,0,E)", x.commandToRover('f'));	
	}
	@Test
	public void roverMoveForward1() throws RoverException 
	{
		
		x.commandToRover('f');
		x.commandToRover('f');
		assertEquals("(0,3,N)", x.commandToRover('f'));	
	}
    /*
     * end 4.
     */
	
	/* 5.
	 * Test
	 *  The rover moves backward after receiving a “b” command. 
	 *  Requirement: Compute the position of the rover after
	 *  moving it one cell backward on its direction on the grid. 
	 * Example: A rover in position (5,8,E) arrives at (4,8,E) -- i.e., 
	 * it returns the string “(4,8,E)” -- after executing a “b” command. 
	 */
	@Test
	public void roverMoveBackward() throws RoverException 
	{
		assertEquals("(0,3,N)", x.commandToRover('b'));	
	}
	@Test
	public void roverMoveBackwardLeft() throws RoverException 
	{
		x.commandToRover('b');
		x.commandToRover('b');
		x.commandToRover('l');
		assertEquals("(1,2,W)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverMoveBackwardRight() throws RoverException 
	{
		x.commandToRover('r');

		assertEquals("(3,0,E)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverMoveBackward1() throws RoverException 
	{
		
		x.commandToRover('b');
		x.commandToRover('b');
		assertEquals("(0,1,N)", x.commandToRover('b'));	
	}
	
	/* 
	 * end 5.
	 */
	
	/* 6.
	 * Test
	 * The rover is able to execute a sequence of command “f”, “b”, “l”, “r”. 
	 * Requirement: Compute the position of the rover after executing a command in series.
	 * Example: A rover in position (0,0,N) arrives in position (2,2,E) -- 
	 * i.e., it returns the string “(2,2,E)” --  after executing the command “ffrff”
	 */
	@Test
	public void roverMoveCombined() throws RoverException 
	{

		assertEquals("(2,2,E)",x.commandToRover("ffrff"));	
	}
	@Test
	public void roverMovseCombined1() throws RoverException 
	{

		assertEquals("(2,2,N)",x.commandToRover("ffrff "));	
	}
	@Test
	public void roverMovseCombined2() throws RoverException 
	{

		assertEquals("(2,3,N)",x.commandToRover("ffrff f"));	
	}
	
	/*
	 * end 6.
	 */
	
	/* 7.
	 * Test
	 * Since the planet is a sphere the rover wraps at the opposite edge once it moves over it.
	 * Requirement: Compute the position of the rover moving beyond the edges. 
	 * The rover should spawn on the opposite side. 
	 * Example: A rover on a planet of 100x100 size, moves backward after landing (position (0,0,N))
	 * and arrives in position (0,99,N) -- i.e., it returns the string “(0,99,N)”
	 */
	@Test
	public void roverMoveForwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('f');
		x.commandToRover('f');
				
		
		assertEquals("(0,3,N)", x.commandToRover('f'));	
	}
	
	@Test
	public void roverMoveForwardUntilTheEndPlusOne() throws RoverException 
	{		
		
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		assertEquals("(0,0,N)", x.commandToRover('f'));	

	}
	@Test
	public void roverMoveLeftForwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover();
		x.commandToRover('l');
		x.commandToRover('f');
		x.commandToRover('f');
		
		assertEquals("(0,0,W)", x.commandToRover('f'));	
	}
	
	@Test
	public void roverMoveLeftForwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('l');

		assertEquals("(3,0,W)", x.commandToRover('f'));	

	}
	
	@Test
	public void roverMoveRightForwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('f');
		x.commandToRover('f');
		
		assertEquals("(3,0,E)", x.commandToRover('f'));	
	}
	
    @Test
	public void roverMoveRightForwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');

		assertEquals("(0,0,E)", x.commandToRover('f'));	

	}
	
	@Test
	public void roverBackwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('b');
		x.commandToRover('b');

		assertEquals("(0,0,N)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverBackwardUntilTheEndPlusOne() throws RoverException 
	{		
		
	
		assertEquals("(0,3,N)", x.commandToRover('b'));	

	}
	
	@Test
	public void roverMoveRightBackwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('b');
		x.commandToRover('b');
		x.commandToRover('b');
		x.commandToRover();
		x.commandToRover('l');
		x.commandToRover('b');
		x.commandToRover('b');
		
		assertEquals("(0,0,W)", x.commandToRover('b'));	
	}
	
	@Test
	public void roverMoveRightBackwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('r');

		assertEquals("(3,0,E)", x.commandToRover('b'));	

	}
	
	@Test
	public void roverMoveLeftBackwardUntilTheEnd() throws RoverException 
	{		
		x.commandToRover('l');
		x.commandToRover('b');
		x.commandToRover('b');
		
		assertEquals("(3,0,W)", x.commandToRover('b'));	
	}
	
    @Test
	public void roverMoveLeftBackwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('l');
		x.commandToRover('b');
		x.commandToRover('b');
		x.commandToRover('b');

		assertEquals("(0,0,W)", x.commandToRover('b'));	

	}
    
    @Test
	public void roverMoveRightForwardAndForwardUntilTheEndPlusOne() throws RoverException 
	{		
		x.commandToRover('r');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		
		x.commandToRover();
		
		x.commandToRover('f');
		x.commandToRover('f');
		x.commandToRover('f');
		
		assertEquals("(0,0,N)", x.commandToRover('f'));	

	}
	
	/* end 7. */
    
    
    /* 8.
     * Test
	 * The rover might encounter an obstacle. 
	 * When this happens, the rover cannot pass through the obstacle, 
	 * thus it reports the encountered obstacle and continues executing the remaining commands.
	 * If the same obstacle is encountered twice or more, it is reported only once.
	 * Requirement: Compute the position of a rover encountering an obstacle, and report the obstacle.
	 * Example: A rover is just landed (position (0,0,N)). 
	 * There is one obstacle on coordinates (2,2) of the planet. 
	 * The rover executes “ffrfff” and returns the string “(1,2,E)(2,2)”.
	 * Notice that the same obstacle is encountered twice but reported only once. 
	 */

    @Test
	public void roverObstacleDiscover() throws RoverException, WrongPlanetException 
	{		
		Planet planet = x.getPlanetExplored();
		planet.setPlanetObstacle(0, 3);
		x.commandToRover('f');
		x.commandToRover('f');	
		assertEquals("(0,2,N)(0,3)", x.commandToRover('f'));
	}
    
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame() throws RoverException, WrongPlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setPlanetObstacle(0, 3);
   		x.commandToRover('f');
   		x.commandToRover('f');	
   		x.commandToRover('f');	
   		assertEquals("(0,2,N)(0,3)", x.commandToRover('f'));
   	}
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame2() throws RoverException, WrongPlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setPlanetObstacle(0, 3);
   		x.commandToRover('f');
   		x.commandToRover('f');	
   		x.commandToRover('f');	
   		x.commandToRover('f');
   		assertEquals("(0,2,N)(0,3)", x.commandToRover('f'));
   	}
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame3() throws RoverException, WrongPlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setPlanetObstacle(0, 3);
   		x.commandToRover('b');
   		x.commandToRover('b');	
   		x.commandToRover('b');	
   		assertEquals("(0,0,N)(0,3)", x.commandToRover('b'));
   	}
	 // There is one obstacle on coordinates (2,2) of the planet. 
	 // The rover executes “ffrfff” and returns the string “(1,2,E)(2,2)”.
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame4() throws RoverException, WrongPlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setPlanetObstacle(2, 2);
   		assertEquals("(1,2,E)(2,2)", x.commandToRover("ffrfff"));
   	}
    /*
     * end 8.
     */
    
    /* 9.
     * Test
     * Requirement: Compute the position of the rover encountering obstacles,
     * and report the obstacles encountered in the correct order. 
     * Example: A rover is just landed (position (0,0,N)). 
     * There are two obstacles on coordinates (2,2) and (2,1) of the planet.
     * The rover executes “ffrfffrflf” and returns the string “(1,1,E)(2,2)(2,1)”. 
     * Notice that the first obstacle is encountered twice but reported only once. 
     * 
     */
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame5() throws RoverException, WrongPlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setPlanetObstacle(2, 2);
   		planet.setPlanetObstacle(2, 1);
   		assertEquals("(1,1,E)(2,2)(2,1)", x.commandToRover("ffrfffrflf"));
   	}
    /* End 9 */
    
    /*
     * 10.
     * Requirement: The rover tries to wrap at the opposite edge of the planet when moving beyond it,
     *  but there is an obstacle which prevents it from wrapping.  
     *  Example: On a planet of 10x10 size, there is one obstacle on (0,9).
     *  The rover is just landed (position (0,0,N)) and tries to execute “b”.
     *   The rover returns the string “(0,0,N)(0,9)”
     */
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame6() throws RoverException, WrongPlanetException 
   	{		
   		Planet planet = x.getPlanetExplored();
   		planet.setPlanetObstacle(0, 3);
   		assertEquals("(0,0,N)(0,3)", x.commandToRover("b"));
   	}
    /*
     * end 10.
     */
    
    
    /*
     * 11.
     * Requirement: Compute the position of a rover that executes a series of commands that result
     *  in moving along both axes in both directions, encountering several obstacles and wrapping from both 
     *  edges of the planet.  Example: The rover lands on a planet of 6x6 size with obstacles on (2,2), (0,5) and (5,0). 
     *  It executes the command “ffrfffrbbblllfrfrbbl” and returns the string “(0,0,N)(2,2)(0,5)(5,0)”. 
     */
    @Test
   	public void roverObstacleDiscoverMoreTimesTheSame7() throws RoverException, WrongPlanetException 
   	{	
    	// only here i waste the setup, but is not a great waste
    	x = new Rover(new Planet(6,6));
   		Planet planet = x.getPlanetExplored();
   		planet.setPlanetObstacle(2, 2);
   		planet.setPlanetObstacle(0, 5);
   		planet.setPlanetObstacle(5, 0);
   		assertEquals("(0,0,N)(2,2)(0,5)(5,0)", x.commandToRover("ffrfffrbbblllfrfrbbl"));
   	}
    /*
     * end 11.
     */
}
