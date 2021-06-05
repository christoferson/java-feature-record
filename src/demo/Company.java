package demo;

import java.util.Objects;

public record Company(String name, String location) {

	public static String SECTOR_ENERGY = "Energy";
	
	public enum Sector { ENERGY, HEALTH; }

	static {
		System.out.println("Static Initializer : Company Rocks!");
	}
	
	//{ //System.out.println("Instance Initializer : Company Rocks!"); // Instance Initializer is not allowed in a record declaration }
	
	//private String sector; //User declared non-static fields sector are not permitted in a record
	
	// Compact Canonical Constructor
	public Company {
		if (name == null) {
			throw new IllegalArgumentException();
		}
	}
	
	public Company(String name) { this(name, "???");  }
	
	public static Company instance(String name, String location) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(location);
		return new Company(name, location);
	}
	
	public String json() {
		return String.format("{name:%s,location:%s}", name, location);
	}
	
	public void name(String name) {
		//this.name = name;  // The final field Company.name cannot be assigned
	}

}
