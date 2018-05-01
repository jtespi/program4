
/***
* JUnit testing class for Circle2 and Circle.
* Author: Jacob Espinoza
* Date modified: 2018 April 30
***/

import org.junit.*;
import org.junit.Assert.*;
import org.hamcrest.CoreMatchers.*;

public class Circle2Test
{
   // Data needed for each test case
   // define variable circ2a of type Circle2
   private Circle2 circ2a;


// Set up each test case
//  prints a message and instantiates a new Circle1 object
@Before
public void setup()
{
   System.out.print("\nTest \'");
   circ2a = new Circle2(5,7,6);
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
   p = circ2a.moveBy(1,1);
   System.out.printf("Point p = %f, %f\n", p.x, p.y);
   Assert.assertTrue("Failure: centre point should be 6, 8", p.x == 6 && p.y == 8);
}


// Test a simple negative move
@Test
public void simpleMoveNeg()
{
   Point p;
   System.out.println("simpleMoveNeg\' starting...");
   p = circ2a.moveBy(-1,-1);
   System.out.printf("Point p = %f, %f\n", p.x, p.y);
   Assert.assertTrue("Failure: centre point should be 4, 6", p.x == 4 && p.y == 6);
}


// Test circle scaling up by a factor of 4
@Test
public void scaleUp() {
   double rad;
   System.out.println("scaleUp\' starting...");
   rad = circ2a.scale( 4 );
   System.out.printf(" radius is %f\n", rad);
   Assert.assertTrue("Failure: radius should be 24 (4 times 6)", rad == 24 );
}

// Test circle scaling down by a factor of 1/3
//
@Test
public void scaleDown() {
   double rad;
   double third = (double)1/(double)3;

   System.out.println("scaleDown\' starting...");
   rad = circ2a.scale( third );
   System.out.printf(" radius is %f\n", rad);
   Assert.assertTrue("Failure: radius should be 2 ( 1/3 of 6)", rad == 2 );
}

// Test circle scaling by a negative value (-5)
//
@Test
public void scaleNeg() {
   Double rad;
   Double negScalar = -5.0;

   System.out.println("scaleNeg\' starting...");
   rad = circ2a.scale( negScalar );
   System.out.printf("New rad = %f\n", rad);
   Assert.assertTrue("Failure, radius should not be negative", rad >= 0 );
}

// Test circle intersect on a circle that almost intersects
//
@Test
public void intersect1() {
   Circle2 circb = new Circle2(10, 14, 2.5);
  
   System.out.println("intersect1\' starting...");
   Assert.assertFalse("Failure: circles should not intersect", circ2a.intersects( circb ) );
}

// Test circle intersect on a circle with the same radius
//   but shifted down one unit (y-coordinate)
//
@Test
public void intersect2() {
   Circle2 circb = new Circle2(4,6,6);
  
   System.out.println("intersect2\' starting...");
   Assert.assertTrue("Failure: circles should intersect", circ2a.intersects( circb ) );
}

// Test circle intersect on a circle that does not touch
//
@Test
public void intersect3() {
   Circle2 circb = new Circle2(55,10,2);
  
   System.out.println("intersect3\' starting...");
   Assert.assertFalse("Failure: circles should not intersect", circ2a.intersects( circb ) );
}

} // end class Circle2Test

