package it.unibas.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibas.tennisgame.Player;


public class PlayerTest{
	
	public static String FEDERER="Federer";
	public static String NADAL="Nadal";

		@Test
		public void testPlayerName() {

			// Arrangs
		    Player player = new Player(FEDERER,8);	
			// Act
			String name = player.getName();
			// Assert
			assertEquals(FEDERER,name);
		}
		
		@Test
		public void testPlayerScore() {
			// Arrange
			Player player = new Player(FEDERER,2);
			// Act
			int score = player.getScore();
			// Assert
			assertEquals(2,score);
		}
		
		@Test
		public void testIncrement() {
			// Arrange
			Player player = new Player(FEDERER,1);
			// Act
			player.incrementScore();
			// Assert
			assertEquals(2,player.getScore());
		}
		
		@Test
		public void testScoreZeroAsLove() {
			// Arrange
			Player player = new Player(FEDERER,0);
			// Act
			String scoreAsString = player.getScoreAsString();
			// Assert
			assertEquals("love",scoreAsString);
		}
		
		@Test
		public void testScoreOneAsFifteen() {
			// Arrange
			Player player = new Player(FEDERER,1);
			// Act
			String scoreAsString = player.getScoreAsString();
			// Assert
			assertEquals("fifteen",scoreAsString);
		}
		
		@Test
		public void testScoreThreeAsForty()
		{
			// Arrange
			Player player = new Player(FEDERER,3);
			// Act
			String scoreAsString = player.getScoreAsString();
			// Assert
			assertEquals("forty",scoreAsString);
		}
		
		@Test
		public void testInvalidNegativeScore()
		{
			// Arrange
			Player player = new Player(FEDERER,-1);
			// Act
			String scoreAsString = player.getScoreAsString();
			// Assert
			assertNull(scoreAsString);
		}
		
		@Test
		public void testInvalidPositiveScore()
		{
			// Arrange
			Player player = new Player(FEDERER,4);
			// Act
			String scoreAsString = player.getScoreAsString();
			// Assert
			assertNull(scoreAsString);
		}
		
		@Test
		public void testThereIsTie()
		{
			// Arange
			Player player1 = new Player(FEDERER, 2);
			Player player2 = new Player(NADAL, 2);
			// Act
			boolean tie = player1.isTieWith(player2);
			// Assert
			assertTrue(tie);
		}
	
		@Test
		public void testHasAtLeastFortyPoints()
		{
			// Arange
			Player player1 = new Player(FEDERER, 3);
			// Act
			boolean hasAtLeastFortyPoints = player1.hasAtLeastFortyPoints();
			// Assert
			assertTrue(hasAtLeastFortyPoints);
		}
		
		@Test
		public void testHasNotAtLeastFortyPoints()
		{
			// Arange
			Player player1 = new Player(FEDERER, 2);
			// Act
			boolean hasNotAtLeastFortyPoints = player1.hasAtLeastFortyPoints();
			// Assert
			assertFalse(hasNotAtLeastFortyPoints);
		}
		
		@Test
		public void testHasLessThanFortyPoints()
		{
			// Arange
			Player player1 = new Player(FEDERER, 2);
			// Act
			boolean hasLessThanFortyPoints = player1.hasLessThanFortyPoints();
			// Assert
			assertTrue(hasLessThanFortyPoints);
		}
		
		@Test
		public void testHasNotLessThanFortyPoints()
		{
			// Arange
			Player player1 = new Player(FEDERER, 3);
			// Act
			boolean hasNotLessThanFortyPoints = player1.hasLessThanFortyPoints();
			// Assert
			assertFalse(hasNotLessThanFortyPoints);
		}
		
		@Test
		public void testHasMoreThanFourtyPoints()
		{
			// Arange
			Player player1 = new Player(FEDERER, 4);
			// Act
			boolean hasMoreThanFourtyPoints = player1.hasMoreThanFourtyPoints();
			// Assert
			assertTrue(hasMoreThanFourtyPoints);
		}
		
		@Test
		public void testHasNotMoreThanFourtyPoints()
		{
			// Arange
			Player player1 = new Player(FEDERER, 3);
			// Act
			boolean hasNotMoreThanFourtyPoints = player1.hasMoreThanFourtyPoints();
			// Assert
			assertFalse(hasNotMoreThanFourtyPoints);
		}
		
		@Test
		public void testHasOnePointAdvantage()
		{
			// Arange
			Player player1 = new Player(FEDERER, 4);
			Player player2 = new Player(NADAL, 3);
			// Act
			boolean hasOnePointAdvantage = player1.hasOnePointAdvantageOn(player2);
			// Assert
			assertTrue(hasOnePointAdvantage);
		}
		
		@Test
		public void testHasNotOnePointAdvantage()
		{
			// Arange
			Player player1 = new Player(FEDERER, 3);
			Player player2 = new Player(NADAL, 3);
			// Act
			boolean hasNotOnePointAdvantage = player1.hasOnePointAdvantageOn(player2);
			// Assert
			assertFalse(hasNotOnePointAdvantage);
		}
		
		@Test
		public void testHasNotOnePointAdvantage2()
		{
			// Arange
			Player player1 = new Player(FEDERER, 3);
			Player player2 = new Player(NADAL, 5);
			// Act
			boolean hasNotOnePointAdvantage = player1.hasOnePointAdvantageOn(player2);
			// Assert
			assertFalse(hasNotOnePointAdvantage);
		}
		
		@Test
		public void testHasAtLeastTwoPointsAdvantageOn()
		{
			// Arange
			Player player1 = new Player(FEDERER, 5);
			Player player2 = new Player(NADAL, 3);
			// Act
			boolean hasAtLeastTwoPointsAdvantageOn = player1.hasAtLeastTwoPointsAdvantageOn(player2);
			// Assert
			assertTrue(hasAtLeastTwoPointsAdvantageOn);
		}
		
		@Test
		public void testHasAtLeastNotTwoPointsAdvantageOn()
		{
			// Arange
			Player player1 = new Player(FEDERER, 4);
			Player player2 = new Player(NADAL, 4);
			// Act
			boolean hasAtLeastNotTwoPointsAdvantageOn = player1.hasAtLeastTwoPointsAdvantageOn(player2);
			// Assert
			assertFalse(hasAtLeastNotTwoPointsAdvantageOn);
		}
		
		@Test
		public void testHasAtLeastNotTwoPointsAdvantageOn2()
		{
			// Arange
			Player player1 = new Player(FEDERER, 4);
			Player player2 = new Player(NADAL, 3);
			// Act
			boolean hasAtLeastNotTwoPointsAdvantageOn = player1.hasAtLeastTwoPointsAdvantageOn(player2);
			// Assert
			assertFalse(hasAtLeastNotTwoPointsAdvantageOn);
		}
}
