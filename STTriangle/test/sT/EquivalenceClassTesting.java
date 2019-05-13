package sT;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EquivalenceClassTesting {
/**
 * Four possible outputs can occur:
 * NotAtriangle
 * Scalene
 * Isosceles
 * Equilateral
 * Four equivalence classes of the output range
 * Because no valid subIntervals of variables a, b and c exist, the strong  normal
 * equivalence class test cases are identical to the weak normal equivalence class test cases.
 */
	
	/* 
	 * We select one value from each equivalence class, i
	 * want start from NotATriangle i don't have to respect C4, C5, C6 conditions
	 */
	
	@Test
	public void testProblemResolution1()
	{
		int a = 1;
		int b = 10;
		int c = 12;
		
		Triangle triangle = new Triangle(a, b, c);
		
		assertEquals("NotATriangle",triangle.problemResolution());
		
	}
	
	/*
	 * Equilateral
	 * a = 10
	 * b = 10
	 * c = 10
	 */
	@Test
	public void testProblemResolution2()
	{
		int a = 10;
		int b = 10;
		int c = 10;
		
		Triangle triangle = new Triangle(a, b, c);
		
		assertEquals("Equilater",triangle.problemResolution());
		
	}
	
	/*
	 * Isosceles
	 * a = 10
	 * b = 10
	 * c = 1
	 */
	@Test
	public void testProblemResolution3()
	{
		int a = 10;
		int b = 10;
		int c = 1;
		
		Triangle triangle = new Triangle(a, b, c);
		
		assertEquals("Isosceles",triangle.problemResolution());
		
	}
	
	/*
	 * Scalene
	 * a = 10
	 * b = 20
	 * c = 1
	 */
	@Test
	public void testProblemResolution4()
	{
		int a = 10;
		int b = 9;
		int c = 8;
		
		Triangle triangle = new Triangle(a, b, c);
		
		assertEquals("Scalene",triangle.problemResolution());
		
	}
	/*
	 *  End of weak/strong normal equivalence class test cases 
	 */
	
	/*
	 * Weak robust equivalence class testing, considering the invalid values for a, b and c
	 * we select one value from each equivalence class of both valid and invalid values.
	 */
	
	/*
	 * Invalid Value
	 * a = 0
	 * b = 19
	 * c = 18
	 */
    @Test(expected = IllegalArgumentException.class)
	public void testProblemResolution6()
	{
		int a = 0;
		int b = 19;
		int c = 18;
		
	    new Triangle(a, b, c);
		
	}
	
	/*
	 * Invalid Value
	 * a = 19
	 * b = 0
	 * c = 18
	 */
    @Test(expected = IllegalArgumentException.class)
	public void testProblemResolution8()
	{
		int a = 19;
		int b = 0;
		int c = 18;
		
	    new Triangle(a, b, c);
		
	}
	/*
	 * Invalid Value
	 * a = 19
	 * b = 18
	 * c = 0
	 */
    @Test(expected = IllegalArgumentException.class)
	public void testProblemResolution9()
	{
		int a = 19;
		int b = 0;
		int c = 18;
		
	    new Triangle(a, b, c);
		
	}
	/*
	 * Invalid Value
	 * a = 201
	 * b = 18
	 * c = 19
	 */
    @Test(expected = IllegalArgumentException.class)
	public void testProblemResolution10()
	{
		int a = 201;
		int b = 18;
		int c = 19;
		
	    new Triangle(a, b, c);
		
	}
    /*
	 * Invalid Value
	 * a = 19
	 * b = 201
	 * c = 19
	 */
    @Test(expected = IllegalArgumentException.class)
	public void testProblemResolution11()
	{
		int a = 19;
		int b = 201;
		int c = 19;
		
	    new Triangle(a, b, c);
		
	}
    /*
	 * Invalid Value
	 * a = 29
	 * b = 18
	 * c = 201
	 */
    @Test(expected = IllegalArgumentException.class)
	public void testProblemResolution12()
	{
		int a = 29;
		int b = 18;
		int c = 201;
		
	    new Triangle(a, b, c);
		
	}
    /* End weak  robust equivalence class testing*/
}
