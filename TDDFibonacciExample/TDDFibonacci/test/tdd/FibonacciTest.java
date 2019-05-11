package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
	
	private Fibonacci fibonacci;
	
	@Before
	public void setUp() {
		fibonacci = new Fibonacci();
	}
	
	@Test
	public void value0ShouldReturn0() throws Exception {
		assertEquals(0,fibonacci.calculate(0));
	}
	
	@Test
	public void value1ShouldReturn1() throws Exception {
		assertEquals(1, fibonacci.calculate(1));
	}
	
	@Test 
	public void value3ShouldReturn2() throws Exception {
		assertEquals(2, fibonacci.calculate(3));
	}
	
	@Test
	public void value10ShouldReturn55() throws Exception {
			assertEquals(55, fibonacci.calculate(10));
	}
	
}
