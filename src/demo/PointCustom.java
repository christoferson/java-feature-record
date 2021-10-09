package demo;

public record PointCustom(int x, int y) {

	// Custom canonical constructor
	public PointCustom(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(String.format("Both X and Y must be greater than 0. (%d,%d)", x, y));
        }
        this.x = x + 1;
        this.y = y + 2;
    }

}
