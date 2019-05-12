


# Software-testing-techniques

Hi! In this repository i'm going to analyze  different techniques for  **Software Testing**. The first is  **Test driven development**, one of the most famous 
**Agile  development techniques**, proposed for the first time in 2002 by Kent Beck.\
It is an approach to software development in which developers interleave testing and code development. Developers (not testers) first write automated unit tests for small functionalities and then the associated production code.\
The aim of this repository is explains how use TDD and other technics, but first i need to clarify the way for read TDD test code.

This is the specifics of the PigLatin Excercise:
[Pig latin specifics](https://github.com/Armando1514/Software-testing-techniques/blob/master/PigLatinSpecifics.pdf)
and here there is a project implemented:
[Project implemented](https://github.com/Armando1514/Software-testing-techniques/tree/master/TDDPiglatin)
> **Note**: I applied [the testing mutation](https://en.wikipedia.org/wiki/Mutation_testing) technique for evaluate the test case that i wrote, and the score was high. I suggest you to use it for comparison with your code . 

For understand the way to read it, please  read the explanation below for realize the path to apply TDD technique. 


# TDD Mantra
It is a vert short cycles of three phases:  

|                |                      |                 
|----------------|-------------------------------|
|**Red** phase|Write a failing unit test for a small chunk of functionality, which is not implemented yet (the test can fail but it has to compile).         |
|**Green** phase          |Make the unit test pass **quickly** (i.e., write the minimal amount of code to make the test pass).            |
|**Refactor** phase          |Eliminate all duplications and smells created in just getting the test to pass, run all tests.|\
> **Note**: Agile is an iterative approach to software development, in which software systems are built and delivered incrementally from the beginning of the project, one piece to once. If the last phase of the mantra "Refactor", is correctly implemented with all the test without failure, you are able to go to the next functionality. 

#


 

# Fibonacci, an example of TDD application
Let's apply TDD to the Fibonacci numbers, below the formula:

![fibonacci formula, part 1](https://latex.codecogs.com/svg.latex?\large&space;f_{0}&space;=&space;0,&space;\&space;if\&space;\&space;n&space;=&space;0)\
![fibonacci formula, part 2](https://latex.codecogs.com/svg.latex?\large&space;f_{0}&space;=&space;1,&space;\&space;if\&space;\&space;n&space;=&space;1)\
![fibonacci formula, part 3](https://latex.codecogs.com/svg.latex?\large&space;f_{n}&space;=&space;f_{n-1}&space;&plus;&space;f{n-2},&space;\&space;\&space;\&space;if\&space;n&space;>&space;1)

We don't care about invalid input values.
The IDE of reference is Eclipse with JUnit 4 library, the project to import, is into "TDDFibonacci" folder.\
The first chunck of functionality to implement is:

![fibonacci formula, part 1](https://latex.codecogs.com/svg.latex?\large&space;f_{0}&space;=&space;0,&space;\&space;if\&space;\&space;n&space;=&space;0)

We create into the **folder "test", a class named "FibonacciTest.java"** and we start to consider the **red phase** , this is an example of method that should be implemented : 

 ```java
public class FibonacciTest {
	
	private Fibonacci fibonacci;
	
	@Test
	public void value0ShouldReturn0() throws Exception {
		fibonacci = new Fibonacci();
		assertEquals(0,fibonacci.calculate(0));
	}
	
}
 ```
  Now, the test doesn't compile because the functionality is not implemented yet, for fix it we have to create the **class Fibonacci in the "src" folder**, and a method named "calculate" that just return null (in the green phase, we implement the correct way for pass the test, now we need only that the test compile).
   ```java
public class Fibonacci {

	public Object calculate(int i) {
		return null;
	}
	
}
 ```
 If we execute the test, it fails, but the code is correctly compiled. Let's go to the next step: **Green phase**. The test has to pass quickly, with the minimum amount of code. We just need a fake response (return 0) for allow the test to pass .
  ``` java
 public class Fibonacci {

	public Object calculate(int i) {
		return 0;
	}

}
 ```
 Try to launch the test and note that it just passes, but we need some refactoring. Here we make **Refactor phase**, just replace the method return parameter from "Object" to "int".
  ```java
  public class Fibonacci {

	public int calculate(int i) {
		return 0;
	}

}
  ```
  Run again the test and see if it fails, whether not, go to the next functionality, that is:

![fibonacci formula, part 2](https://latex.codecogs.com/svg.latex?\large&space;f_{0}&space;=&space;1,&space;\&space;if\&space;\&space;n&space;=&space;1)

**Red phase**:
```java
	@Test
	public void value1ShouldReturn1() throws Exception {
		fibonacci = new Fibonacci();
		assertEquals(1, fibonacci.calculate(1));
	}
```	

**Green phase**:

```java
	public int calculate(int i) {
		return i;
	}
```	
> **Note**: The other tests related to the functionality calculate, don't have to fail, make an abstraction, in this case if we put "return 1", the other test "value0ShouldReturn0" fails, for this reason we write "return i".
> 
**Refactor phase**:
Test code is also code, we need to refactor it!
```java
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
	
}
```	
Now we can implement the last functionality:

![fibonacci formula, part 3](https://latex.codecogs.com/svg.latex?\large&space;f_{n}&space;=&space;f_{n-1}&space;&plus;&space;f{n-2},&space;\&space;\&space;\&space;if\&space;n&space;>&space;1)\
**Red phase**
```java
	@Test
	public void value10ShouldReturn55() throws Exception {
			assertEquals(55, fibonacci.calculate(10));
	}
```	

**Green phase**
```java
	public int calculate(int i) {
		if(i == 0 || i == 1 )
		{
		return i;
		}
	    return calculate(i-1) + calculate(i-2);
	}
```
**Refactor phase**: none
> **Note**: 
Is this abstraction correct ? i don't know, but i can make further tests like "boundary testing or equivalence class testing". E.g. 
```java
	@Test 
	public void value3ShouldReturn2() throws Exception {
		assertEquals(2, fibonacci.calculate(3));
	}
```
>
Here there is the fibonacci exercise implemented :
[Fibonacci exercise](https://github.com/Armando1514/Software-testing-techniques/tree/master/TDDFibonacci)


