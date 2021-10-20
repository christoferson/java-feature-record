package demo;

// A record class can declare nested types, including nested record classes. 
// If a record class is itself nested, then it is implicitly static; 
// this avoids an immediately enclosing instance which would silently add state to the record class.
public record PointOuter(int x, int y) {

    public record PontNested(int z) { // Implicitly static 
    	
    }
}
