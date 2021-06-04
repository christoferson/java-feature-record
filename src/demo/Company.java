package demo;

import java.util.Objects;

public record Company(String name, String location) {

	public static String SECTOR_ENERGY = "Energy";
	
	public enum Sector { ENERGY, HEALTH; }

	static {
		System.out.println("Company Rocks");
	}
	
	//private String sector; //User declared non-static fields sector are not permitted in a record
	
	public Company(String name) { this(name, "???");  }
	
	public static Company instance(String name, String location) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(location);
		return new Company(name, location);
	}
	
}
