package com.version1.rest.webservices.restfulwebservices.hello;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping(path="hello-world")
	public String HelloWorld() {
		return "hello";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("hello");
	}
	
	@GetMapping(path="hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("hello " + name);
	}
	
	
	@GetMapping(path="hello-world-inter")
	public String HelloWorldInter() {
		
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		
	}
}
