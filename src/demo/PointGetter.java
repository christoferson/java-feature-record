package demo;

public record PointGetter(int x, int y) {

	public PointGetter {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(String.format("Both X and Y must be greater than 0. (%d,%d)", x, y));
        }
    }
	
	// bad style because its accessor methods "silently" adjust the state of a record instance
	public int x() {
		return (x > 28)? 28 : x;
	}

}
