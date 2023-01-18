public class ZZZZZnake {

  @SuppressWarnings( "resource" )
  public static void main( String[] args ) {
    java.awt.Point playerPosition = new java.awt.Point( 10, 9 ); // 1)
    java.awt.Point snakePosition = new java.awt.Point( 30, 2 );
    java.awt.Point goldPosition = new java.awt.Point( 6, 6 );
    java.awt.Point doorPosition = new java.awt.Point( 0, 5 );
    boolean rich = false;

    while ( true ) { // 2)
      // Raster mit Figuren zeichnen

      for ( int y = 0; y < 10; y++ ) {
        for ( int x = 0; x < 40; x++ ) {
          java.awt.Point p = new java.awt.Point( x, y ); // 3)
          if ( playerPosition.equals( p ) )
            System.out.print( '&' );
          else if ( snakePosition.equals( p ) )
            System.out.print( 'S' );
          else if ( goldPosition.equals( p ) )
            System.out.print( '$' );
          else if ( doorPosition.equals( p ) )
            System.out.print( '#' );
          else System.out.print( '.' );
        }
        System.out.println();
      }

      // Status feststellen

      if ( rich && playerPosition.equals( doorPosition ) ) {
        System.out.println( "Gewonnen!" );
        return; // 4)
      }
      if ( playerPosition.equals( snakePosition ) ) {
        System.out.println( "ZZZZZZZ. Die Schlange hat dich!" );
        return;
      }
      if ( playerPosition.equals( goldPosition ) ) {
        rich = true;
        goldPosition.setLocation( -1, -1 );
      }

      // Konsoleneingabe und Spielerposition verändern

      switch ( new java.util.Scanner( System.in ).next() ) { //
	    // Spielfeld ist im Bereich 0/0 .. 39/9
        case "h" : playerPosition.y = Math.max(  0, playerPosition.y - 1 ); break; // 5) warum max?
        case "t" : playerPosition.y = Math.min(  9, playerPosition.y + 1 ); break; 
        case "l" : playerPosition.x = Math.max(  0, playerPosition.x - 1 ); break; 
        case "r" : playerPosition.x = Math.min( 39, playerPosition.x + 1 ); break; 
      }

      // Schlange bewegt sich Richtung Spieler

      if ( playerPosition.x < snakePosition.x )
        snakePosition.x--; // 6) --?
      else if ( playerPosition.x > snakePosition.x )
        snakePosition.x++;
      if ( playerPosition.y < snakePosition.y )
        snakePosition.y--;
      else if ( playerPosition.y > snakePosition.y )
        snakePosition.y++;
    } // end while
  }
}