package ex2;

/**
 * @author Ronny Sivan (ronny.sivan@gmail.com)
 *
 * @date 15 April 2021
 * 
 */

import java.util.Formatter;

/**
 * Main - test implementations of Point2D
 *
 */
public class Main
{
   /**
    * toString - convert a double value to String in %'len'.'frac'f format
    *            it also rounds numbers that are very close to integral values
    *
    * @param d the value to convert
    * @param len the total length of the field
    * @param frac the length of the fraction part
    * @return a String with formatted value
    */
   public static String toString( double d, int len, int frac )
   {
      StringBuilder sb = new StringBuilder();
      Formatter formatter = new Formatter( sb );
      if( Math.abs( d - Math.round( d ) ) < 1.0E-8 )
         d = Math.round( d );
      
      String fmt = "%"+ len + "." + frac + "f";

      formatter.format( fmt, d );
      return( sb.toString() );
   }
   
   /**
    * toString - create a String describing a Point2D
    *
    * @param p the point to describe
    * @return a String in the form "(x,y)"
    */
   public static String toString( Point2D p )
   {
      return( "(" + toString( p.getX(), 4 , 2 ) + "," + toString( p.getY(), 4, 2 ) + ")" );
   }

   /**
    * main
    *
    * @param args
    */
   public static void main( String[] args )
   {
      Point2D[] list = new Point2D[8];
      Point2D p1 = null;
      Point2D p2 = null;

      double[][] coords =
      {
               { 2.5, 2.5 },
               { 3, 3 },
               { 0, 3 },
               { 3, 0 },
               { 3, 4 },
               { 1.5, 3.5 },
               { Math.sqrt( 13 ), Math.sqrt( 23 ) },
               { Math.PI, Math.E } };

      if( args[0].equals( "c" ) )
      {
         System.out.println( "Cartesian representation" );

         for( int i = 0; i < coords.length; i++ )
            list[i] = new Cartesian( coords[i][0], coords[i][1] );
         
         p1 = new Cartesian( 1, 7 );
         p2 = new Cartesian( 2, 4 );
      }
      else if( args[0].equals( "p" ) )
      {
         System.out.println( "Polar representation" );

         for( int i = 0; i < coords.length; i++ )
         {
            double x = coords[i][0];
            double y = coords[i][1];
            if( x == 0 )
               list[i] = new Polar( Math.hypot( x, y ), Math.PI / 2 );
            else
               list[i] = new Polar( Math.hypot( x, y ), Math.atan2( y, x ) );
         }
         p1 = new Polar( Math.hypot( 1, 7 ), Math.atan2( 7, 1 ) );
         p2 = new Polar( Math.hypot( 2, 4 ), Math.atan2( 4, 2 ) );
      }
      else if( args[0].equals( "m" ) )
      {
         System.out.println( "Mixed representation" );

         for( int i = 0; i < coords.length; i++ )
         {
            double x = coords[i][0];
            double y = coords[i][1];

            if( i % 2 == 0 )
               list[i] = new Cartesian( coords[i][0], coords[i][1] );
            else
            {
               if( x == 0 )
                  list[i] = new Polar( Math.hypot( x, y ), Math.PI / 2 );
               else
                  list[i] = new Polar( Math.hypot( x, y ), Math.atan2( y, x ) );
            }
         }
          
         p1 = new Polar( Math.hypot( 1, 7 ), Math.atan2( 7, 1 ) );
         p2 = new Cartesian( 2, 4 );
     }
      else
      {
         System.out.println( "Usage: Main { c | p | m }" );
         System.out.println( "<" + args[0] + ">" );
         System.exit( 0 );
      }

      int len = 8;
      int frac = len - 3;
      
      for( Point2D p : list )
         System.out.println( "[Cartesian]: " + toString( p ) + 
                             " = [Polar] (" + toString( p.getRho(), len, frac ) + "," + toString( p.getPhi(), len, frac ) + ")" );

      for( Point2D p : list )
         for( Point2D q : list )
            if( ! p.equals( q ) )
            {
               System.out.println( "distance between " + toString( p ) + " and " + toString( q )
                                 + " is " + toString( p.distance( q ), len, frac ) );
            }

      for( Point2D p : list )
          for( Point2D q : list )
             if( ! p.equals( q ) )
             {
                System.out.println( "angle between " + toString( p ) + " and " + toString( q )
                                  + " is " + toString( p.angle( q ), len, frac ) );
             }
  
      	

      for( Point2D p : list )
          for( Point2D q : list )
             if( ! p.equals( q ) )
             {
                System.out.println( "midpoint between " + toString( p ) + " and " + toString( q )
                                  + " is " + toString( p.middle( q ) ) );
             }

      list[0].setX( 3 * list[0].getX() );
      list[1].setY( 1.5 * list[1].getY() );
      list[2].setX( 5 );
      list[2].setY( 19 );
      list[3].setPhi( 1.3 * list[3].getPhi() );
      list[4].setRho( 2.7 * list[4].getRho() );
      list[5].setX( 7.8 );
      list[5].setRho( 7.8 );
      list[6].setY( Math.PI / Math.E );
      list[7].setPhi( Math.PI / 7 );

      for( Point2D p : list )
         System.out.println( "[Cartesian]: " + toString( p ) + 
                             " = [Polar] (" + toString( p.getRho(), len, frac ) + "," + toString( p.getPhi(), len, frac ) + ")" );
      
      System.out.println( "p1 = " + toString( p1 ) );
      System.out.println( "setting p1.x to 9" );
      p1.setX( 9 );
      System.out.println( "p1 = " + toString( p1 ) );
      System.out.println( "setting p.y to 3.6" );
      p1.setY( 3.6 );
      System.out.println( "p1 = " + toString( p1 ) );
      
      System.out.println( "p2 = [Cratesian]: " + toString( p2 ) + 
                          "   [Polar]: (" + toString( p2.getRho(), len, frac ) + "," + toString( p2.getPhi(), len, frac ) + ")" );
      System.out.println( "setting p2.rho to Math.PI/4" );
      p2.setRho( Math.PI / 4 );
      System.out.println( "p2 = [Cratesian]: " + toString( p2 ) + 
                          "   [Polar]: (" + toString( p2.getRho(), len, frac ) + "," + toString( p2.getPhi(), len, frac ) + ")" );
      System.out.println( "setting p2.phi to 30 degrees (" + Math.PI/6 + ")" );
      p2.setPhi( Math.PI / 6 );
      System.out.println( "p2 = [Cratesian]: " + toString( p2 ) + 
              
    		  "   [Polar]: (" + toString( p2.getRho(), len, frac ) + "," + toString( p2.getPhi(), len, frac ) + ")" );
      
   }
}
