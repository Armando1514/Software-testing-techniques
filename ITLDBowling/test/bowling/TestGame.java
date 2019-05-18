package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGame {
	
	/* 3.
     * Define a game, which consists of 10 frames
     */
	
	@Test
	public void TestGameFrame() {
		
	   Game x = new Game();
	   
       assertEquals(10 , x.getFrames().length);
       
	}
	/*
	 * end 3.
	 */
	
	/*----------------------------------------------------------------------------*/
	/* 4.
	 * The score of a bowling game is the sum of the individual scores of its frames
	 */
	@Test
	public void TestGameScore10Frames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2, 6);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(81 , x.getScore());
       
	}
	
	@Test
	public void TestGameScore9Frames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   
       assertEquals(73 , x.getScore());
       
	}
	
	@Test
	public void TestGameScore5Frames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   
       assertEquals(41 , x.getScore());
       
	}
	
	@Test
	public void TestGameScore1Frame() throws InvalidNumberOfFramesException, InvalidNumberOfPinsException, InvalidBonusScore {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);

	   x.setFrames(one);
	   
       assertEquals(6 , x.getScore());
       
	}
	
	@Test
	public void TestGameScore0Frame() throws InvalidNumberOfFramesException {
		
	   Game x = new Game();

       assertEquals(0 , x.getScore());
       
	}
	
	@Test (expected = InvalidNumberOfFramesException.class)
	public void TestGameScore11Frame() throws Exception {
		
		   Game x = new Game();
		   Frame one = new Frame(1, 5);
		   Frame two = new Frame(3, 6);
		   Frame three = new Frame(7, 2);
		   Frame four = new Frame(3, 6);
		   Frame five = new Frame(4, 4);
		   Frame six = new Frame(5, 3);
		   Frame seven = new Frame(3, 3);
		   Frame eight = new Frame(4, 5);
		   Frame nine = new Frame(8, 1);
		   Frame ten = new Frame(2, 6);
           Frame eleven = new Frame(4, 5);

		   x.setFrames(one);
		   x.setFrames(two);
		   x.setFrames(three);
		   x.setFrames(four);
		   x.setFrames(five);
		   x.setFrames(six);
		   x.setFrames(seven);
		   x.setFrames(eight);
		   x.setFrames(nine);
		   x.setFrames(ten);
		   x.setFrames(eleven);
		   
	       assertEquals(81 , x.getScore());
       
	}
	/*
	 * end 4.
	 */
	
	/* 
	 * 5b.
	 * Test  the calculation of the score
	 * A frame is called a strike if all 10 pins are knocked down in the first throw. 
	 * In this case, there is no second throw. A strike frame can be written as [10, 0].
	 * The score of a strike equals 10 plus the sum of the next
	 * two throws of the subsequent frame. 
     * Requirement: Recognize a strike frame. 
     * Compute the score of a strike. Compute the score of a game containing a strike. 
	 */

	@Test
	public void TestGameStrikeCalculationWith5StrikeFrames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(2, 5);
	   Frame three = new Frame(10, 0);
	   Frame four = new Frame(1, 3);
	   Frame five = new Frame(10, 0);
	   Frame six = new Frame(2, 5);
	   Frame seven = new Frame(10, 0);
	   Frame eight = new Frame(3, 2);
	   Frame nine = new Frame(10, 0);
	   Frame ten = new Frame(2,4);

	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(108 , x.getScore());
       
	}
	
	
	
	@Test
	public void TestGameScore1Strike() throws InvalidNumberOfFramesException, InvalidNumberOfPinsException, InvalidBonusScore {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2, 6);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(94 , x.getScore());
       
	}
	/*
	 * end 5b.
	 */
	
	/*---------------------------------------------------------------------------*/
	
	/* 6b.
	 * Test if is a spare or not
	 * A frame is called a spare when all 10 pins are knocked down in two throws. 
	 * The score of a spare frame is 10 plus the value of the 
	 * first throw from the subsequent frame. 
     * Requirement: Recognize a spare frame. 
     * Compute the score of a spare. Compute the score of a game containing a spare frame. 
	 */
	@Test
	public void TestGameSpareCalculationWith10Frames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(5, 5);
	   Frame two = new Frame(5, 5);
	   Frame three = new Frame(4, 6);
	   Frame four = new Frame(3, 7);
	   Frame five = new Frame(2, 8);
	   Frame six = new Frame(8, 2);
	   Frame seven = new Frame(5, 5);
	   Frame eight = new Frame(1, 9);
	   Frame nine = new Frame(9, 1);
	   Frame ten = new Frame(5,5);
	   
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(142 , x.getScore());
       
	}
	
	@Test
	public void TestGameSpareCalculationWith9Frames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(5, 5);
	   Frame two = new Frame(8, 2);
	   Frame three = new Frame(4, 6);
	   Frame four = new Frame(3, 7);
	   Frame five = new Frame(4, 6);
	   Frame six = new Frame(3, 7);
	   Frame seven = new Frame(2, 8);
	   Frame eight = new Frame(8, 2);
	   Frame nine = new Frame(3, 7);
	   Frame ten = new Frame(2,4);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(133 , x.getScore());
       
	}
	
	@Test
	public void TestGameSpareCalculationWith5Frames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(5, 5);
	   Frame two = new Frame(3, 7);
	   Frame three = new Frame(4, 6);
	   Frame four = new Frame(5, 5);
	   Frame five = new Frame(4, 6);
	   Frame six = new Frame(2, 5);
	   Frame seven = new Frame(1, 3);
	   Frame eight = new Frame(2, 5);
	   Frame nine = new Frame(3, 2);
	   Frame ten = new Frame(2, 4);

	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(97 , x.getScore());
       
	}
	
	@Test
	public void TestGameSpareScore1Frame() throws InvalidNumberOfFramesException,InvalidBonusScore, InvalidNumberOfPinsException {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 9);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2, 6);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(88 , x.getScore());
       
	}
	

	/*
	 * end 6b.
	 */
	
	/*----------------------------------------------------------------------*/
	
	/*  7. Test
	 * 	Strike and Spare A strike can be followed by a spare. 
	 *  The strike’s score is not affected when this happens. 
	 */

	@Test
	public void TestGame1SpareAnd1StrikeScore() throws InvalidNumberOfFramesException, InvalidNumberOfPinsException, InvalidBonusScore {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 9);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2, 6);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(105, x.getScore());
       
	}
	
	@Test
	public void TestGame1StrikeAnd1SpareScore() throws InvalidNumberOfFramesException, InvalidNumberOfPinsException, InvalidBonusScore {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(4, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2, 6);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(103 , x.getScore());
       
	}
	
	/*
	 * end 7.
	 */
	
	/*------------------------------------------------------------------*/
	
	/*
	 * 8.
	 * Test if is a multiple strikes or not
	 * Two strikes in a row are possible. 
	 * You must take care when this happens for the computation of the first strike’s score
	 * requires the values of throws from two subsequent frames. 
     * Requirement: Compute the score of a strike that is followed by another strike.
     * Compute the score of a game with two strikes in a row. 
	 */
	@Test
	public void TestGameStrikeCalculationWith2StrikeConsecutiveFrames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2,6);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(112 , x.getScore());
       
	}
	
	@Test
	public void TestGameStrikeCalculationWith2StrikeConsecutiveFrames2() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(10, 0);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2,6);
     
       int result = (10 + 10 + 10 ) + (10 + 10 + 3) + (10 + 3 + 6) +
    		        (3 + 6) + (4 + 4) + (5 + 3) + (3 + 3) +
    		        (4 + 5) + (8 + 1) + (2 + 6);
       
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(result , x.getScore());
       
	}
	@Test
	public void TestGameStrikeCalculationWith9StrikeConsecutive() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(10, 0);
	   Frame four = new Frame(10, 0);
	   Frame five = new Frame(10, 0);
	   Frame six = new Frame(10, 0);
	   Frame seven = new Frame(10, 0);
	   Frame eight = new Frame(10, 0);
	   Frame nine = new Frame(10, 0);
	   Frame ten = new Frame(2,4);

	   int result = (10 + 10 + 10) + (10 + 10 + 10 ) + (10 + 10 + 10) + 
			        (10 + 10 + 10) + (10 + 10 + 10) + (10 + 10 + 10) + 
			        (10 + 10 + 10 ) + (10 + 10 + 2) + (10 + 2 + 4) +
			        (2 + 4);
			        

	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(result , x.getScore());
       
	}
	
	@Test
	public void TestGameStrikeCalculationWith9ConsecutiveStrike2() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(10, 0);
	   Frame four = new Frame(10, 0);
	   Frame five = new Frame(10, 0);
	   Frame six = new Frame(10, 0);
	   Frame seven = new Frame(10, 0);
	   Frame eight = new Frame(10, 0);
	   Frame nine = new Frame(9, 0);
	   Frame ten = new Frame(10,0);
	   
	   int result = (10 + 10 + 10) + (10 + 10 + 10) + (10 + 10 + 10) + 
		        (10 + 10 + 10 ) + (10 + 10 + 10) + (10 + 10 + 10) + 
		        (10 + 10 + 9 ) + (10 + 9) + (9) +
		        10;
		      
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(result , x.getScore());
       
	}
	
	@Test
	public void TestGameStrikeCalculationWith8ConsecutiveStrike() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(5, 0);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(10, 0);
	   Frame four = new Frame(10, 0);
	   Frame five = new Frame(10, 0);
	   Frame six = new Frame(10, 0);
	   Frame seven = new Frame(10, 0);
	   Frame eight = new Frame(10, 0);
	   Frame nine = new Frame(9, 0);
	   Frame ten = new Frame(10,0);
	   
	   int result = (5) + (10 + 10 + 10) + (10 + 10 + 10) + 
		        (10 + 10 + 10 ) + (10 + 10 + 10) + (10 + 10 + 10) + 
		        (10 + 10 + 9 ) + (10 + 9) + (9) +
		        10;
		      
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(result , x.getScore());
       
	}
	@Test
	public void TestGameStrikeCalculationWith3StrikesConsecutive() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(2, 5);
	   Frame four = new Frame(10, 0);
	   Frame five = new Frame(10, 0);
	   Frame six = new Frame(1, 3);
	   Frame seven = new Frame(10, 0);
	   Frame eight = new Frame(10, 0);
	   Frame nine = new Frame(3, 2);
	   Frame ten = new Frame(2,4);

  int result = (10 + 10 + 2) + (10 + 2 + 5) + (2 + 5) +
		       (10 + 10 + 1) + (10 + 1 + 3) + (1 + 3) +
		       (10 + 10 + 3) + (10 + 3 + 2) + (3 + 2) +
		       (2 + 4);
  
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(result , x.getScore());
       
	}
	/*
	 * end 8.
	 */
	
	/* 9.
	 * Test
	 * Two spares in a row are possible. The first spare’s score is not affected 
	 * when this happens. 
     * Requirement: Compute the score of a game with two spares in a row. 
	 */
	@Test
	public void TestGameSpareCalculationWith2SpareConsecutiveFrames() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(8, 2);
	   Frame two = new Frame(5, 5);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2,6);


	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(98 , x.getScore());
       
	}
	@Test
	public void TestGameSpareCalculationWith9SpareConsecutiveFrames() throws Exception {
		
		 Game x = new Game();
		 Frame one = new Frame(8, 2);
		 Frame two = new Frame(5, 5);
		 Frame three = new Frame(5, 5);
		 Frame four = new Frame(4, 6);
		 Frame five = new Frame(4, 6);
		 Frame six = new Frame(2, 8);
		 Frame seven = new Frame(3, 7);
		 Frame eight = new Frame(4, 6);
		 Frame nine = new Frame(5, 5);
		 Frame ten = new Frame(1,4);
		 
int result = (8 + 2 + 5) + (5 + 5 + 5) + (5 + 5 + 4) +
             (4 + 6 + 4) + (4 + 6 + 2) + (2 + 8 + 3) +
             (3 + 7 + 4) + (4 + 6 + 5) + (5 + 5 + 1) +
             (1 + 4);

	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(result , x.getScore());
       
	}
	/*
	 * end 9.
	 */
	
	/* 10.
	 * Test.
	 * not belong to a regular frame. 
	 * (NOTE: not belong, for my interpretation does it means a property, in java are
	 * Represented by variable, that i didn't use.)
	 * It is only used to calculate the score of the last spare. 
     * Requirement: Compute the score of a spare when it’s the last frame of a game. 
     * Compute the score of a game when its last frame is a spare. 
	 */
	@Test
	public void TestGameWithLastThrowSpare() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2, 8, 7);
       
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(90 , x.getScore());
       
	}
	@Test (expected = InvalidBonusScore.class)
	public void TestGameWithNotLastThrowSpare() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4, 7);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2, 8);
       
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       
	}

	/*
	 * end 10.
	 */
	
	/*
	 * 11.
	 * When a game’s last frame is a strike, the player will be
	 * given two bonus throws. 
	 * However, these two bonus throws do not belong to a regular frame.
	 * (NOTE: not belong, for my interpretation does it means a property, in java are
	 * Represented by variable, that i didn't use.)
	 * They are only used to calculate score of the last strike frame. 
	 */
	@Test
	public void TestGameWithLastThrowStrike() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(10, 0, 7, 2);
       
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(92 , x.getScore());
       
	}
	@Test (expected = InvalidBonusScore.class)
	public void TestGameWithNotLastThrowStrike() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4, 7, 2);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(2, 8);
       
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       
	}
	/*
	 * end 11.
	 */
	
	/*12.
	 *Test
	 *Further bonus throws are not granted when a game’s last frame 
	 *is a spare and the bonus throw is a strike. 
     *Requirement: Compute the score of a game in which the last frame 
     *is a spare and the bonus throw is a strike. 
	 */
	@Test
	public void TestGameWithLastThrowStrikeAndBonusStrike() throws Exception {
		
	   Game x = new Game();
	   Frame one = new Frame(1, 5);
	   Frame two = new Frame(3, 6);
	   Frame three = new Frame(7, 2);
	   Frame four = new Frame(3, 6);
	   Frame five = new Frame(4, 4);
	   Frame six = new Frame(5, 3);
	   Frame seven = new Frame(3, 3);
	   Frame eight = new Frame(4, 5);
	   Frame nine = new Frame(8, 1);
	   Frame ten = new Frame(10, 0, 10, 0);
       
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(93 , x.getScore());
       
	}
	@Test (expected = InvalidBonusScore.class)
	public void TestGameWithLastThrowStrikeAndBonusStrikeNoBonus() throws Exception {
		
		  Game x = new Game();
		   Frame one = new Frame(1, 5);
		   Frame two = new Frame(3, 6);
		   Frame three = new Frame(7, 2);
		   Frame four = new Frame(3, 6);
		   Frame five = new Frame(4, 4);
		   Frame six = new Frame(5, 3);
		   Frame seven = new Frame(3, 3);
		   Frame eight = new Frame(4, 5);
		   Frame nine = new Frame(8, 1);
		   Frame ten = new Frame(5, 5, 10, 3);
	       
		   x.setFrames(one);
		   x.setFrames(two);
		   x.setFrames(three);
		   x.setFrames(four);
		   x.setFrames(five);
		   x.setFrames(six);
		   x.setFrames(seven);
		   x.setFrames(eight);
		   x.setFrames(nine);
		   x.setFrames(ten);
	   
	}
	/*
	 * end 12.
	 */
	
	/* 13.
	 * Test
	 * best score, the total is 300
	 */
	@Test
	public void testBestScore() throws InvalidNumberOfPinsException, InvalidBonusScore, InvalidNumberOfFramesException {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(10, 0);
	   Frame four = new Frame(10, 0);
	   Frame five = new Frame(10, 0);
	   Frame six = new Frame(10, 0);
	   Frame seven = new Frame(10, 0);
	   Frame eight = new Frame(10, 0);
	   Frame nine = new Frame(10, 0);
	   Frame ten = new Frame(10, 0, 10, 10);
      
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(300 , x.getScore());
       
	}
	
	@Test
	public void testNearBestScore() throws InvalidNumberOfPinsException, InvalidBonusScore, InvalidNumberOfFramesException {
		
	   Game x = new Game();
	   Frame one = new Frame(10, 0);
	   Frame two = new Frame(10, 0);
	   Frame three = new Frame(10, 0);
	   Frame four = new Frame(10, 0);
	   Frame five = new Frame(10, 0);
	   Frame six = new Frame(10, 0);
	   Frame seven = new Frame(10, 0);
	   Frame eight = new Frame(10, 0);
	   Frame nine = new Frame(10, 0);
	   Frame ten = new Frame(10, 0, 10, 9);
      
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(299 , x.getScore());
       
	}
	

	/*
	 * end 13.
	 */
	
	
	/* 14.
	 * Requirement: Check that the score of the game 
	 * [6, 3] [7, 1] [8, 2] [7, 2] [10, 0] [6, 2] [7, 3] 
	 * [10, 0] [8, 0] [7, 3] [10] is 135. 
	 */
	@Test
	public void testExampleScore() throws InvalidNumberOfPinsException, InvalidBonusScore, InvalidNumberOfFramesException {
		
	   Game x = new Game();
	   Frame one = new Frame(6, 3);
	   Frame two = new Frame(7, 1);
	   Frame three = new Frame(8, 2);
	   Frame four = new Frame(7, 2);
	   Frame five = new Frame(10, 0);
	   Frame six = new Frame(6, 2);
	   Frame seven = new Frame(7, 3);
	   Frame eight = new Frame(10, 0);
	   Frame nine = new Frame(8, 0);
	   Frame ten = new Frame(7, 3, 10);
      
	   x.setFrames(one);
	   x.setFrames(two);
	   x.setFrames(three);
	   x.setFrames(four);
	   x.setFrames(five);
	   x.setFrames(six);
	   x.setFrames(seven);
	   x.setFrames(eight);
	   x.setFrames(nine);
	   x.setFrames(ten);
	   
       assertEquals(135 , x.getScore());
       
	}
	/*
	 * end 14
	 */
}
