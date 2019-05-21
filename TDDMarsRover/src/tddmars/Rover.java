package tddmars;

public class Rover {

	private int x;
	private int y;
	private char orientation;
    private Planet planet;
	
	/*
	 * 2. Implementation
	 * Requirement: Define a planet as a square grid. 
	 * When the rover lands on the planet its status is (0,0) facing north.
	 * Example: An empty command (i.e., an empty string) to the rover results in returning his landing status, 
	 * i.e., the string “(0,0,N)
	 */
	
	Rover(Planet planetExplored)
	{
		this.planet = planetExplored;
		this.setX(0);
		this.setY(0);
		this.setOrientation('N');
	}
	
	public String commandToRover() {
	this.setOrientation('N');
    return  "("+this.getX()+','+this.getY()+','+this.getOrientation()+')';
	
	}
	
	
	
	/* 6.
	 * Implementation
	 * The rover is able to execute a sequence of command “f”, “b”, “l”, “r”. 
	 * Requirement: Compute the position of the rover after executing a command in series.
	 * Example: A rover in position (0,0,N) arrives in position (2,2,E) -- 
	 * i.e., it returns the string “(2,2,E)” --  after executing the command “ffrff”
	 */
	public String commandToRover(String directionString) throws RoverException {	
		
		String storageReport="";
		int i = 0;
		for(i = 0; i < directionString.length() - 1; i++)
		{

			switch(directionString.charAt(i)) {
			
			case 'l':
				commandToRover(directionString.charAt(i));
				break;
			case 'r':
				commandToRover(directionString.charAt(i));
				break;
			case ' ':
				this.commandToRover();
				break;
			case 'f':
				String tmp = this.moveRoverForward();

				if((tmp != null) && (!(this.checkDuplicate(storageReport,tmp))))
				storageReport = storageReport + tmp;
	            break;
			
			case 'b':
				String tmp1 = this.moveRoverBackward();
				if((tmp1 != null) && (!(this.checkDuplicate(storageReport,tmp1))))
				storageReport = storageReport + tmp1;
	            break;
			    /*end implementation 5.*/	    
			default: 
				throw new RoverException("Only empty value, f, b, l or r is allowed to command the rover, exception.");
				
			}
		} 
		switch(directionString.charAt(i)) {
		
		case 'l':
			    return  commandToRover(directionString.charAt(i)) + storageReport;
		case ' ':
			return this.commandToRover() + storageReport;
		case 'r':
				return	commandToRover(directionString.charAt(i)) + storageReport;
			
		case 'f': 
			String tmp = this.moveRoverForward();
			if((tmp != null) && (!(this.checkDuplicate(storageReport,tmp))))
				storageReport = storageReport + tmp;
			
					return "("+this.getX()+','+this.getY()+','+this.getOrientation()+')' + storageReport 	;

		case 'b':
			String tmp1 = this.moveRoverBackward();
			if((tmp1 != null) && (!(this.checkDuplicate(storageReport,tmp1))))
				storageReport = storageReport + tmp1; 

				return	"("+this.getX()+','+this.getY()+','+this.getOrientation()+')' + storageReport 	;
					    /*end implementation 5.*/	    
		default: 
			throw new RoverException("Only empty value, f, b, l or r is allowed to command the rover, exception.");
			
		}
	}
	
	/*
	 *  end 6.
	 */
	
	/* implementation 8. */
	public boolean checkDuplicate(String storageReport, String path)
	{
	   int z = 0;
	   for(int i = 0; i < storageReport.length(); i++)
	   {
		   if(path.charAt(z) == storageReport.charAt(i))
			   z++;
		   if(z == 5)
			   return true;
		   if(z > 5)
			   z = 0;
	   }
	   return false;
	}
	/* end 8 */
	
	/*
	 *  3.
	 *  Test
	 *  Requirement: Compute the position of the rover after turning left l or right r.
	 *  Example: A rover in position (0,0,N) returns the string “(0,0,E)” --
	 *  i.e., its new position – after executing the command “r”.
	 *  On the other hand, a rover in position (0,0,N) returns the string “(0,0,W)” after executing the command “l”.
	 */
	public String commandToRover(char direction) throws RoverException {	
		
	switch(direction) {
	
	case 'l':
		this.setDirection(direction);
	    return  "("+this.getX()+','+this.getY()+','+this.getOrientation()+')';
	case 'r':
		this.setDirection(direction);
	    return  "("+this.getX()+','+this.getY()+','+this.getOrientation()+')';
	    /*Implementation 4. */
	case 'f':
		String tmp = this.moveRoverForward();
		
		return  (tmp == null) ? 
			    "("+this.getX()+','+this.getY()+','+this.getOrientation()+')'
				: 
				"("+this.getX()+','+this.getY()+','+this.getOrientation()+')' + tmp 	;
	
			
	    /*end implementation 4.*/
	    /*Implementation 5.*/
	case 'b':
		String tmp1= this.moveRoverBackward();
		return  (tmp1 == null) ? 
			    "("+this.getX()+','+this.getY()+','+this.getOrientation()+')'
				: 
				"("+this.getX()+','+this.getY()+','+this.getOrientation()+')' + tmp1 	;
	    /*end implementation 5.*/	    
	default: 
		throw new RoverException("Only empty value, f, b, l or r is allowed to command the rover, exception.");
		
	}

	}
	
	private void setDirection(char direction) throws RoverException
	{
		char d = this.getOrientation();
		
			switch(d) {
			case 'N':
				if(direction == 'l')
				this.setOrientation('W');
				if(direction == 'r')
	            this.setOrientation('E');
				break;
			case 'E':
				if(direction == 'l')
					this.setOrientation('N');
					if(direction == 'r')
		            this.setOrientation('S');
					break;
			case 'S':
				if(direction == 'l')
					this.setOrientation('E');
					if(direction == 'r')
		            this.setOrientation('W');
					break;
			case 'W':
				if(direction == 'l')
					this.setOrientation('S');
					if(direction == 'r')
		            this.setOrientation('N');
				break;
		    default :
			throw new RoverException("Value: "+this.getOrientation()+".right or left direction allowed, exception");
		}
			
	}
	
	/* 4.
	 * Test
	 * Requirement: Compute the position of the rover after moving 
	 * forward of one cell forward on its direction on the grid. 
	 * Example: A rover in position (7,6,N) arrives at (7,7,N) -- 
	 * i.e., it returns the string “(7,7,N)” -- after executing an “f” command. 
	 */
	/* Also implementation 8. */
	
	private String moveRoverForward() throws RoverException
	{
		switch(this.getOrientation()) {
		case 'N':
		if(!(isThereAnyObstacle(x, this.getY() + 1)))
		{
			this.setY(this.getY() + 1);
			return null;
		}
		else
			return "(" + this.getX() + ',' + (this.checkEdgeOfPlanet(this.getY() + 1)) + ')';
		
		case 'W':
			if(!(isThereAnyObstacle(this.getX() - 1, y)))
			{
				this.setX(this.getX() - 1);
				return null;
			}
			else
				return "(" + (this.checkEdgeOfPlanet(this.getX() - 1)) + ',' + this.getY() + ')';
		case 'S':
			if(!(isThereAnyObstacle(this.getY() - 1, y)))
			{

				this.setY(this.getY() - 1);

				return null;
			}
			else
				return "(" + this.getX() + ',' +(this.checkEdgeOfPlanet(this.getX() - 1))+ ')';
		case 'E':
			if(!(isThereAnyObstacle(this.getX() + 1, y)))
			{
				this.setX(this.getX() + 1);
				return null;
			}
			else
				return "(" + (this.checkEdgeOfPlanet(this.getX() + 1)) + ',' + this.getY() + ')';
		}
		
		throw new RoverException("Result not expected at line 124, exception");

	}
	
     /*
      * end 8.
      */
	/*
	 * end 4.
	 */
	
	/* 5.
	 * Implementation
	 *  The rover moves backward after receiving a “b” command. 
	 *  Requirement: Compute the position of the rover after
	 *  moving it one cell backward on its direction on the grid. 
	 * Example: A rover in position (5,8,E) arrives at (4,8,E) -- i.e., 
	 * it returns the string “(4,8,E)” -- after executing a “b” command. 
	 */
	private String moveRoverBackward() throws RoverException
	{
	
		switch(this.getOrientation()) {
		case 'N':
		if(!(isThereAnyObstacle(x, this.getY() - 1)))
		{
			this.setY(this.getY() - 1);
			return null;
		}
		else
			return "(" + this.getX() + ',' + (this.checkEdgeOfPlanet(this.getY() - 1)) + ')';
		
		case 'W':
			if(!(isThereAnyObstacle(this.getX() + 1, y)))
			{
				this.setX(this.getX() + 1);
				return null;
			}
			else
				return "(" + (this.checkEdgeOfPlanet(this.getX() + 1)) + ',' + this.getY() + ')';
		case 'S':
			if(!(isThereAnyObstacle(this.getY() + 1, y)))
			{
				this.setY(this.getY() + 1);
				return null;
			}
			else
				return "(" + this.getX() + ',' +(this.checkEdgeOfPlanet(this.getX() + 1))+ ')';
		case 'E':
			if(!(isThereAnyObstacle(this.getX() - 1, y)))
			{
				this.setX(this.getX() - 1);
				return null;
			}
			else
				return "(" + (this.checkEdgeOfPlanet(this.getX() - 1)) + ',' + this.getY() + ')';
		}
		
		throw new RoverException("Result not expected at line 124, exception");

	}
	/*
	 * end 5.
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		
		/* implementation 7.*/
		this.x = this.checkEdgeOfPlanet(x);
		/* end implementation 7*/

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		/* implementation 7.*/
		this.y = this.checkEdgeOfPlanet(y);
		/* end implementation 7*/
	}
	
	/* end 4. */
	
	/* end 3. */
	
	public Planet getPlanetExplored()
	{
	return this.planet;	
	}

	

	public char getOrientation() {
		return orientation;
	}

	private void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	
	
	/* end 2 */
	
	
	/* 7.
	 * Implementation
	 * Since the planet is a sphere the rover wraps at the opposite edge once it moves over it.
	 * Requirement: Compute the position of the rover moving beyond the edges. 
	 * The rover should spawn on the opposite side. 
	 * Example: A rover on a planet of 100x100 size, moves backward after landing (position (0,0,N))
	 * and arrives in position (0,99,N) -- i.e., it returns the string “(0,99,N)”
	 */
	private int checkEdgeOfPlanet(int value)
	{
		boolean[][] planet = this.getPlanetExplored().getPlanet();
		//matrix square
		if(planet.length <= value)
			return 0;
		else if (value < 0)
			return planet.length - 1;
		else
			return value;
	}
	/* end 7. */
	
	
	 /* 8.
     * Implementation
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
	private boolean isThereAnyObstacle(int x, int y) {
     	return this.getPlanetExplored().getPlanet()[this.checkEdgeOfPlanet(x)][this.checkEdgeOfPlanet(y)];
	}
	/*
	 * end 8.
	 */

	
}
