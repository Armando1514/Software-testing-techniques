
# Software-testing-techniques

Hi! In this repository i am going to analyze different techniques for  for  **Software Testing**.  
Exercise:  

**Specification based testing exercise**
 - [Tennis game](https://github.com/Armando1514/Software-testing-techniques/tree/master/TSTennisGame), [Pig latin documentation](https://github.com/Armando1514/Software-testing-techniques/blob/master/TennisGameDocumentation.pdf)
 -  [Triangle problem](https://github.com/Armando1514/Software-testing-techniques/tree/master/STTriangle), (explanation in theory, scroll down.)

**Code based testing exercise**
 - [Game of life](https://github.com/Armando1514/Software-testing-techniques/tree/master/CTGOL), [Game of life documentation](https://github.com/Armando1514/Software-testing-techniques/blob/master/GameOfLifeDocumentation.pdf)

**TDD exercise**
 - [Pig latin ](https://github.com/Armando1514/Software-testing-techniques/tree/master/TDDPiglatin), [Pig latin documentation](https://github.com/Armando1514/Software-testing-techniques/blob/master/PigLatinDoc.pdf)
 - [Fibonacci ](https://github.com/Armando1514/Software-testing-techniques/tree/master/TDDFibonacci), (explanation in theory, scroll down.)

For understand how read the exercise, I suggest reading the theory, **scroll down**.


# Specification based testing
Testing strategy  to design test based on system specifications without any reference to the internal structure of the system. The internal structure is unknow or ignored. It is also known as block-box testing. 
 
# Boundary value testing
The best-known specification based testing technique, it focuses on the boundary of the input domain to identify test cases. **Rationale**: Errors tend to occur near the boundary of the input domain. Four variants of boundary value testing:

 - Normal
 - Robust
 - Worst case
 - Robust worst case
## Normal boundary value testing
it only considers allowed input values:
 - Their min
 - Just above the min (min +)
 - Their nominal value (nom)
 - Just below their (max-)
 - Their max
 >**Note**: it is based on the **single fault assumption**: failures are only rarely the result of the co-occurrence of two (or more) faults.
 
 **How apply it?** 
 Holding the values of all the variables at nominal values, but  one variable at the nominal value, and letting that variable assume its min, min+, nom, max- and max. Repeat this process for each variable ( starting from three variable with nominal value, let one variable assume its full set of values, at the end, repeat the process).


## Robust boundary value testing
An extension of normal boundary value testing, always based on the single fault assumption, it aims to see what happens when the extremes are slightly exceeded: In addition to **min**, **min+**, **nom**, **max-**, and **max** values, it considers values just outside the variable boundaries: **min-**  and **max+**.

## Worst case boundary value testing
The single fault assumption is rejected. It considers the worst cases but within the variable boundaries (don't hold one variable at the nominal value and letting that assume different values, but let all the variables assume different values).

## Robust Worst case boundary value testing
The single fault assumption is rejected. It considers the worst cases within the variable boundaries and **just outside**.


# Equivalence class testing

Specification based testing technique relying on defining equivalence classes of the input domain (or also output range).
Formally, equivalence classes are mutually disjoint subsets; the union of which is the entire set (i.e. the input domain).
Four variants of equivalence class testing:
 - Weak normal
 - Strong normal
 - Weak robust
 - Strong robust
## Weak normal equivalence class testing
Based on the **single-fault** assumption (weak). To define test cases, select one value from each equivalence class of valid values.
## Strong normal equivalence class testing
Based on the **multiple-fault** assumption (strong). To define
test cases, select one element from the Cartesian product of the equivalence classes of valid values.
## Weak robust equivalence class testing
Based on the **single-fault** assumption. To define test cases, select one value from each equivalence class of both valid and invalid values (robust).
## Strong robust equivalence class testing
Based on the **multiple-fault** assumption. To define test cases, select one element from the Cartesian product of the equivalence classes of valid and invalid values.
# Example of boundary value testing and equivalence class testing, the triangle problem

**Problem**: The integers a, b, and c must satisfy the following **conditions**:

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
[ Link project.](https://github.com/Armando1514/Software-testing-techniques/blob/master/STTriangle)

## Normal Boundary value testing and robust boundary value testing

For n input variables in the normal boundary value we have **4n +1 ** test cases.
The implementation of normal boundary testing is in the directory below, i also provide an implementation of the robust boundary testing. 
[ Test cases for robust boundary testing and normal boundary testing.](https://github.com/Armando1514/Software-testing-techniques/blob/master/STTriangle/test/sT/BoundaryValueTestingTriangle.java) 

Remember that is specification based testing (**you must not read the implementation !**).
>**Note**: In the implementation we e never test if is or not scalene, because normal boundary  and robust boundary testing have a strong single fault assumption: failures are only rarely the result of the co-occurrence of two (or more faults) and scalene depends on 3 variables not at nominal value.

I didn't implement worst-case boundary value and robust worst-case value testing  because is too time consuming to implement, the first for  n input variables generates 5 ^ n test cases, by cause of  each variable that you are able to assign different values allowed in normal boundary value testing for the first, and robust boundary testing for the second , for example a=1, b=2, c=200.

## Weak normal equivalence class and weak robust equivalence class testing
 Four possible outputs can occur:
 * NotAtriangle
 * Scalene
 * Isosceles
 * Equilateral

Four equivalence classes of the output range.
Because no valid subIntervals of variables a, b and c exist, the strong  normal equivalence class test cases are identical to the weak normal equivalence class test cases (Strong robust too time consuming for implementation).
Here the implementation:
[ Test cases for equivalence class testing.](https://github.com/Armando1514/Software-testing-techniques/blob/master/STTriangle/test/sT/EquivalenceClassTesting.java) 

# Code based testing
Testing strategy to design test cases based on the internal structure of a system (or component). It is also known as **white-box** testing or structural testing. The technic that we analyse is **Control flow** testing. **Basic idea**: given a Control flow Graph (an abstract representation of all possible control flows through a component or system, where nodes are stataements and edges represent flows of control), define a **test coverage criterion** and devise test cases so as to meet it. 
## Statement testing
**Test coverage criterion**: each node in the CFG must be covered by a set of test cases at least once. Thus, each statement must be covered at least once.  **Intuition**: statements that have never been executed during testing may contain bugs.
## Branch testing
Is a stronger test coverage criterion. **Test coverage criterion**: each edge in the CFG must be covered by a set ot test cases at least once. Thus, each branch must be covered at least once. Branch coverage implies statement coverage.
## Condition testing
Is a stronger test coverage criterion. **Test coverage criterion**: each condition outcome (as true and false) in every decision statement must be covered by a set of test cases at least once. Compound conditions can be broken into simple conditions (each of which as true and false outcomes).
## Path testing
**Test coverage criterion**: each path in the CFG must be covered by a set of test cases at least once. Look that a number of paths i a system with loops is unbounded, it's necessary a feasible criteria to limit the number of paths to be covered (Loop boundary, cyclomatic complexity etc. ).

# Test driven development

 **Test driven development**, one of the most famous 
**Agile  development techniques**, proposed for the first time in 2002 by Kent Beck.\
It is an approach to software development in which developers interleave testing and code development. Developers (not testers) first write automated unit tests for small functionalities and then the associated production code.\
The aim of this repository is explains how use TDD and other technics, but first i need to clarify the way for read TDD test code.

This is the documentation of the PigLatin exercise:
[Pig latin documentation](https://github.com/Armando1514/Software-testing-techniques/blob/master/PigLatinDocumentation.pdf)
and here there is a project implemented:
[Project implemented](https://github.com/Armando1514/Software-testing-techniques/tree/master/TDDPiglatin)
> **Note**: I applied [the testing mutation](https://en.wikipedia.org/wiki/Mutation_testing) technique for evaluate the test case that i wrote, and the score was high. I suggest you to use it for comparison with your code . 

For understand the way to read it, please  read the explanation below for realize the path to apply TDD technique. 


## TDD Mantra
It is a vert short cycles of three phases:  

|                |                      |                 
|----------------|-------------------------------|
|**Red** phase|Write a failing unit test for a small chunk of functionality, which is not implemented yet (the test can fail but it has to compile).         |
|**Green** phase          |Make the unit test pass **quickly** (i.e., write the minimal amount of code to make the test pass).            |
|**Refactor** phase          |Eliminate all duplications and smells created in just getting the test to pass, run all tests.|\
> **Note**: Agile is an iterative approach to software development, in which software systems are built and delivered incrementally from the beginning of the project, one piece to once. If the last phase of the mantra "Refactor", is correctly implemented with all the test without failure, you are able to go to the next functionality. 

#


 

## Fibonacci, an example of TDD application
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


