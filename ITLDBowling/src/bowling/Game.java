package bowling;

public class Game {
  
	private Frame[] frames;

	
    /* 
	* 3.1
	* Define a game, which consists of 10 frames
	*/
	
	public Game()
	{
		frames = new Frame [10];
	}
	
	/* 
	 * end 3a, there is down 3b.
	 * 
	 */
/*---------------------------------------------------------------------------------*/	
	
	/* 4.
	 * The score of a bowling game is the sum of the individual scores of its frames
	 */
	
	public int getScore()
	{
		int sum = 0;
		
		Frame[] x = this.getFrames();
		
		for(int i=0; i < 10; i++)
		{
			if(x[i] != null)
			{
			/*  7. Implementation
	         * 	Strike and Spare A strike can be followed by a spare. 
	         *  The strike’s score is not affected when this happens. 
			/*
			 *  5b.
			 * Implementation
	         * A frame is called a strike if all 10 pins are knocked down in the first throw. 
	         * In this case, there is no second throw. A strike frame can be written as [10, 0].
	         * The score of a strike equals 10 plus the sum of the next
	         * two throws of the subsequent frame. 
             * Requirement: Recognize a strike frame. 
             * Compute the score of a strike. Compute the score of a game containing a strike. 
	         */
			  if(i < 9  && x[i].isAStrike())
			  {   
				    /*
					 * 8b.
					 * implementation calculation multiple strikes 
					 * Two strikes in a row are possible. 
					 * You must take care when this happens for the computation of the first strike’s score
					 * requires the values of throws from two subsequent frames. 
				     * Requirement: Compute the score of a strike that is followed by another strike.
				     * Compute the score of a game with two strikes in a row. 
					 */		
				     if(this.isAMultipleStrikes(i) && i < 8)
				     {
				    		sum = sum + 10 + 10 + x[i+2].getFirstThrow();

				     }
				     /*
				      * end 8b.
				      */
				     else 
				     {
				      if(i < 8 || (!x[i+1].isAStrike()))
				      sum = sum + x[i].getScore() + x[i+1].getScore();
				      else 
				      {
				    	  if(x[i+1].getSecondThrow() > 10)
					      sum = sum + x[i].getScore() + x[i+1].getFirstThrow() + 10 ;
				      }

				     }
			  }
			  /*
			   * end 5b.
			   */
			  
				/* 6a.
				 * Implementation
				 * A frame is called a spare when all 10 pins are knocked down in two throws. 
				 * The score of a spare frame is 10 plus the value of the 
				 * first throw from the subsequent frame. 
			     * Requirement: Recognise a spare frame. 
			     * Compute the score of a spare. Compute the score of a game containing a spare frame. 
				 */
			  else if(i < 9 && x[i+1] != null && x[i].isASpare())
				  sum = sum + x[i].getScore() + x[i+1].getFirstThrow();
			  
			     /*
			      * end 6a.
			      */ 
			  
			     /*
			      * end 7.
			      */
			  else 
				  sum = sum + x[i].getScore();
			  
			   System.out.println(i+" "+sum);


			}

		}
				
	    return sum;
	}
	
	/*
	 * end 4.
	 */
	
	/*------------------------------------------------------------------------------------*/
	
	/*
	 * 8a.
	 * implementation if is a multiple strikes or not
	 * Two strikes in a row are possible. 
	 * You must take care when this happens for the computation of the first strike’s score
	 * requires the values of throws from two subsequent frames. 
     * Requirement: Compute the score of a strike that is followed by another strike.
     * Compute the score of a game with two strikes in a row. 
	 */
	public boolean isAMultipleStrikes(int i)
	{
		Frame[] x = this.getFrames();
		
		return (x[i].isAStrike() && x[i+1].isAStrike()) ? true : false;
	
	}
	/*
	 * end 8a, 8b in this class, method getScore().
	 */
	
	/* 
	* 3.b
	* Define a game, which consists of 10 frames
	*/
	public Frame[] getFrames() {
		return frames;
	}

	public void setFrames(Frame frames) throws InvalidNumberOfFramesException, InvalidBonusScore {
		
		int i = 0;
		Frame[] x = this.getFrames();
		
		while(i < 10 && i != -1)
		{
			if(x[i] == null)
			{ 
			 /* 10c.
			  * Implementation
	          * (NOTE: not belong, for my interpretation does it means a property, in java are
	          * represented by variable, that i didn't use.) 
			  * not belong to a regular frame. 
		      * It is only used to calculate the score of the last spare. 
			  * Requirement: Compute the score of a spare when it’s the last frame of a game. 
			  * Compute the score of a game when its last frame is a spare. 
			  */
			  this.CheckValidValue(frames, i);
			  /*
		       * end 10c.
		       */
		      x[i] = frames;
		      frames = null;
		      i = -2;
		      
			}
			
			i++;
		}
		
		
		if(i >= 10)
			throw new InvalidNumberOfFramesException("More then 10 frames in a single game, exception.");
		
	}
	
	/* end 3. */
	
	/* 10b.
	 * Implementation 
	 * (NOTE: not belong, for my interpretation does it means a property, in java are
	 * represented by variable, that i didn't use.)
	 * not belong to a regular frame. 
	 * It is only used to calculate the score of the last spare. 
     * Requirement: Compute the score of a spare when it’s the last frame of a game. 
     * Compute the score of a game when its last frame is a spare. 
	 */
	public void CheckValidValue(Frame x, int position) throws InvalidBonusScore  {
		if(x.getScore() > 10 && position != 9)
			throw new InvalidBonusScore("Only for the last score, in case of spare or strike, is allowed a bonus throw, exception.");
         
	}
	/*
	 * end 10b, 10c in the method setFrames().
	 */
	
}
