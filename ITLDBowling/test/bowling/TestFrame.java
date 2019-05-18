package bowling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestFrame {
	
	private Frame x;
	@Before
	public void setUp()
	{
		x = new Frame();
	}
	/*
	 * 1.
	 * Each turn of a bowling game is called a frame. 10 pins are arranged in each frame
	 * Requirement: Define a frame as composed of two throws. 
	 * The first and second throws should be distinguishable 
	 * (i.e., it should be possible to get the first throw and the second throw). 
	 */
	@Test
	public void testResultOfTheFirstThrow() throws InvalidNumberOfPinsException
	{
		
		x.setFirstThrow(3);
		
		assertEquals(3,x.getFirstThrow());
	}
	
	@Test
	public void testResultOfTheFirstThrow2() throws InvalidNumberOfPinsException
	{
		
		x.setFirstThrow(0);
		
		assertEquals(0,x.getFirstThrow());
	}
	
	@Test
	public void testResultOfTheFirstThrow3() throws InvalidNumberOfPinsException
	{
		
		x.setFirstThrow(10);
		
		assertEquals(10,x.getFirstThrow());
	}

	@Test
	public void testResultOfTheSecondThrow() throws InvalidNumberOfPinsException
	{
		
		x.setSecondThrow(5);
		
		assertEquals(5 , x.getSecondThrow());
	}
	
	@Test
	public void testResultOfTheSecondThrow2() throws InvalidNumberOfPinsException
	{
		
		x.setSecondThrow(0);
		
		assertEquals(0 , x.getSecondThrow());
	}
	
	@Test
	public void testResultOfTheSecondThrow10() throws InvalidNumberOfPinsException
	{
		
		x.setSecondThrow(10);
		
		assertEquals(10 , x.getSecondThrow());
	}
	
	
	
	@Test(expected = InvalidNumberOfPinsException.class)
	public void testNegativeResultOfTheFirstThrow() throws InvalidNumberOfPinsException
	{
		
		x.setFirstThrow(-1);
		
	}
	
	@Test(expected = InvalidNumberOfPinsException.class)
	public void testBiggetThen10ResultOfTheFirstThrow() throws InvalidNumberOfPinsException
	{
		
		x.setFirstThrow(11);
		
	}
	
	@Test(expected = InvalidNumberOfPinsException.class)
	public void testNegativeResultOfTheSecondThrow() throws InvalidNumberOfPinsException
	{
		
		x.setSecondThrow(-1);
		
	}
	
	@Test(expected = InvalidNumberOfPinsException.class)
	public void testHigherThen10ResultOfTheSecondThrow() throws InvalidNumberOfPinsException
	{
		
		x.setSecondThrow(11);
		
	}
	
	@Test(expected = InvalidNumberOfPinsException.class)
	public void testHigherThen10ResultOfTheSecondAndFirstThrow() throws InvalidNumberOfPinsException
	{
		x.setFirstThrow(5);
		x.setSecondThrow(6);
		
	}
	
	/*
	 * end 1.
	 */
	
	/*--------------------------------------------------------------------------------------*
	
    /* 2.
     * Compute the score of an ordinary frame
     */
	@Test
	public void TestgetScore() throws InvalidNumberOfPinsException {
		
	   
	   x.setFirstThrow(2);
	   
	   x.setSecondThrow(6);
	   
       assertEquals(8 , x.getScore());
	}
	/*
	 * end 2.
	 */
	
	/* 
	 * 5a.
	 * Test if is a strike or not
	 * A frame is called a strike if all 10 pins are knocked down in the first throw. 
	 * In this case, there is no second throw. A strike frame can be written as [10, 0].
	 * The score of a strike equals 10 plus the sum of the next
	 * two throws of the subsequent frame. 
     * Requirement: Recognize a strike frame. 
     * Compute the score of a strike. Compute the score of a game containing a strike. 
	 */
	@Test
	public void TestIsAStrike() throws InvalidNumberOfPinsException {
		
	   
	   x.setFirstThrow(10);
	   
	   x.setSecondThrow(0);
	   
       assertTrue(x.isAStrike());
	}

	@Test
	public void TestIsNotAStrike() throws InvalidNumberOfPinsException {
		
	   
	   x.setFirstThrow(5);
	   
	   x.setSecondThrow(5);
	   
       assertFalse(x.isAStrike());
	}
	/*
	 * end 5a.
	 */
	
	/*------------------------------------------------------------------------------*/
	
	/* 6a.
	 * Test if is a spare or not
	 * A frame is called a spare when all 10 pins are knocked down in two throws. 
	 * The score of a spare frame is 10 plus the value of the 
	 * first throw from the subsequent frame. 
     * Requirement: Recognise a spare frame. 
     * Compute the score of a spare. Compute the score of a game containing a spare frame. 
	 */
	@Test
	public void TestIsASpare() throws InvalidNumberOfPinsException {
		
	   
	   x.setFirstThrow(4);
	   
	   x.setSecondThrow(6);
	   
       assertTrue(x.isASpare());
	}

	@Test
	public void TestIsNotASpare() throws InvalidNumberOfPinsException {
		
	   Frame x = new Frame();
	   
	   x.setFirstThrow(4);
	   
	   x.setSecondThrow(5);
	   
       assertFalse(x.isASpare());
	}
	/*
	 * end 6a.
	 */
	
	
	
	
	
}
