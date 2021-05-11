package ex2;

/**
 * @author Ronny Sivan  (ronny.sivan@gmail.com)
 *
 * @date Nov 10, 2018
 * 
 */

/**
 * Point2D - describe a point in the plane
 *
 */
public interface Point2D
{
   /**
    * getX - return the point's X coordinate in the Cartesian plane
    *
    * @return the point's X coordinate
    */
   public double getX();
   
   /**
    * setX - set the X coordinate of the point (without modifying 
    *        its Y coordinate)
    *
    * @param x the new X coordinate for the point
    */
   public void setX( double x );
   
   /**
    * getY - return the point's Y coordinate in the Cartesian plane
    *
    * @return the point's Y coordinate
    */
   public double getY();
   
   /**
    * setY - set the Y coordinate of the point (without modifying 
    *        its X coordinate)
    *
    * @param y the new Y coordinate for the point
    */
   public void setY( double y );
   
   /**
    * getRho - return the point's radius-vector in the polar plane
    *
    * @return the distance from the origin to the point
    */
   public double getRho();
   
   /**
    * setRho - set the radius-vector of the point, using the same phase, 
    *          essentially extending the vector in the direction it is
    *          pointing already. 
    *          This method may not be applied to the zero vector (0,0).
    *
    * @param rho the new distance from the origin to the point
    */
   public void setRho( double rho );
   
   /**
    * getPhi - return the point's phase in the polar plane.
    *          The phase of the zero vector (0,0) is also 0.
    *
    * @return  the counter-clockwise angle the vector makes with the 
    *          positive direction of the x axis
    */
   public double getPhi();
   
   /**
    * getTgPhi - return tan( phi ), which is sometimes easier to calculate.
    *
    * @return the tangent of the phase phi
    */
   public double getTanPhi();
   
   /**
    * setPhi - set the phase of the point without changing its radius-vector.
    *          Essentially it rotates the vector about the origin by the given 
    *          angle phi. 
    *          This method may not be applied to the zero vector (0,0)
    *
    * @param phi the angle by which to rotate the vector counter-clockwise 
    *          about the origin
    */
   public void setPhi( double phi );
   
   /**
    * distance - returns the distance between the two Point2D: this and p
    *
    * @param p the point to measure the distance to
    * @return the distance from this point to p
    */
   public double distance( Point2D p );
   
   /**
    * angle - returns the angle formed by the radius-vectors of 
    *         the two Point2D: this and p
    *
    * @param p
    * @return the (absolute value of) the distance berween this & p
    */
   public double angle( Point2D p );
   
   /**
    * middle - return the midpoint between this and p.
	*
	* @param param
	* @return the midpoint between this & p
	*/
   public Point2D middle( Point2D p );
}
