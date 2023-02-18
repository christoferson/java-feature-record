# java-feature-record
Demo of Java Feature Record from JDK14

## Declaration


```
public record Point(int x, int y) {

    //A private final field for each component of the state description;
    //private final int x;
    //private final int y;
	
	//private int z; // Error: User declared non-static fields z are not permitted in a record
 
	//A public constructor, whose signature is the same as the state description, which initializes each field from the corresponding argument;
    //Point(int x, int y) {
    //    this.x = x;
    //    this.y = y;
    //}
    
    //A public read accessor method for each component of the state description, with the same name and type as the component;
    public int x() { return x; }
    public int y() { return y; }
    
    //Implementations of equals and hashCode that say two records are equal if they are of the same type and contain the same state;
    
    // An implementation of toString that includes the string representation of all the record components, with their names.
    
}
```


[Point.java](/src/demo/Point.java)


## Instantiation

- Records are instantiated via the new keyword. 


## Restrictions and Limitations

- Records cannot extend any other class

- Records cannot declare instance fields other than the private final fields which correspond to components of the state description

- Any other fields which are declared in a Record must be static.

- Records are implicitly final, and cannot be abstract. 

- The components of a record are implicitly final. 


## Notes

- Records can be declared top level or nested

- If a record is nested, then it is implicitly static; this avoids an immediately enclosing instance which would silently add state to the record.

- Records can be generic

- Records can implement interfaces

- Records may declare static methods, static fields, static initializers, constructors, instance methods, and nested types. 

- The record, and the individual components in a state description, may be annotated.


## Explicitly declaring members of a record

- Any of the members that are automatically derived from the state description can also be declared explicitly.

