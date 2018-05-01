
public class Circle1 extends Circle
{

public Circle1(double x, double y, double radius)
{
   super(x,y,radius);
}

public boolean intersects(Circle other)
{
   //FIXED: calculation of intersection uses different compares
   // before it used to compare that the x-value difference was less than the radius
   // now it compares the radius difference, calculated centre distance, and radius sum

   double xVal = Math.abs(center.x - other.center.x);
   double yVal = Math.abs(center.y - other.center.y);

   double diffR = Math.abs(radius - other.radius);
   double sumR = radius + other.radius;

   double distCntr = Math.sqrt( (xVal * xVal) + (yVal * yVal) );

   if ( (diffR <= distCntr) && ( distCntr <= sumR) )
      return true;
   return false;
}

}

