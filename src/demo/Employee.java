package demo;

public record Employee(String name, Address address) {
	public static record Address(String city) {}
}
