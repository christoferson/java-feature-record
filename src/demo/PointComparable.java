package demo;

import java.util.Comparator;

// A record class can implement interfaces. 
public record PointComparable(int x, int y) implements Comparable<PointComparable> {

	@Override
	public int compareTo(PointComparable o) {
		if (this == o) { 
	        return 0; 
		}

		return Comparator
				.comparingInt(PointComparable::x)
				.thenComparingInt(PointComparable::y)
				.compare(this, o);
	}

}
