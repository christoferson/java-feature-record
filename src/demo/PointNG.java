package demo;

public record PointNG(int x, int y) {
	
// A record class declaration does not have an extends clause. The superclass of a record class is always java.lang.Record
// Even though a normal class can explicitly extend its implicit superclass Object, a record cannot explicitly extend any class, even its implicit superclass Record.
//public record PointNG(int x, int y) extends java.lang.Record { //Syntax error on token "extends", implements expected


}
