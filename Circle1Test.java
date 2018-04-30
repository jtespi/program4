
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

public class Circle1Test
{
   // Data needed for each test case
   private Circle1 circle1;


// Set up each test case
//  prints a message and instantiates a new Circle1 object
@Before
public void setup()
{
   System.out.println("\nTest starting...");
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
   System.out.println("Running test simpleMove.");
   p = circle1.moveBy(1,1);
   Assert.assertTrue(p.x == 2 && p.y == 3);
}


// Test a simple negative move
@Test
public void simpleMoveNeg()
{
   Point p;
   System.out.println("Running test simpleMoveNeg.");
   p = circle1.moveBy(-1,-1);
   Assert.assertTrue(p.x == 0 && p.y == 1);
}


// Test circle scaling up by a factor of 3
@Test
public void scaleUp() {
   double rad;
   System.out.println("Running test scaleUp.");
   rad = circle1.scale( 3 );
   Assert.assertTrue( rad == 9 );
}

// Test circle scaling down by a factor of half (0.5)
//
@Test
public void scaleDown() {
   double rad;
   System.out.println("Running test scaleDown.");
   rad = circle1.scale( 0.5 );
   Assert.assertTrue( rad == 1.5 );
}

// Test circle scaling by a negative value (-2)
//
@Test
public void scaleNeg() {
   double rad;
   System.out.println("Running test scaleNeg.");
   rad = circle1.scale( -2 );
   Assert.assertFalse( rad == -6 );
}

// Test circle intersect on an overlapping circle
//   The other circle has the exact same dimensions
@Test
public void intersect1() {
   Circle1 circ2 = new Circle1(1,2,3);
  
   System.out.println("Running test intersect1.");
   Assert.assertTrue( circle1.intersects( circ2 ) );
}

// Test circle intersect on a circle with the same radius
//   but shifted down one unit (y-coordinate)
//
@Test
public void intersect2() {
   Circle1 circ2 = new Circle1(1,1,3);
  
   System.out.println("Running test intersect2.");
   Assert.assertTrue( circle1.intersects( circ2 ) );
}

// Test circle intersect on a circle that does not touch
//
@Test
public void intersect3() {
   Circle1 circ2 = new Circle1(5,10,2);
  
   System.out.println("Running test intersect3.");
   Assert.assertFalse( circle1.intersects( circ2 ) );
}

/*** NOT USED
public static void main(String args[])
{
   try {
      org.junit.runner.JUnitCore.runClasses(
               java.lang.Class.forName("Circle1Test"));
   } catch (Exception e) {
      System.out.println("Exception: " + e);
   }
}
***/

}

