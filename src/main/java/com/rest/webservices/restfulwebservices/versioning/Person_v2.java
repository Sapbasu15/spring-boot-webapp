package com.rest.webservices.restfulwebservices.versioning;

public class Person_v2 {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person_v2(String name) {
		super();
		this.name = name;
	}
}
