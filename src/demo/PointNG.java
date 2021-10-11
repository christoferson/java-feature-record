package demo;

public record PointNG(int x, int y) { 
	
// A record class declaration does not have an extends clause. The superclass of a record class is always java.lang.Record
// Even though a normal class can explicitly extend its implicit superclass Object, a record cannot explicitly extend any class, even its implicit superclass Record.
//public record PointNG(int x, int y) extends java.lang.Record { //Syntax error on token "extends", implements expected

// A record class is implicitly final, and cannot be abstract. 
// These restrictions emphasize that the API of a record class is defined solely by its state description, and cannot be enhanced later by another class.
//public abstract record PointNG(int x, int y) { // Illegal modifier for the record PointNG; only public, final and strictfp are permitted
	
// The fields derived from the record components are final. This restriction embodies an immutable by default policy that is widely applicable for data-carrier classes.	
	public void modify() {
		//this.x = this.x + 10; // The final field PointNG.x cannot be assigned
	}
}
