package sT;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoundaryValueTestingTriangle {

    /*
     * Normal Boundary value testing
     * min, min+, nom, max, max-
     */

    /* We hold c, and let its change
     * 1.
     * (a)nom = 100
     * (b)nom = 100
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution1()
    {
        int a = 100;
        int b = 100;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Equilater",triangle.problemResolution());

    }

    /* 2.
     * (a)nom = 100
     * (b)nom = 100
     * (c)min = 1
     */

    @Test
    public void testProblemResolution2()
    {
        int a = 100;
        int b = 100;
        int c = 1;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 3.
     * (a)nom = 100
     * (b)nom = 100
     * (c)min+ = 2
     */

    @Test
    public void testProblemResolution3()
    {
        int a = 100;
        int b = 100;
        int c = 2;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 4.
     * (a)nom = 100
     * (b)nom = 100
     * (c)max = 200
     */

    @Test
    public void testProblemResolution4()
    {
        int a = 100;
        int b = 100;
        int c = 200;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("NotATriangle",triangle.problemResolution());

    }

    /* 5.
     * (a)nom = 100
     * (b)nom = 100
     * (c)max- = 199
     */

    @Test
    public void testProblemResolution5()
    {
        int a = 100;
        int b = 100;
        int c = 199;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 6. keep b nominal, and let its change
     * (a)nom = 100
     * (b)min = 1
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution6()
    {
        int a = 100;
        int b = 1;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 7.
     * (a)nom = 100
     * (b)min+ = 2
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution7()
    {
        int a = 100;
        int b = 2;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 8.
     * (a)nom = 100
     * (b)max = 200
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution8()
    {
        int a = 100;
        int b = 200;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("NotATriangle",triangle.problemResolution());

    }

    /* 9.
     * (a)nom = 100
     * (b)max- = 199
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution9()
    {
        int a = 100;
        int b = 199;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 10.
     * Keep c at nominal value, and let its change
     * (a)nom = 100
     * (b)nom = 100
     * (c)min = 1
     */

    @Test
    public void testProblemResolution10()
    {
        int a = 100;
        int b = 100;
        int c = 1;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 11.
     * Keep c at nominal value, and let its change
     * (a)nom = 100
     * (b)nom = 100
     * (c)min+ = 2
     */

    @Test
    public void testProblemResolution11()
    {
        int a = 100;
        int b = 100;
        int c = 2;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 12.
     * Keep a at nominal value, and let its change
     * (a)min = 1
     * (b)nom = 100
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution12()
    {
        int a = 1;
        int b = 100;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }
    /* 13.
     * (a)min+ = 2
     * (b)nom = 100
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution13()
    {
        int a = 2;
        int b = 100;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /* 14.
     * (a)max = 200
     * (b)nom = 100
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution14()
    {
        int a = 200;
        int b = 100;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("NotATriangle",triangle.problemResolution());

    }

    /* 15.
     * (a)max- = 199
     * (b)nom = 100
     * (c)nom = 100
     */

    @Test
    public void testProblemResolution15()
    {
        int a = 199;
        int b = 100;
        int c = 100;

        Triangle triangle = new Triangle(a, b, c);

        assertEquals("Isosceles",triangle.problemResolution());

    }

    /*
     * End of Normal Boundary value testing
     * We never test if is or not scalenes, because normal boundary
     * testing has a strong single fault assumption:
     * Failures are only rarely the result of the co-occurrence of
     * two (or more faults)
     * and scalenes depends on 2 variables.
     */

    /*
     * Robust Boundary value testing
     * min-, min, min+, nom, max, max-, max+
     */

    /* We hold a, and let its change
     * 14.
     * (a)min- = 0
     * (b)nom = 100
     * (c)nom = 100
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProblemResolution16()
    {
        int a = 0;
        int b = 100;
        int c = 100;

        new Triangle(a, b, c);

    }

    /*
     * Robust Boundary value testing
     * min-, min, min+, nom, max, max-, max+
     */

    /*
     * 15.
     * (a)max+ = 201
     * (b)nom = 100
     * (c)nom = 100
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProblemResolution17()
    {
        int a = 201;
        int b = 100;
        int c = 100;

        new Triangle(a, b, c);

    }

    /* We hold b, and let its change
     * 16.
     * (a)nom = 100
     * (b)min- = 0
     * (c)nom = 100
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProblemResolution18()
    {
        int a = 100;
        int b = 0;
        int c = 100;

        new Triangle(a, b, c);

    }

    /*
     * 17.
     * (a)nom = 100
     * (b)max = 201
     * (c)nom = 100
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProblemResolution19()
    {
        int a = 100;
        int b = 201;
        int c = 100;

        new Triangle(a, b, c);

    }

    /* We hold b, and let its change
     * 18.
     * (a)nom = 100
     * (b)nom = 100
     * (c)max = 0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProblemResolution20()
    {
        int a = 100;
        int b = 100;
        int c = 0;

        new Triangle(a, b, c);

    }

    /* We hold b, and let its change
     * 19.
     * (a)nom = 100
     * (b)nom = 100
     * (c)max+ = 201
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProblemResolution21()
    {
        int a = 100;
        int b = 100;
        int c = 201;

        new Triangle(a, b, c);

    }
    /*
     * End of Robust Boundary value testing
     * We never test if is or not scalenes, because robust boundary
     * testing has still a strong single fault assumption:
     * Failures are only rarely the result of the co-occurrence of
     * two (or more faults)
     * and scalenes depends on 2 variables.
     */


}
