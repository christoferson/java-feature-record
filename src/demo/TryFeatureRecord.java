package demo;


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
	
}
