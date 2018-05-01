
/***
* Example JUnit testing class for Circle1 (and Circle)
*
* - must have your classpath set to include the JUnit jarfiles
* - to run the test do:
*     java org.junit.runner.JUnitCore Circle1Test
* - note that the commented out main is another way to run tests
* - note that normally you would not have print statements in
*   a JUnit testing class; they are here just so you see what is
*   happening. You should not have them in your test cases.
***/

import org.junit.*;
import org.junit.Assert.*;
import org.hamcrest.CoreMatchers.*;

public class Circle1Test
{
   // Data needed for each test case
   private Circle1 circle1;


// Set up each test case
//  prints a message and instantiates a new Circle1 object
@Before
public void setup()
{
   System.out.print("\nTest \'");
   circle1 = new Circle1(1,2,3);
}

// Tear down each test case
//  print a message the test finished
@After
public void teardown()
{
   System.out.println("Test finished.");
}


// Test a simple positive move
@Test
public void simpleMove()
{
   Point p;
   System.out.println("simpleMove\' starting...");
   p = circle1.moveBy(1,1);
   System.out.printf("Point p = %f,%f\n", p.x, p.y);
   Assert.assertTrue("Failure: centre point should be 2, 3", p.x == 2 && p.y == 3);
}


// Test a simple negative move
@Test
public void simpleMoveNeg()
{
   Point p;
   System.out.println("simpleMoveNeg\' starting...");
   p = circle1.moveBy(-1,-1);
   System.out.printf("Point p = %f,%f\n", p.x, p.y);
   Assert.assertTrue("Failure: centre point should be 0, 1", p.x == 0 && p.y == 1);
}


// Test circle scaling up by a factor of 3
@Test
public void scaleUp() {
   double rad;
   System.out.println("scaleUp\' starting...");
   rad = circle1.scale( 3 );
   Assert.assertTrue("Failure: radius should be 9", rad == 9 );
}

// Test circle scaling down by a factor of half (0.5)
//
@Test
public void scaleDown() {
   double rad;
   System.out.println("scaleDown\' starting...");
   rad = circle1.scale( 0.5 );
   Assert.assertTrue("Failure: radius should be 1.5", rad == 1.5 );
}

// Test circle scaling by a negative value (-2)
//
@Test
public void scaleNeg() {
   Double rad;
   Double negScalar = -2.0;

   System.out.println("scaleNeg\' starting...");
   rad = circle1.scale( negScalar );
   System.out.printf("New rad = %f\n", rad);
   Assert.assertTrue("Failure, radius should not be negative", rad >= 0 );
}

// Test circle intersect on a circle that almost intersects
//
@Test
public void intersect1() {
   Circle1 circ2 = new Circle1(4,1,2);

   System.out.println("intersect1\' starting...");
   Assert.assertFalse("Failure: the circles should not intersect", circle1.intersects( circ2 ) );
}

// Test circle intersect on a circle with the same radius
//   but shifted down one unit (y-coordinate)
//
@Test
public void intersect2() {
   Circle1 circ2 = new Circle1(1,1,3);
  
   System.out.println("intersect2\' starting...");
   Assert.assertTrue("Failure: the circles intersect", circle1.intersects( circ2 ) );
}

// Test circle intersect on a circle that does not touch
//
@Test
public void intersect3() {
   Circle1 circ2 = new Circle1(5,10,2);
  
   System.out.println("intersect3\' starting...");
   Assert.assertFalse("Failure: the circles should not intersect", circle1.intersects( circ2 ) );
}

} // end Circle1Test.java

