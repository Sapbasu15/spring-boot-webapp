package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

	@GetMapping(value = "/param", params = "version=1")
	public Person_v1 getPersonV1() {
		return new Person_v1(new Name("Alex","Hunter"));
	}
	
	@GetMapping(value = "/param", params = "version=2")
	public Person_v2 getPersonV2() {
		return new Person_v2("Alex Hunter");
	}
	
	@GetMapping(value = "/header", headers = "X-API-VERSION=1")
	public Person_v1 getPersonV12() {
		return new Person_v1(new Name("Alex","Hunter"));
	}
	
	@GetMapping(value = "/header", headers = "X-API-VERSION=2")
	public Person_v2 getPersonV22() {
		return new Person_v2("Alex Hunter");
	}
	
	@GetMapping(value = "/produces", produces = "application/v1+json")
	public Person_v1 getPersonV13() {
		return new Person_v1(new Name("Alex","Hunter"));
	}
	
	@GetMapping(value = "/produces", produces = "application/v2+json")
	public Person_v2 getPersonV23() {
		return new Person_v2("Alex Hunter");
	}
}
