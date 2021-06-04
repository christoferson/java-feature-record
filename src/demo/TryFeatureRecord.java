package demo;

public class TryFeatureRecord {
	
	public static void main(String[] args) {
		Company company = new Company("Acme", "California");
		System.out.println(company.name());
		System.out.println(company.location());
		System.out.println(company);
		
		tryConstructorOverload();
		
		tryEqualityAndHash();
		
		tryStaticFields();
		
		tryStaticMethod();
		
		tryNestedRecord();
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
