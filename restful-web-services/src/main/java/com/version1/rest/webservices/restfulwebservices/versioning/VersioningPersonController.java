package com.version1.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	
	@GetMapping("v1/person")
	public PersonV1 getPersonVersionOne() {
		return new PersonV1("Chinmai");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getPersonVersionSecond() {
		return new PersonV2(new Name("chinmai","Kanala"));
	}
	
	@GetMapping(path = "person", params="version=1")
	public PersonV1 getPersonVersionOneRequestParameter() {
		return new PersonV1("Chinmai");
	}
	
	@GetMapping(path = "person", params="version=2")
	public PersonV2 getPersonVersionSecondRequestParameter() {
		return new PersonV2(new Name("Chinmai","kanala"));
	}
	
	@GetMapping(path = "person/headers", headers="X-API-VERSION=1")
	public PersonV1 getPersonVersionOneRequestHeader() {
		return new PersonV1("Chinmai");
	}
	
	@GetMapping(path = "person/headers", headers="X-API-VERSION=2")
	public PersonV2 getPersonVersionSecondrequestHeader() {
		return new PersonV2(new Name("Chinmai","kanala"));
	}
	
	
	@GetMapping(path = "person/accept", produces="application/vnd.company.app-v1+json")
	public PersonV1 getPersonVersionOneAcceptHeader() {
		return new PersonV1("Chinmai");
	}
	
	@GetMapping(path = "person/accept", produces="application/vnd.company.app-v2+json")
	public PersonV2 getPersonVersionSecondAcceptHeader() {
		return new PersonV2(new Name("Chinmai","kanala"));
	}
	
}
