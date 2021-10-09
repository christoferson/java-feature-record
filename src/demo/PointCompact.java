package demo;

public record PointCompact(int x, int y) {

	// Compact canonical constructor
	// Must be public or Error Cannot reduce the visibility of a canonical constructor PointCompact from that of the record
	
	public PointCompact {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(String.format("Both X and Y must be greater than 0. (%d,%d)", x, y));
        }
        // No need to assign X and Y to private member variables
        //this.x = x; // Error: Illegal explicit assignment of a final field x in compact constructor
    }

}
