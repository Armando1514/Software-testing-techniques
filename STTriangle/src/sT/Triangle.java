package sT;
/*
Problem: The integers a, b, and c must satisfy the following **conditions**:

 - C1: 1<= a <= 200
 - C2: 1<= b <= 200
 - C3: 1<= c <= 200
 - C4: a < b + c
 - C5: b < a + c
 - C6: c < a + b

In an input value fails any of the conditions C1, C2 or C3, the program prints an error output message.

if values of a, b , and c satisfy conditions C4, C5, and C6, one of this three mutually exclusive outputs is given:

 - If all three sides are equal, the program output is Equilateral.
 - If just one pair of sides is equal, the program output is isosceles
 - If no pair of sides is equal, the program output is Scalene

In any conditions C4, C5 and C6 is not met, the program output is NotATriangle.

 */
public class Triangle {

	public Triangle(int a, int b, int c) throws IllegalArgumentException
	{
		if(legalValue(a) && legalValue(b) && legalValue(c))
		{
			this.setA(a);
			this.setB(b);
			this.setC(c);
		}
		else
			throw new IllegalArgumentException("Error output message: no legal values");
	}
	
	private int a;
	private int b;
	private int c;
	
	public Boolean legalValue(int x)
	{
		if(x >= 1 && x <= 200)
			return true;
		else
			return false;
	}
	
	public String problemResolution()
	{
		int x = this.getA();
		int y = this.getB();
		int z = this.getC();
		
		if(satisfactionCondition(x, y, z))
		{	
			if((x == y) &&(x == z))
				return "Equilater";
			else if ((x == y && x != z ) || (x == z && y != z ) || (y == z && x != z ))
				return "Isosceles";
			else 
				return "Scalene";
		}
		else
			return "NotATriangle";
	}
	
	public boolean satisfactionCondition(int x, int y, int z)
	{
		if(x < y + z)
			return true;
		else if(y < x + z)
			return true;
		else if(z < x + y)
			return true;
		else
			return false;
					
	}
	
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
	
}

