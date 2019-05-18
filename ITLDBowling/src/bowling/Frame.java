package bowling;

public class Frame {

	private int firstThrow;
	private int secondThrow;
	
	public Frame()
	{
		
	}
	
	public Frame(int firstThrow) throws InvalidNumberOfPinsException
	{
		
	this.setFirstThrow(firstThrow);	
	
	}
	
	public Frame(int firstThrow, int secondThrow) throws InvalidNumberOfPinsException
	{
		
	this.setFirstThrow(firstThrow);	
	this.setSecondThrow(secondThrow);
	
	}
	public Frame(int firstThrow, int secondThrow, int bonusThrow) throws InvalidNumberOfPinsException, InvalidBonusScore
	{
		
	this.setFirstThrow(firstThrow);	
	this.setSecondThrow(secondThrow);
	this.setBonusThrow(bonusThrow);
	
	}
	public Frame(int firstThrow, int secondThrow, int bonusThrow, int secondBonusThrow) throws InvalidNumberOfPinsException, InvalidBonusScore
	{
		
	this.setFirstThrow(firstThrow);	
	this.setSecondThrow(secondThrow);
	this.setDoubleBonusThrow(bonusThrow, secondBonusThrow);
	
	}
    /* 2.
     * Compute the score of an ordinary frame
     */
	public int getScore() {
		
		return this.getFirstThrow() + this.getSecondThrow();
	}
	/*
	 * end 2.
	 */
	
	/* 5a.
	 * A frame is called a strike if all 10 pins are knocked down in the first throw. 
	 * In this case, there is no second throw. A strike frame can be written as [10, 0].
	 * The score of a strike equals 10 plus the sum of the next
	 * two throws of the subsequent frame. 
     * Requirement: Recognize a strike frame. 
     * Compute the score of a strike. Compute the score of a game containing a strike. 
	 */
	public boolean isAStrike()
	{
		return (this.getFirstThrow() == 10) ? true : false;
		
	}
	/*
	 * end 5a. 5b is in the Game class, method getScore().
	 */
	
	/*
	 * end 5.
	 */
	
	/* 6a.
	 * Implementation
	 * A frame is called a spare when all 10 pins are knocked down in two throws. 
	 * The score of a spare frame is 10 plus the value of the 
	 * first throw from the subsequent frame. 
     * Requirement: Recognize a spare frame. 
     * Compute the score of a spare. Compute the score of a game containing a spare frame. 
	 */
	public boolean isASpare()
	{
		if(!this.isAStrike())
		    return (this.getScore() == 10) ? true : false;
		else
			return false;
	}
	/*
	 * end 6a. 6b is in the Game class, method getScore().
	 */
	

	/*-------------------------------------------------------*/

	/*
	 * 1.
	 * Each turn of a bowling game is called a frame. 10 pins are arranged in each frame
	 * Requirement: Define a frame as composed of two throws. 
	 * The first and second throws should be distinguishable 
	 * (i.e., it should be possible to get the first throw and the second throw). 
	 */
	public int getFirstThrow() {
		return firstThrow;
	}
	
	public void setFirstThrow(int firstThrow) throws InvalidNumberOfPinsException {
		this.firstThrow = firstThrow;
		
		if(firstThrow < 0)
			throw new InvalidNumberOfPinsException("Negative number for first throw, exception.");

		if( (this.getFirstThrow()) > 10)
			throw new InvalidNumberOfPinsException("More than 10 pins are down in the first throw, exception.");
	}
	
	public int getSecondThrow() {
		return secondThrow;
	}
	
	public void setSecondThrow(int secondThrow) throws InvalidNumberOfPinsException {
		this.secondThrow = secondThrow;
		
		
		if(secondThrow < 0)
			throw new InvalidNumberOfPinsException("Negative number for second throw, exception.");

		if( (this.getFirstThrow() + secondThrow) > 10)
			throw new InvalidNumberOfPinsException("More than 10 pins are down in both the throws, exception.");
		
		
	
	}
	/*
	 * end 1.
	 */
	
	/* 10a.
	 * Implementation if is a spare the last throw.
	 * not belong to a regular frame. 
	 * (NOTE: not belong, for my interpretation does it means a property, in java are
	 * Represented by variable, that i didn't use.)
	 * It is only used to calculate the score of the last spare. 
     * Requirement: Compute the score of a spare when it’s the last frame of a game. 
     * Compute the score of a game when its last frame is a spare. 
	 */
	public void setBonusThrow(int bonusThrow) throws InvalidBonusScore, InvalidNumberOfPinsException {
		
		if(this.getFirstThrow() + this.getSecondThrow() == 10)
		{
			if(bonusThrow <= 10)
			this.secondThrow = this.getSecondThrow() + bonusThrow;
			else
		    throw new InvalidNumberOfPinsException("More than 10 pins are down in both the throws, no more bonus, exception.");
	
		}
			
		else
			throw new InvalidBonusScore("The sum of your last score, is not 10 , no more bonus,  exception.");
		
	
	}
	/*
	 * end 10a, 10b in the Game class, method CheckValidValue.
	 */
	
	/*
	 * 11.
	 * Implementation
	 * When a game’s last frame is a strike, the player will be
	 * given two bonus throws. 
	 * However, these two bonus throws do not belong to a regular frame.
	 * (NOTE: not belong, for my interpretation does it means a property, in java are
	 * Represented by variable, that i didn't use.)
	 * They are only used to calculate score of the last strike frame. 
	 */
	public void setDoubleBonusThrow(int bonusThrow, int secondBonusThrow) throws InvalidBonusScore, InvalidNumberOfPinsException {
		
		if(this.getFirstThrow()  == 10)
		{
			if((bonusThrow) <= 10  && secondBonusThrow <= 10)
			this.secondThrow = this.getSecondThrow() + bonusThrow + secondBonusThrow;
			else
		    throw new InvalidNumberOfPinsException("More than 10 pins are down in the throw, no more bonus, exception.");
	
		}
			
		else
			throw new InvalidBonusScore("The sum of your last score, is not 10, no more bonus , exception.");
		
	
	}
	/*
	 * end 11.
	 */
	
}
