package demo;

public record Point(int x, int y) {

    // Implicitly declared fields
    //private final int x;
    //private final int y;
	
	//private int z; // Error: User declared non-static fields z are not permitted in a record
 
	// Implicitly declared canonical constructor
    //Point(int x, int y) {
    //    this.x = x;
    //    this.y = y;
    //}
}
