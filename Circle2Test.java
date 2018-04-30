
/***
* JUnit testing class for Circle2 and Circle.
* Author: Jacob Espinoza
* Date modified: 2018 April 30
***/

import org.junit.*;

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
   System.out.println("\nTest starting...");
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
   System.out.println("Running test simpleMove.");
   p = circ2a.moveBy(1,1);
   System.out.printf("Point p = %f,%f\n", p.x, p.y);
   Assert.assertTrue(p.x == 6 && p.y == 8);
}


// Test a simple negative move
@Test
public void simpleMoveNeg()
{
   Point p;
   System.out.println("Running test simpleMoveNeg.");
   p = circ2a.moveBy(-1,-1);
   System.out.printf("Point p = %f,%f\n", p.x, p.y);
   Assert.assertTrue(p.x == 4 && p.y == 6);
}


// Test circle scaling up by a factor of 4
@Test
public void scaleUp() {
   double rad;
   System.out.println("Running test scaleUp.");
   rad = circ2a.scale( 4 );
   Assert.assertTrue( rad == 24 );
}

// Test circle scaling down by a factor of 1/3
//
@Test
public void scaleDown() {
   double rad;
   double third = (double)1/(double)3;
   System.out.println("Running test scaleDown.");
   rad = circ2a.scale( third );
   System.out.printf("New radius is %f\n", rad);
   Assert.assertTrue( rad == 2 );
}

// Test circle intersect on an overlapping circle
//   The other circle has the exact same dimensions
@Test
public void intersect1() {
   Circle2 circb = new Circle2(5,7,6);
  
   System.out.println("Running test intersect1.");
   Assert.assertTrue( circ2a.intersects( circb ) );
}

// Test circle intersect on a circle with the same radius
//   but shifted down one unit (y-coordinate)
//
@Test
public void intersect2() {
   Circle2 circb = new Circle2(4,6,6);
  
   System.out.println("Running test intersect2.");
   Assert.assertTrue( circ2a.intersects( circb ) );
}

// Test circle intersect on a circle that does not touch
//
@Test
public void intersect3() {
   Circle2 circb = new Circle2(55,10,2);
  
   System.out.println("Running test intersect3.");
   Assert.assertFalse( circ2a.intersects( circb ) );
}

} // end class Circle2Test

