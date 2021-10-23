package demo;

//A record class, and the components in its header, may be decorated with annotations. 
// Any annotations on the record components are propagated to the automatically derived fields, methods, 
// and constructor parameters, according to the set of applicable targets for the annotation. 
// Type annotations on the types of record components are also propagated to the corresponding type uses in the automatically derived members.
public record PointWithAnnotation(int x, int y, 
		@Deprecated String description) {


}
