package demo;

public record PointStatic(int x, int y) {

    public static PointStatic ZERO = new PointStatic(0, 0);
    
    public static PointStatic ONE;
    
    static {
    	ONE = new PointStatic(1, 1);
    	System.out.println(ONE);
    }
    
}
