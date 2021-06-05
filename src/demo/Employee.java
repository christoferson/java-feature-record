package demo;

import demo.Employee.Address;

public record Employee(String name, Address address) {
	record Address(String city) {}
}
