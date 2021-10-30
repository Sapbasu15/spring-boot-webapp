package com.rest.webservices.restfulwebservices.versioning;

public class Person_v1 {
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Person_v1(Name name) {
		super();
		this.name = name;
	}
}
