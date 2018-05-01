
public class Circle2 extends Circle
{

public Circle2(double x, double y, double radius)
{
   // FIXED: Super arguments were reversed
   //  used to be super(y,x,radius)
   super(x,y,radius);
}

public boolean intersects(Circle other)
{

  // CHANGED: Now uses the distance formula and compares against the sum of the radii
   double xDist = center.x - other.center.x;
  //System.out.printf("xDist = %f\n", xDist);
   double yDist = center.y - other.center.y;
  //System.out.printf("yDist = %f\n", yDist);
   double radiiSum = radius + other.radius;

   double distSquared = (xDist * xDist) + (yDist * yDist);

   double distD = Math.sqrt( distSquared );
  //System.out.printf("distD = %f\n", distD);
  //System.out.printf("radiiSum = %f\n", radiiSum);

   if ( distD <= radiiSum )
      return true;
   else
      return false;
}

}

