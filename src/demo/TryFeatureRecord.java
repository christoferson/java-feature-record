package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import demo.PointOuter.PontNested;

// https://openjdk.java.net/jeps/395
// Goals
// object-oriented construct that expresses a simple aggregation of values.
// modeling immutable data rather than extensible behavior.
// comes with data-driven methods such as equals and accessors.
// Preserve long-standing Java principles such as nominal typing and migration compatibility.
// Description
// The declaration of a record class primarily consists of a declaration of its state; the record class then commits to an API that matches that state.
// Declaration
// a record class declaration consists of a name, optional type parameters, a header, and a body.
// header lists the components of the record class, which are the variables that make up its state
// Effect
// For each component in the header, two members: a public accessor method with the same name and return type as the component, and a private final field with the same type as the component;
// A canonical constructor whose signature is the same as the header, and which assigns each private field to the corresponding argument from a new expression which instantiates the record;
// equals and hashCode methods which ensure that two record values are equal if they are of the same type and contain equal component values; and
// A toString method that returns a string representation of all the record components, along with their names.
public class TryFeatureRecord {
	
	public static void main(String[] args) {
		
		tryImplicitCanonicalConstructor();
		
		tryCompactCanonicalConstructor();
		
		tryCustomCanonicalConstructor();
		
		tryConstructor();
		
		tryAccessors();
		
		tryConstructorOverload();
		
		tryEqualityAndHash();
		
		tryInstanceMethod();
		
		tryStaticFields();
		
		tryStaticMethod();
		
		tryNestedRecord();
		
		tryGeneric();
		
		tryGenericNestedRecord();
		
		tryStatic();
		
		tryRecordImplementsComparable();
		
		tryRecordNested();
		
		tryLocalRecord();
		
		tryEquals();
		
		// See {@link Class#isRecord()} and {@link Class#getRecordComponents()} for more details.

	}
	
	private static void tryImplicitCanonicalConstructor() {
		System.out.println("------- TryImplicitConstructor -----");
		Point point = new Point(35, 26);
		System.out.println("public Point(int x, int y) { this.x = x; this.y = y; } new Point(35, 26) : " + point);
	}
	
	private static void tryCompactCanonicalConstructor() {
		System.out.println("------- TryCompactCanonicalConstructor -----");
		PointCompact point = new PointCompact(35, 26);
		System.out.println("public PointCompact { if (x < 0 || y < 0) { ... } } new PointCompact(35, 26) : " + point);
	}
	// 
	private static void tryCustomCanonicalConstructor() {
		System.out.println("------- TryCustomCanonicalConstructor -----");
		PointCustom point = new PointCustom(35, 26);
		System.out.println("public PointCustom { if (x < 0 || y < 0) { ... } } new PointCompact(35, 26) : " + point);
	}
	
	private static void tryConstructor() {
		System.out.println("------- TryConstructor -----");
		Company company = new Company("Acme", "California");
		System.out.println(company);
	}
	
	private static void tryAccessors() {
		System.out.println("------- TryAccessors -----");
		Company company = new Company("Acme", "California");
		System.out.println(company.name());
		System.out.println(company.location());
		PointGetter point = new PointGetter(35, 26);
		System.out.println("new PointGetter(35, 26) : x=" + point.x());
		System.out.println("new PointGetter(35, 26) : y=" + point.y());		
	}
	
	private static void tryConstructorOverload() {
		Company company = new Company("Acme");
		System.out.println(company);
	}
	
	private static void tryEqualityAndHash() {
		Company company1 = new Company("Acme", "California");
		Company company2 = new Company("Acme", "California");
		System.out.println(company1.equals(company2));
		System.out.println(company1.hashCode() + " : " + (company1.hashCode() == company2.hashCode()));
	}
	
	private static void tryInstanceMethod() {
		Company company = new Company("Acme", "California");
		System.out.println(company.json());
	}
	
	private static void tryStaticFields() {
		System.out.println(Company.SECTOR_ENERGY);
		System.out.println(Company.Sector.HEALTH);
	}
	
	private static void tryStaticMethod() {
		Company company = Company.instance("Acme", "California");
		System.out.println(company);
	}
	
	private static void tryNestedRecord() {
		
		Employee employee = new Employee("John", new Employee.Address("California"));
		System.out.println(employee);
		System.out.println(employee.address());
	}
	
	public static void tryGeneric() {
		
		PointGeneric<Integer, String> point = new PointGeneric<>(5, "foo");
		
		System.out.println(point.x());
		System.out.println(point.y());
		System.out.println(point);
	}
	
	public static void tryGenericNestedRecord() {
		
		List<Table.Row<String>> rows = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Table.Row<String> row = new Table.Row<>(Arrays.asList("C"+i));
			rows.add(row);
		}
		
		Table<String> table = new Table<>(rows);
		rows.add(new Table.Row<String>(Arrays.asList("D1", "D2")));
		table.add(new Table.Row<String>(Arrays.asList("E1", "E2")));
		
		System.out.println(table);
		System.out.println(table.rows());
		System.out.println(table.rowAt(0));
		System.out.println(table.rowAt(3));
		System.out.println(table.rowAt(0).valueAt(0));
	}	
	
	public static void tryStatic() {
		
		PointStatic point = PointStatic.ZERO;
		
		System.out.println(point.x());
		System.out.println(point.y());
		System.out.println(point);
	}
	
	public static void tryRecordImplementsComparable() {
		PointComparable point1 = new PointComparable(34, 23);
		PointComparable point2 = new PointComparable(34, 23);
		PointComparable point3 = new PointComparable(34, 24);
		System.out.println(point1.compareTo(point2));
		System.out.println(point2.compareTo(point3));
	}
	
	public static void tryRecordNested() {
		System.out.println("------- TryNestedRecord -----");
		PontNested nested = new PontNested(5);
		System.out.println(nested);
	}
	
	
	public static void tryRecordWithAnnotation() {
		System.out.println("------- TryRecordWithAnnotation -----");
		PointWithAnnotation point = new PointWithAnnotation(3, 8, "val");
		System.out.println(point.description());
	}
	
	public static void tryLocalRecord() {
		System.out.println("------- TryLocalRecord -----");
		record PointLocal(int x, int y) { }
		List<PointLocal> points = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			var point = new PointLocal(i, i*2);
			points.add(point);
		}
		System.out.println(points);
	}
	
	private static void tryEquals() {
		System.out.println("------- TryEquals -----");
		Point point1 = new Point(35, 26);
		Point point2 = new Point(35, 26);
		Point point3 = new Point(35, 27);
		System.out.println("point1.equals(point2): " + point1.equals(point2));
		System.out.println("point1.equals(point3): " + point1.equals(point3));
	}
	
}
